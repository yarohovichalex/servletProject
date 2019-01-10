package by.htp.processor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IActionProcessor
{
    boolean isAllowed(HttpServletRequest request);

    String process(HttpServletRequest request, HttpServletResponse response);
}
