package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.START_PARAM;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.bean.Book;
import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class ViewParametrActionProcessor implements IActionProcessor
{
    private static final String ACTION = "viewBooks";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();
    private List<Book> list = new ArrayList<>();
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        list = bookService.outputBook();
        System.out.println(list.size() + "list size");
        request.setAttribute("listbook", list);
        return START_PARAM;
    }

}
