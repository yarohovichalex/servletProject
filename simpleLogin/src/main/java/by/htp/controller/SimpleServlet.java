package by.htp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upload")
@MultipartConfig
public class SimpleServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public SimpleServlet()
    {
        super();
    }

    @Override
    public void init() throws ServletException
    {
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("doGet");
        String action = request.getParameter("action");
        String page = ActionManager.defineServerAction(action, request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("post");
        String action = request.getParameter("action");
        String page = ActionManager.defineServerAction(action, request, response);
        response.sendRedirect(page);

    }
}
