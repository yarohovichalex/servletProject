package by.htp.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class OpenBookPageActionProcessor implements IActionProcessor
{
    private static final String ACTION = "edit";
    private static final String METHOD = "POST";

    private final BookService bookService = BookServiceSingleton.getInstance();
    
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
