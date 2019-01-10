package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.Book;
import by.htp.bean.User;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class AddBookActionProcessor extends AbstractActionProcessor implements IActionProcessor
{
    private final BookService bookService = BookServiceSingleton.getInstance();

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return super.isProcessorAllowed(request, "add", "POST");
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        User us = (User) session.getAttribute("user");
        if (/* us.getRole().equals("admin" */1 + 1 == 2)
        {
            String nameBook = request.getParameter("addName");
            String nameAuthor = request.getParameter("addAuthor");
            String stringDate = request.getParameter("publishDate");
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            try
            {
                bookService.criate(new Book(nameBook, nameAuthor, format.parse(stringDate)));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return PAGE_ADMIN;
    }

}
