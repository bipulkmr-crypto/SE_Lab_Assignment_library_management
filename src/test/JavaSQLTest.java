package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JavaSQLTest {
    static Connection connection;
    public  void insert_details(String id, String name, String author_name, String location, double price)
    {
        if(connection==null)startConnection();
        String query="INSERT INTO  book(id,name,price,location,author_name)"+" values(?,?,?,?,?)";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setString(1,id);
            stmt.setString(2,name);
            stmt.setDouble(3,price);
            stmt.setString(4,location);
            stmt.setString(5,author_name);
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Failed to insert");
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        startConnection();

    }

    public static void startConnection() {
        String url="jdbc:mysql://localhost:3306/library";
        String username="root";
        String password="admin";
        try {
            connection=DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("Failed");
            e.printStackTrace();
        }
    }

    public void updateIssue(int i, String issued_userid,String id) {
        if(connection==null)startConnection();

        String updateQuery="UPDATE book"
                +"SET issued=?,issued_userid=?,issue_date=?,due_date=? WHERE id=?";
        if(i==1)
        {
//            String updateQuery="UPDATE book"
//                            +"SET issued=?,issued_userid=?,issue_date=?,due_date=? WHERE id=?";
////            String query="INSERT INTO book(issued,issue_date,issued_userid,due_date)"+" values(?,?,?,?)";
            try {
                PreparedStatement stmt=connection.prepareStatement(updateQuery);
                stmt.setBoolean(1,true);
                Calendar calendar=Calendar.getInstance();
                java.sql.Date issue_date=new java.sql.Date(calendar.getTime().getTime());
                java.sql.Date due_date=new java.sql.Date(calendar.getTime().getTime()+15);
                stmt.setDate(3,issue_date);
                stmt.setString(2,issued_userid);
                stmt.setDate(4,due_date);
                stmt.setString(5,id);
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {

            try {
                PreparedStatement stmt=connection.prepareStatement(updateQuery);
                stmt.setBoolean(1,false);

                stmt.setDate(3,null);
                stmt.setString(2,null);
                stmt.setDate(4,null);
                stmt.setString(5,id);
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBook(String id) {
        if(connection==null)startConnection();

        String query="DELETE FROM book WHERE id=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setString(1,id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateDetails(String id, String name, String author_name, String location, double price) {
        if(connection==null)startConnection();

        String updateQuery="UPDATE book"
                +"SET name=?,author_name=?,location=?,price=? WHERE id=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(updateQuery);
            stmt.setString(1,name);
            stmt.setString(2,author_name);
            stmt.setString(3,location);
            stmt.setDouble(4,price);
            stmt.setString(5,id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewBooks(String userid) {
        if(connection==null)startConnection();

        String query="SELECT FROM book WHERE issued_userid=?";
        try {
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setString(1,userid);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
