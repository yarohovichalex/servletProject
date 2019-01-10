package by.htp.controller;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ERROR;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.processor.IActionProcessor;
import by.htp.singleton.ProcessorsSingleton;

public class ActionManager
{

    public static String defineServerAction(String action, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        Optional<IActionProcessor> foundProcessor = ProcessorsSingleton.getProcessors().stream()
                .filter(e -> e.isAllowed(request)).findFirst();
        
        String defaultPage = PAGE_ERROR;
        if (foundProcessor.isPresent())
        {
            defaultPage = foundProcessor.get().process(request, response);
            return defaultPage;
        }
        return defaultPage;        
    }
}
