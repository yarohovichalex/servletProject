package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class DeleteActionProcessor implements IActionProcessor
{
    private static final String ACTION = "delete";
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
        User us = (User)session.getAttribute("user");
        if(us.getRole().equals("admin")) {
            int f = Integer.parseInt(request.getParameter("book_id"));
            bookService.delete(f);
        }
        return PAGE_ADMIN;
    }
}
