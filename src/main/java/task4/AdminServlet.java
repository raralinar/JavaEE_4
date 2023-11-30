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

@WebServlet("/task4/admin")
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
            Role role = new Role(); role.setRole_id(1);
            User user = new User(un, pass, role);
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } else if (action.equals("addUser")) {
            String un = req.getParameter("name");
            String pass = req.getParameter("passwd");
            Role role = new Role(); role.setRole_id(2);
            User user = new User(un, pass, role);
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.clear();
        }
        req.setAttribute("users", entityManager.createQuery("select u from User u").getResultList());
        req.getRequestDispatcher("/task4/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String username = req.getParameter("curuser");
        if (action.equals("delete")) {
            List<User> u = entityManager
                    .createQuery("select u from User u where u.username = '" + username + "'").getResultList();
            if (u.size() != 0) {
                entityManager.getTransaction().begin();
                entityManager.remove(u.get(0));
                entityManager.getTransaction().commit();
            }
        } else {
            String name = req.getParameter("value1");
            String pass = req.getParameter("value2");
            String currentUser = req.getParameter("value3");
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, Integer.parseInt(currentUser));
            user.setUsername(name); user.setPasswd(pass);
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }
        entityManager.clear();
        req.setAttribute("users", entityManager.createQuery("select u from User u").getResultList());
        req.getRequestDispatcher("/task4/admin.jsp").forward(req, resp);
    }
}
