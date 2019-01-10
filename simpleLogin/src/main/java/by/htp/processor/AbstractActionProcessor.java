package by.htp.processor;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractActionProcessor
{
    protected boolean isProcessorAllowed(HttpServletRequest request, String action, String method)
    {
        return action.equals(request.getParameter("action")) && method.equals(request.getMethod());
    }
}
