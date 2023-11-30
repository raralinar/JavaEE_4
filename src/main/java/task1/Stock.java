package task1;

//CREATE TABLE `OOP_DB`.`Stock` (
//  `idItem` INT NOT NULL,
//  `countItem` INT NOT NULL,
//  `idCloset` INT NOT NULL AUTO_INCREMENT,
//  INDEX `idItemFK_idx` (`idItem` ASC) VISIBLE,
//  PRIMARY KEY (`idCloset`),
//  CONSTRAINT `idItemFK`
//    FOREIGN KEY (`idItem`)
//    REFERENCES `OOP_DB`.`Items` (`idItems`)
//    ON DELETE CASCADE
//    ON UPDATE NO ACTION);

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Stock {
    private long idItem;
    private int countItem, idCloset;

    public int getCountItem() {return countItem;}
    public int getIdCloset() {return idCloset;}
    public long getIdItem() {return idItem;}

    public void setCountItem(int countItem) {this.countItem = countItem;}
    public void setIdCloset(int idCloset) {this.idCloset = idCloset;}
    public void setIdItem(long idItem) {this.idItem = idItem;}

    public static void readStock(Statement st, List<Stock> stocks){
        try{
            ResultSet rs=st.executeQuery("SELECT * FROM Stock");
            while (rs.next()){
                Stock stock=new Stock();
                stock.setIdItem(rs.getLong(1));
                stock.setCountItem(rs.getInt(2));
                stock.setIdCloset(rs.getInt(3));
                stocks.add(stock);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
