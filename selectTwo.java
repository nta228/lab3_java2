package Java2_lab03;
import java.sql.*;
public class selectTwo {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select title, author, price, qty from books where author = 'CodeLean VN' or price >= 30 order by id ASC";
            System.out.println("The SQL statement is : " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are : ");
            int rowCount = 0;
            while (rset.next()){
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println( title + ", " + author + ", " + price + ", " + qty);
                rowCount ++;
            }
            System.out.println("Total number of records = " + rowCount);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
