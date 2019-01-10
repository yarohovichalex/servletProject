package by.htp.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.htp.processor.AddBookActionProcessor;
import by.htp.processor.AutorizateActionProcessor;
import by.htp.processor.DeleteActionProcessor;
import by.htp.processor.DoRegistrationActionProcessor;
import by.htp.processor.EditActionProcessor;
import by.htp.processor.ExitingAnAccountActionProcessor;
import by.htp.processor.IActionProcessor;
import by.htp.processor.OpenBookPageActionProcessor;
import by.htp.processor.OutputAllBookActionProcessor;
import by.htp.processor.RenderBookActionProcessor;
import by.htp.processor.SearchBookActionProcessor;
import by.htp.processor.TakeABookActionProcessor;
import by.htp.processor.ToAutorizateActionProcessor;
import by.htp.processor.ToEditBookPageActionProcessor;
import by.htp.processor.ToIndexPageActionProcessor;
import by.htp.processor.ToRegistrationActionProcessor;
import by.htp.processor.UploadFileToServActoinProcessor;
import by.htp.processor.ViewParametrActionProcessor;

public class ProcessorsSingleton
{
    private static List<IActionProcessor> PROCESSORS;
    
    public static synchronized List<IActionProcessor> getProcessors()
    {
        if(PROCESSORS == null)
        {
            List<IActionProcessor> temp = new ArrayList<>();
            temp.add(new RenderBookActionProcessor());
            temp.add(new TakeABookActionProcessor());
            temp.add(new ExitingAnAccountActionProcessor());
            temp.add(new ToIndexPageActionProcessor());
            temp.add(new ViewParametrActionProcessor());
            temp.add(new SearchBookActionProcessor());
            temp.add(new DoRegistrationActionProcessor());
            temp.add(new ToRegistrationActionProcessor());
            temp.add(new UploadFileToServActoinProcessor());
            temp.add(new ToEditBookPageActionProcessor());
            temp.add(new OpenBookPageActionProcessor());
            temp.add(new OutputAllBookActionProcessor());
            temp.add(new DeleteActionProcessor());
            temp.add(new AddBookActionProcessor());
            temp.add(new AutorizateActionProcessor());
            temp.add(new ToAutorizateActionProcessor());
            temp.add(new EditActionProcessor());
            temp.add(new DeleteActionProcessor());
            PROCESSORS = Collections.unmodifiableList(temp);
        }
        return PROCESSORS;
    }
}
