package task4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task3.MusicEntity;

import java.io.IOException;
import java.util.List;


@WebServlet("/task4/filter")
public class FilterServlet extends HttpServlet {
    EntityManager entityManager;

    @Override
    public void init() throws ServletException {
        entityManager = Persistence.createEntityManagerFactory("musicPU").createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String singer = req.getParameter("filterSinger");
        List<MusicEntity> filteredMusic = entityManager.createQuery("select m from MusicEntity m where m.singer = '" + singer +"'").getResultList();
        req.setAttribute("audioFiles", filteredMusic);
        entityManager.clear();
        RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
        dispatcher.forward(req, resp);
    }
}
