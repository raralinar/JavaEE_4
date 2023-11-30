package task2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@WebServlet("/task2/task2")
public class Servlet extends HttpServlet {
    private List<Producer> producers;
    private List<Category> categories;
    private List<Items> items;
    private List <Stock> stocks;
    private Statement statement;
    private String dbName="";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/db_shop");
            Connection conn = ds.getConnection();


            this.statement = conn.createStatement();
            if (dbName=="") {
                dbName = SQLCommand.createDB(statement);
            }
            this.producers=new ArrayList<>();
            Producer.readProducer(statement,producers,dbName);
            this.categories=new ArrayList<>();
            Category.readCategory(statement,categories,dbName);
            this.items=new ArrayList<>();
            Items.readItems(statement,items,dbName);
            this.stocks=new ArrayList<>();
            Stock.readStock(statement,stocks,dbName);

            req.setAttribute("producers",producers);
            req.setAttribute("categories",categories);
            req.setAttribute("stocks",stocks);
            req.setAttribute("items",items);

            RequestDispatcher dispatcher =req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req,resp);

        } catch (NamingException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
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
                    int rsAdd=statement.executeUpdate("INSERT INTO Items(idItems, idCategory, idProducer, ItemName) VALUES ("+
                            idItem+","+idCtg+","+idPrd+",'"+itemNm+"')");
                    Items.readItems(statement,items,dbName);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                int itemID = Integer.parseInt(request.getParameter("itemID"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Items WHERE idItems="+itemID);
                    Items.readItems(statement,items,dbName);
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
                    Items.readItems(statement,items,dbName);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addStock":
                long idItems = Long.parseLong(request.getParameter("idItem"));
                int idCountItemIN = Integer.parseInt(request.getParameter("countItem"));
                int idClosetIN = Integer.parseInt(request.getParameter("idCloset"));
                try{
                    int rsAdd=statement.executeUpdate("INSERT INTO Stock(idItem, countItem, idCloset) VALUES ("+
                            idItems+","+idCountItemIN+","+idClosetIN+")");
                    Stock.readStock(statement,stocks,dbName);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteStock":
                int idCloset = Integer.parseInt(request.getParameter("IdClosetDEL"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Stock WHERE idCloset="+idCloset);
                    Stock.readStock(statement,stocks,dbName);
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
                    Producer.readProducer(statement,producers,dbName);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteProducer":
                int idProducerDEL = Integer.parseInt(request.getParameter("idProducerDEL"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Producer WHERE idProducer="+idProducerDEL);
                    Producer.readProducer(statement,producers,dbName);
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
                    Category.readCategory(statement,categories,dbName);
                }catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteCategory":
                int idCategoryDEL = Integer.parseInt(request.getParameter("idCategoryDEL"));
                try {
                    boolean rsDelete=statement.execute("DELETE FROM Category WHERE idCategory="+idCategoryDEL);
                    Category.readCategory(statement,categories,dbName);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        request.getRequestDispatcher("/task2/index.jsp").forward(request, response);
    }
}
