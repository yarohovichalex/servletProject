package by.htp.processor;
import static by.htp.controller.util.ControllerConstantsPool.PAGE_SIGN_IN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.bean.User;

public class ExitingAnAccountActionProcessor implements IActionProcessor
{
    private static final String ACTION = "exit";
    private static final String METHOD = "GET";

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        User user = null;
        session.setAttribute("user", user);
        return PAGE_SIGN_IN;
    }

}
