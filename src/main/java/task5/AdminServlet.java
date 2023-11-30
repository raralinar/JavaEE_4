package task5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/task5/admin")
public class AdminServlet extends HttpServlet {
    EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManager = Persistence.createEntityManagerFactory("userPU").createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("addAdmin")) {
            String un = req.getParameter("name");
            String pass = req.getParameter("passwd");
            ModelUsers.createAdmin(un, pass);
        } else if (action.equals("addUser")) {
            String un = req.getParameter("name");
            String pass = req.getParameter("passwd");
            ModelUsers.createUser(un, pass);
        }
        req.setAttribute("users", ModelUsers.getAll());
        req.getRequestDispatcher("/task5/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String username = req.getParameter("curuser");
        if (action.equals("delete")) {
            ModelUsers.deleteUser(username);
        } else {
            String name = req.getParameter("value1");
            String pass = req.getParameter("value2");
            String currentUser = req.getParameter("value3");
            ModelUsers.editUser(name, pass, currentUser);
            req.setAttribute("users", ModelUsers.getAll());
            req.getRequestDispatcher("/task5/admin.jsp").forward(req, resp);
        }
        req.setAttribute("users", ModelUsers.getAll());
        req.getRequestDispatcher("/task5/admin.jsp").forward(req, resp);
    }
}
