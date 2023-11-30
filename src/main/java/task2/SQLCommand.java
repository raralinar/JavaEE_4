package task2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCommand {
    public static String createDB(Statement st) throws SQLException {
        String dbName="DB_SHOP";
        try {
//            if (!st.executeQuery("SELECT 1 FROM pg_catalog.pg_database WHERE datname = 'db_shop'").next()){
//                st.executeUpdate("CREATE DATABASE " + dbName);
                st.executeUpdate("CREATE TABLE IF NOT EXISTS " + " \"db_shop.Category\" (idCategory SERIAL NOT NULL," +
                        "nameCategory VARCHAR(45) NOT NULL,PRIMARY KEY (idCategory));");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS Producer (idProducer SERIAL NOT NULL," +
                        "  ProducerName VARCHAR(25) NOT NULL,ProducerCountry VARCHAR(15) NOT NULL," +
                        "  PRIMARY KEY (idProducer));");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS Items (idItems SERIAL NOT NULL," +
                        "  idCategory INT NOT NULL,idProducer INT NOT NULL," +
                        "  itemName VARCHAR(45) NOT NULL,PRIMARY KEY (idItems)," +
                        " CONSTRAINT IdCategoryFK" +
                        "    FOREIGN KEY (idCategory) REFERENCES Category (idCategory)" +
                        "    ON DELETE NO ACTION  ON UPDATE NO ACTION, CONSTRAINT idProducerFK" +
                        "    FOREIGN KEY (idProducer) REFERENCES Producer (idProducer)" +
                        "    ON DELETE NO ACTION ON UPDATE NO ACTION);");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS Stock (idItem INT NOT NULL," +
                        "  countItem INT NOT NULL,idCloset SERIAL NOT NULL," +
                        "  PRIMARY KEY (idCloset)," +
                        "  CONSTRAINT idItemFK FOREIGN KEY (idItem) REFERENCES Items (idItems)" +
                        "    ON DELETE CASCADE ON UPDATE NO ACTION);");
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbName;
    }
}
