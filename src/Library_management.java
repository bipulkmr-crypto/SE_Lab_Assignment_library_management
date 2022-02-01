import test.JavaSQLTest;

import java.util.Scanner;

public class Library_management {
    static BookStore bookStore;
    public  static  void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int c;
        bookStore=new BookStore();
        JavaSQLTest obj=new JavaSQLTest();
        System.out.println("Enter 1 to admin access");
        System.out.println("Enter 2 to user access");
        c=in.nextInt();
        if(c==1)
        {
            while(true)
            {
                int p;
                System.out.println("Enter 1 to add,delete,update and edit the book's information");
                System.out.println("Enter 2 to view books issued to a particular student");
                System.out.println("Enter 3 to exit");
                p=in.nextInt();
                if(p==1)
                {
//                    BookStore bookStore=new BookStore();/
                    bookStore.run();
                }
                else if(p==2)
                {
                    String userid = null;
                    System.out.println("Enter books of the ");
                    userid=in.next();
                    obj.viewBooks(userid);
                }
                else
                {
                    return;
                }
            }
        }

    }

}
