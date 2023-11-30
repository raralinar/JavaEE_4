package task2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Producer {
    private int idProducer;
    private String producerName,producerCountry;

    public int getIdProducer() {return idProducer;}
    public String getProducerCountry() {return producerCountry;}
    public String getProducerName() {return producerName;}

    public void setIdProducer(int idProducer) {this.idProducer = idProducer;}
    public void setProducerCountry(String producerCountry) {this.producerCountry = producerCountry;}
    public void setProducerName(String producerName) {this.producerName = producerName;}

    public static void readProducer(Statement st, List<Producer> producers,String dbName){
        try{
            ResultSet rs=st.executeQuery("SELECT * FROM Producer");
            int cols=rs.getMetaData().getColumnCount();
            while (rs.next()){
                Producer producer=new Producer();
                producer.setIdProducer(rs.getInt(1));
                producer.setProducerName(rs.getString(2));
                producer.setProducerCountry(rs.getString(3));
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




