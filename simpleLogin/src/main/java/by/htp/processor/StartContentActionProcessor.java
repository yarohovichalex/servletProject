package by.htp.processor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class StartContentActionProcessor implements IActionProcessor
{
    private static final String ACTION = "output";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    List<Book> list = new ArrayList<>(); 
    
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        
        return null;
    }

}
