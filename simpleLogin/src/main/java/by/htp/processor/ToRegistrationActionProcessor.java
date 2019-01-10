package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_SIGN_UP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToRegistrationActionProcessor implements IActionProcessor
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
        return PAGE_SIGN_UP;
    }

}
