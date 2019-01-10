package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_EDIT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToEditBookPageActionProcessor implements IActionProcessor
{
    private static final String ACTION = "ToEdit";
    private static final String METHOD = "GET";

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        int id = Integer.parseInt(request.getParameter("BookIdIntoEditPage"));
        String bookName = request.getParameter("BookNameIntoEditPage");
        String authorName = request.getParameter("AuthorNameIntoEditPage");
        String stringDate = request.getParameter("DateIntoEditPage");

        request.setAttribute("book_value", bookName);
        request.setAttribute("author_value", authorName);
        request.setAttribute("date_value", stringDate);
        request.setAttribute("edit_book_id", id);
        return PAGE_EDIT;
    }
}
