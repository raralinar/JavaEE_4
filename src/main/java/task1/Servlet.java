package task1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/task1/task1")
public class Servlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    private List<Producer> producers;
    private List<Category> categories;
    private List<Items> items;
    private List <Stock> stocks;
@Override
    public void init(ServletConfig sc){
    try{
        Class.forName("org.postgresql.Driver");
    }
    catch (Exception exception){
        throw new RuntimeException(exception);
    }
}

@Override
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
    try{
        this.connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/products","postgres","123");
        this.statement=this.connection.createStatement();
        this.producers=new ArrayList<>();
        Producer.readProducer(statement,producers);
        this.categories=new ArrayList<>();
        Category.readCategory(statement,categories);
        this.items=new ArrayList<>();
        Items.readItems(statement,items);
        this.stocks=new ArrayList<>();
        Stock.readStock(statement,stocks);

        req.setAttribute("producers",producers);
        req.setAttribute("categories",categories);
        req.setAttribute("stocks",stocks);
        req.setAttribute("items",items);

        RequestDispatcher dispatcher =req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,resp);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "add":
                long idItem = Long.parseLong(request.getParameter("idItemsIN"));
                int idCtg = Integer.parseInt(request.getParameter("idCategoryIN"));
                int idPrd = Integer.parseInt(request.getParameter("idProducerIN"));
                String itemNm = request.getParameter("itemNameIN");
                try{
                    int rsAdd=statement.executeUpdate("INSERT INTO Items(idItems, idCategory, idProducer, ItemName) VALUES ('"+
                            idItem+"','"+idCtg+"','"+idPrd+"','"+itemNm+"')");
                    Items.readItems(statement,items);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                int itemID = Integer.parseInt(request.getParameter("itemID"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Items WHERE idItems="+itemID);
                    Items.readItems(statement,items);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                long idItemUP = Long.parseLong(request.getParameter("idItemsUP"));
                int idCtgUP = Integer.parseInt(request.getParameter("idCategoryUP"));
                int idPrdUP = Integer.parseInt(request.getParameter("idProducerUP"));
                String itemNmUP = request.getParameter("itemNameUP");
                try{
                    int rsAdd=statement.executeUpdate("UPDATE Items SET ItemName='"+itemNmUP+"',idCategory="+idCtgUP+",idProducer="+idPrdUP+" WHERE idItems="+idItemUP);
                    Items.readItems(statement,items);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addStock":
                long idItems = Long.parseLong(request.getParameter("idItem"));
                int idCountItemIN = Integer.parseInt(request.getParameter("countItem"));
                int idClosetIN = Integer.parseInt(request.getParameter("idCloset"));
                try{
                    int rsAdd=statement.executeUpdate("INSERT INTO Stock(idItem, countItem, idCloset) VALUES ('"+
                            idItems+"','"+idCountItemIN+"','"+idClosetIN+"')");
                    Stock.readStock(statement,stocks);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteStock":
                int idCloset = Integer.parseInt(request.getParameter("IdClosetDEL"));
                System.out.println("DELETE FROM Stock WHERE idCloset="+idCloset);
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Stock WHERE idCloset="+idCloset);
                    Stock.readStock(statement,stocks);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addProducer":
                int idProducerIN = Integer.parseInt(request.getParameter("idProducerIN"));
                String producerCountryIN = request.getParameter("producerCountryIN");
                String producerNameIN = request.getParameter("producerNameIN");
                try{
                    int rsAdd=statement.executeUpdate("INSERT INTO Producer(idProducer, ProducerName, ProducerCountry) VALUES ("+
                            idProducerIN+",'"+producerNameIN+"','"+producerCountryIN+"')");
                    Producer.readProducer(statement,producers);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteProducer":
                int idProducerDEL = Integer.parseInt(request.getParameter("idProducerDEL"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Producer WHERE idProducer="+idProducerDEL);
                    Producer.readProducer(statement,producers);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addCategory":
                int idCategoryIN = Integer.parseInt(request.getParameter("idCategoryIN"));
                String categoryNameIN = request.getParameter("nameCategoryIN");
                try{
                    int rsAdd=statement.executeUpdate("INSERT INTO Category(idCategory, nameCategory) VALUES ("+
                            idCategoryIN+",'"+categoryNameIN+"')");
                    Category.readCategory(statement,categories);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteCategory":
                int idCategoryDEL = Integer.parseInt(request.getParameter("idCategoryDEL"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Category WHERE idCategory="+idCategoryDEL);
                    Category.readCategory(statement,categories);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        request.getRequestDispatcher("/task1/index.jsp").forward(request, response);
    }
}


