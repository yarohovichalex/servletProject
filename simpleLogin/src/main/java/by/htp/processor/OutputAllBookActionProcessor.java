package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class OutputAllBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "output";
    private static final String METHOD = "GET";
    private final BookService bookService = BookServiceSingleton.getInstance();
    private List<Book> list = new ArrayList<>();
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        list = bookService.outputBook();    
        System.out.println(list.get(0));
        request.setAttribute("listbook", list);
        HttpSession session = request.getSession();
        session.setAttribute("bookList", list);
        User user = (User)session.getAttribute("user");
        
        session.setAttribute("user_image", user.getImageAdres());
        session.setAttribute("user_name", user.getName());
        session.setAttribute("user_surname", user.getSurname());
        System.out.println(user.getName() + " name");
        System.out.println(user.getRole() + " role");
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

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

}
