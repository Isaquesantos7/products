package program;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


import java.util.Date;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Order order;
        OrderItem orderItem;
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthday = scan.next();
        Client client = new Client(name, email, sdf.parse(birthday));
        System.out.println("Enter order data: ");
        System.out.print("Order status: ");
        String status = scan.next();
        OrderStatus orderStatus = OrderStatus.valueOf(status);
        order = new Order(new Date(), orderStatus, client);
        System.out.print("How many items to this order? ");
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Enter " +i+ " item data: ");
            System.out.print("Product name: ");
            String productName = scan.next();
            System.out.print("product price: ");
            double productPrice = scan.nextDouble();
            Product product = new Product(productName, productPrice);
            System.out.print("Quantity: ");
            int quantity = scan.nextInt();

            orderItem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.print(order);
        System.out.printf("Total price: $%.2f",order.total());
        scan.close();
    }
}
