package task2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Category {
    private int idCategory;
    private String nameCategory;

    public int getIdCategory() {return idCategory;}
    public String getNameCategory() {return nameCategory;}

    public void setIdCategory(int idCategory) {this.idCategory = idCategory;}
    public void setNameCategory(String nameCategory) {this.nameCategory = nameCategory;}

    public static void readCategory(Statement st, List<Category> categories,String dbName){
        try{
            ResultSet rs=st.executeQuery("SELECT * FROM Category");
            while (rs.next()){
               Category category=new Category();
               category.setIdCategory(rs.getInt(1));
               category.setNameCategory(rs.getString(2));
               categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
