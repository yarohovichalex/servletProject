package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_LOGIN;
import static by.htp.controller.util.ControllerConstantsPool.REQUEST_PASSWORD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class AutorizateActionProcessor implements IActionProcessor
{
    private static final String ACTION = "doSignIn";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        User user;
        String login = request.getParameter(REQUEST_LOGIN);
        String pass = request.getParameter(REQUEST_PASSWORD);
        HttpSession session = request.getSession();
        user = bookService.searchUser(login, pass);
        session.setAttribute("user", user);
        
        System.out.println(user.getImageAdres());
        
        session.setAttribute("user_image", user.getImageAdres());
        session.setAttribute("user_name", user.getName());
        session.setAttribute("user_surname", user.getSurname());
        
        if (user != null && user.getRole().equals("user"))
        {
            return PAGE_USER;
        }
        else if (user != null && user.getRole().equals("admin"))
        {
            return PAGE_ADMIN;
        }
        else
        {
            return PAGE_ERROR;
        }
    }
}
