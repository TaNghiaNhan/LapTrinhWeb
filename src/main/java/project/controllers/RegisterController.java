package project.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.dao.IUserDao;
import project.dao.impl.UserDaoImpl;
import project.dao.impl.UserServiceImpl;
import project.models.UserModel;
import project.services.IUserService;
import java.io.IOException;

@WebServlet(urlPatterns =  "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        String email = req.getParameter("email").trim();

        IUserService userService = new UserServiceImpl();
        String existingUsername = userService.findByUserName(username).getUsername();
        String existingEmail = userService.findByEmail(email).getEmail();

        try {
            if (existingUsername != null || existingEmail != null) {
                req.getSession().setAttribute("alert", "Tai khoan da ton tai");
                System.out.println("TK da ton tai");
                resp.sendRedirect("login.jsp?password=" + password);
            } else {
                userService.Insert(new UserModel(username, password, email));
                req.getSession().setAttribute("alert", "Dang ki thanh cong");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
