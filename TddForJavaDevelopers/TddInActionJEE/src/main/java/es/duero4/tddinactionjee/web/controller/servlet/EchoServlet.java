package es.duero4.tddinactionjee.web.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramon
 */
public class EchoServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Response object generates response
        response.setHeader("Content-Type", "text/plain");
        PrintWriter writer = response.getWriter();
        // Request object encapsulates request parameters
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameter = String.valueOf(parameterNames.nextElement());
            String[] values = request.getParameterValues(parameter);
            for (int i = 0; i < values.length; i++) {
                // Response object generates response
                writer.write(parameter + "=" + values[i]);
                writer.write("\n");
            }
        }
    }

}
