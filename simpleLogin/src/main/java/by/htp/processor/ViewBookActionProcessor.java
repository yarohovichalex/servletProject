package by.htp.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewBookActionProcessor implements IActionProcessor
{
    private static final String ACTION = "toRegistration";
    private static final String METHOD = "GET";
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
