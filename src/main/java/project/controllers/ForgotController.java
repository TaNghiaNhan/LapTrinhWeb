package project.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.dao.impl.UserServiceImpl;
import project.services.IUserService;

import java.io.IOException;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email").trim();

        // Kiểm tra xem tài khoản đã tồn tại
        IUserService userService = new UserServiceImpl();
        String existingEmail = userService.findByEmail(email).getEmail();
        HttpSession session = req.getSession();
        try {
            if (existingEmail != null) {
                String password = userService.findByEmail(email).getPassword();
                req.setAttribute("password", password);  // Đưa password vào request attribute
            } else {
                req.setAttribute("errorMessage", "Email không tồn tại.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("forgotPassword.jsp").forward(req, resp);

    }


}
