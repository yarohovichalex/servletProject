package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class EditActionProcessor implements IActionProcessor
{
    private static final String ACTION = "edit";
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
        String editBookName = request.getParameter("editBookName");
        String editAuthorName = request.getParameter("editAuthorName");
        System.out.println(editAuthorName + " authorName");
        String editStringDate = request.getParameter("editDate");
        String bookid = request.getParameter("editBookId");
        System.out.println(bookid + " id");
        Integer indId = Integer.parseInt(bookid);
    
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(editStringDate);
            bookService.editBook(indId, new Book(editBookName, editAuthorName, date));
            return PAGE_ADMIN;
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException(e);
        }
    }
}
