import test.JavaSQLTest;

import java.util.Scanner;

//import  test.JavaSQLTest.insert_details;

public class BookStore {
    static JavaSQLTest obj;
    public void run() {
        int c;
        obj = new JavaSQLTest();
        JavaSQLTest.startConnection();
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.println("Enter 1 to add a book");
        System.out.println("Enter 2 to edit a book information");
        System.out.println("Enter 3 to delete a book");
        System.out.println("Enter 4 to update a book");
        c = in.nextInt();
        if (c == 1) {
            String name, id, location, author_name;
            double price;
            System.out.println("Enter book id,name,author_name,location,price");
            id = in2.nextLine();
            name = in2.nextLine();
            author_name = in2.nextLine();
            location = in.next();
            price = in.nextDouble();
            obj.insert_details(id, name, author_name, location, price);
        } else if (c == 2) {
            int x;
            System.out.println("Enter 1 to issue book");
            System.out.println("Enter 2 to accept book");
            x = in.nextInt();

            if (x == 1) {
                String issued_userid, id;
                System.out.println("Enter userid of the student and book id");
                issued_userid = in.next();
                id = in.next();
                obj.updateIssue(1, issued_userid, id);
            } else {
                String issued_userid, id;
                System.out.println("Enter userid of the student and book id");
                issued_userid = in.next();
                id = in.next();
                obj.updateIssue(0, issued_userid, id);
            }
        } else if (c == 3) {
            String id;
            System.out.println("Enter book id");
            id = in.next();
            obj.deleteBook(id);
        } else if (c == 4) {
            String name, id, author_name;
            double price;
            System.out.println("Enter book id,name,author_name,location,price");
            id = in.next();
            name = in2.nextLine();
            author_name = in2.nextLine();
            String location = in.next();
            price = in.nextDouble();
            obj.updateDetails(id, name, author_name, location, price);
        } else {
            System.out.println("Wrong Choice");
        }
    }
    public static void main(String[] args) {

    }
}
