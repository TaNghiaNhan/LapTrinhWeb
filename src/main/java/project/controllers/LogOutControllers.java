package project.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogOutControllers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);  // Lấy session hiện tại nếu nó tồn tại
        if (session != null) {
            session.invalidate();  // Hủy session hiện tại
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp");  // Quay lại trang login  // Chuyển hướng về trang đăng nhập
    }
}