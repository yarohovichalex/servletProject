package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_SIGN_IN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToAutorizateActionProcessor implements IActionProcessor
{
    private static final String ACTION = "toSignIn";
    private static final String METHOD = "GET";
    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        return PAGE_SIGN_IN;
    }

}
