package task1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Items {
    private long idItems;
    private int idCategory, idProducer;
    private String itemName;

    public long getIdItems() {return idItems;}
    public int getIdCategory() {return idCategory;}
    public int getIdProducer() {return idProducer;}
    public String getItemName() {return itemName;}

    public void setIdItems(long idItems) {this.idItems = idItems;}
    public void setIdCategory(int idCategory) {this.idCategory = idCategory;}
    public void setIdProducer(int idProducer) {this.idProducer = idProducer;}
    public void setItemName(String itemName) {this.itemName = itemName;}


    public static void readItems(Statement st,List<Items> itemsList) {
        try {
        ResultSet rs=st.executeQuery("SELECT * FROM Items");
        while (rs.next()){
            Items item=new Items();
            item.setIdItems(rs.getLong(1));
            item.setIdCategory(rs.getInt(2));
            item.setIdProducer(rs.getInt(3));
            item.setItemName(rs.getString(4));
                itemsList.add(item);
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//CREATE TABLE `OOP_DB`.`Items` (
//  `idItems` INT NOT NULL AUTO_INCREMENT,
//  `idCategory` INT NOT NULL,
//  `idProducer` INT NOT NULL,
//  `itemName` VARCHAR(45) NOT NULL,
//  PRIMARY KEY (`idItems`),
//  INDEX `IdCategoryFK_idx` (`idCategory` ASC) VISIBLE,
//  INDEX `idProducerFK_idx` (`idProducer` ASC) VISIBLE,
//  CONSTRAINT `IdCategoryFK`
//    FOREIGN KEY (`idCategory`)
//    REFERENCES `OOP_DB`.`Category` (`idCategory`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION,
//  CONSTRAINT `idProducerFK`
//    FOREIGN KEY (`idProducer`)
//    REFERENCES `OOP_DB`.`Producer` (`idProducer`)
//    ON DELETE NO ACTION
//    ON UPDATE NO ACTION);