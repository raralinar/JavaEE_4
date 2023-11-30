package task4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/task4/login")
public class LoginServlet extends HttpServlet {
    EntityManager em;

    @Override
    public void init() throws ServletException {
        em = Persistence.createEntityManagerFactory("userPU").createEntityManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passwd = req.getParameter("password");
        if (username == null || passwd == null) {
            em = Persistence.createEntityManagerFactory("userPU").createEntityManager();
            req.setAttribute("users", em.createQuery("select u from User u").getResultList());
            req.getRequestDispatcher("/task4/admin.jsp").forward(req, resp);
        }
        List<User> user = em.createQuery("select u from User u where u.username = '" + username + "' AND u.passwd = '" + passwd + "'").getResultList();
        if (user.size() != 0) {
            String role = user.get(0).getRole().getRole_name();
            if (role.equals("Пользователь")) {
                req.getRequestDispatcher("/task4/user.jsp").forward(req, resp);
            } else {
                req.setAttribute("users", em.createQuery("select u from User u").getResultList());
                req.getRequestDispatcher("/task4/admin.jsp").forward(req, resp);
            }
        }

    }
}
