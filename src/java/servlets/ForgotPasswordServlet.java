package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author Yoonju Baek
 */
public class ForgotPasswordServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        String message = "";
        String success = "";
        
        if(email.isEmpty()) {
            message = "Please enter your email.";
            request.setAttribute("message", message);
        }
        else {
            AccountService as = new AccountService();
            String path = getServletContext().getRealPath("/WEB-INF");
            boolean isForgot = as.forgotPassword(email, path);
            
            if(isForgot) {
                success = "If the address you entered is valid, you will receive an email very soon. Please check your email for your password.";
                request.setAttribute("success", success);
            }
            else {
                message = "I am sorry. We have a system error. Please contact customer service.";
                request.setAttribute("message", message);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }
}
