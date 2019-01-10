package by.htp.processor;

import static by.htp.controller.util.ControllerConstantsPool.PAGE_ADMIN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.htp.servis.BookService;
import by.htp.singleton.BookServiceSingleton;

public class UploadFileToServActoinProcessor implements IActionProcessor
{
    private static final String ACTION = "upload";
    private static final String METHOD = "POST";
    private final BookService bookService = BookServiceSingleton.getInstance();

    @Override
    public boolean isAllowed(HttpServletRequest request)
    {
        return ACTION.equals(request.getParameter("action")) && METHOD.equals(request.getMethod());
    }

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
    {
        // String description = request.getParameter("description");
        Part filePart;
        OutputStream outputStream = null;
        InputStream fileContent = null;
        try
        {
            filePart = request.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            fileContent = filePart.getInputStream();
            outputStream = new FileOutputStream(new File("D:\\Kursy\\simpleLogin\\src\\main\\webapp\\img\\img33.jpg"));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fileContent.read(bytes)) != -1)
            {
                outputStream.write(bytes, 0, read);
            }
        }
        catch (IOException | ServletException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fileContent != null)
            {
                try
                {
                    fileContent.reset();
                    fileContent.close();
                }
                catch (final IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (outputStream != null)
            {
                try
                {
                    outputStream.flush();
                    outputStream.close();
                }
                catch (final IOException e)
                {
                    e.printStackTrace();
                }
            }           
        }
        return PAGE_ADMIN;

    }
}
