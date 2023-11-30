package task3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/task3/information")
public class LibraryServlet extends HttpServlet {
    EntityManager entityManager;
    String unitName = "musicPU";

    @Override
    public void init() throws ServletException {
        entityManager = Persistence.createEntityManagerFactory(unitName).createEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("audioFiles", entityManager.createQuery("select m from MusicEntity m").getResultList());
        request.getRequestDispatcher("lib.jsp").forward(request, response);
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
            entityManager.getTransaction().begin();
            entityManager.remove(m);
            entityManager.getTransaction().commit();
        }
        request.setAttribute("audioFiles", entityManager.createQuery("select m from MusicEntity m").getResultList());
        request.getRequestDispatcher("lib.jsp").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/task3/lib.jsp");
    }
}

