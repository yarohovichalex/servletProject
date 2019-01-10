package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR_PAGE_EXIST;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_NAME_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_NEW_LOGIN;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_NEW_PASSWORD;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_SURNAME_USER;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class DoRegistrationActionProcessor implements IActionProcessor
{
    private static final String ACTION = "doRegistration";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    private static final String source = new String(
            "D:\\Kursy\\simpleLogin\\src\\main\\webapp\\userImage\\");

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        String defaultImage = "default.png";
        try
        {
            Part filePart = request.getPart("file");
            if (filePart.getSize() != 0)
            {
                System.out.println("image not null");
                defaultImage = getIndexedImageName();
                try (InputStream is = filePart.getInputStream();
                        OutputStream os = new FileOutputStream(source + defaultImage))
                {
                    byte[] content = new byte[is.available()];
                    is.read(content);
                    os.write(content);
                }
            }
        }
        catch (IOException | ServletException e)
        {
            // ???
            throw new IllegalStateException(e);
        }

        String login = request.getParameter(REQUEST_NEW_LOGIN);
        if (loginVerification(login)){
            return PAGE_ERROR_PAGE_EXIST;
        }
        String password = request.getParameter(REQUEST_NEW_PASSWORD);
        String name = request.getParameter(REQUEST_NAME_USER);
        String surname = request.getParameter(REQUEST_SURNAME_USER);

        HttpSession session = request.getSession();
        User user = new User(name, surname, login, password, getCorrectAdress(defaultImage));
        bookService.createUser(user);
        session.setAttribute("user_image", user.getImageAdres());
        session.setAttribute("user_name", user.getName());
        session.setAttribute("user_surname", user.getSurname());
//        request.setAttribute("image_adress", getCorrectAdress(defaultImage));
        
        return PAGE_USER;
    }

    private String getIndexedImageName()
    {
        int count = bookService.getCount();
        String name = "img" + count + ".jpg";
        incrementCount(count);
        return name;
    }

    private void incrementCount(int countImg)
    {
        bookService.incrementCount(countImg);
    }

    private String getCorrectAdress(String name)
    {
        return "userImage/" + name;
    }
    
    private boolean loginVerification(String login) {
        boolean exist = bookService.loginVerification(login);
        return exist;
    }
}
