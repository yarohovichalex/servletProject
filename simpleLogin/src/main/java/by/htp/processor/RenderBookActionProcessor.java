package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class RenderBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "render";
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
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user.getRole().equals("user")) {
            bookService.render(user.getLogin());
            session.setAttribute("bookTitle", "");
            session.setAttribute("bookAuthor", "");
            session.setAttribute("bookImg", "bookImage/no.jpg");


        }
        return PAGE_USER;
    }
}
