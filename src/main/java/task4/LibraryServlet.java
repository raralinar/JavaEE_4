package task4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task3.MusicEntity;

import java.io.IOException;

@WebServlet("/task4/information")
public class LibraryServlet extends HttpServlet {
    EntityManager entityManager;
    String unitName = "musicPU";

    @Override
    public void init() throws ServletException {
        entityManager = Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("audioFiles", entityManager.createQuery("select m from MusicEntity m").getResultList());
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String singer = request.getParameter("singer");
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            if (!singer.isBlank() && !title.isBlank() && !genre.isBlank()) {
                MusicEntity m = new MusicEntity(singer, title, genre);
                entityManager.getTransaction().begin();
                entityManager.persist(m);
                entityManager.getTransaction().commit();
            }
        } else if (action.equals("delete")) {
            MusicEntity m = entityManager.find(MusicEntity.class, Integer.parseInt(request.getParameter("id")));
            if (m != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(m);
                entityManager.getTransaction().commit();
            }
        }
        entityManager.clear();
        request.setAttribute("audioFiles", entityManager.createQuery("select m from MusicEntity m").getResultList());
        request.getRequestDispatcher("user.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/task4/user.jsp");
    }
}

