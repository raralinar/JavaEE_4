package task5;

import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/task5/login5")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passwd = req.getParameter("password");
        if (username == null || passwd == null) {
            req.setAttribute("users", ModelUsers.getAll());
            req.getRequestDispatcher("/task5/admin.jsp").forward(req, resp);
        }
        if (ModelUsers.checkUser(username, passwd)) {
            String role = ModelUsers.getUser(username, passwd).getRole().getRole_name();
            if (role.equals("Пользователь")) {
                req.getRequestDispatcher("/task5/user.jsp").forward(req, resp);
            } else {
                req.setAttribute("users", ModelUsers.getAll());
                req.getRequestDispatcher("/task5/admin.jsp").forward(req, resp);
            }
        }

    }
}
