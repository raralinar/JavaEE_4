package task5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import task3.MusicEntity;

import java.io.IOException;

@WebServlet("/task5/information")
public class LibraryServlet extends HttpServlet {
    EntityManager entityManager;
    String unitName = "musicPU";

    @Override
    public void init() throws ServletException {
        entityManager = Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("audioFiles", ModelMusic.getAll());
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String singer = request.getParameter("singer");
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            ModelMusic.addMusic(singer, title, genre);
        } else if (action.equals("delete")) {
            ModelMusic.delete(request.getParameter("id"));
        }
        request.setAttribute("audioFiles", ModelMusic.getAll());
        request.getRequestDispatcher("user.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/task5/user.jsp");
    }
}

