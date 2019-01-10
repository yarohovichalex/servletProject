package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_USER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class TakeABookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "toTake";
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
        String title = request.getParameter("tittleForTakeProcessor");
        String author = request.getParameter("authorNameForTakeProcessor");
        String bookImage = request.getParameter("bookImageForTakeProcessor");

        if(user.getRole().equals("user")) 
        {
            int f = Integer.parseInt(request.getParameter("idForTakeProcessor"));            
            bookService.takeBook(f, user);
            session.setAttribute("bookid", f);
            session.setAttribute("bookTitle", title);
            session.setAttribute("bookAuthor", author);
            session.setAttribute("bookImg", bookImage);

        }
        if(true) {
            
        }
        return PAGE_USER;
    }
}
