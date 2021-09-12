package entities;
import entities.enums.OrderStatus;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    //Attributes
    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> list = new ArrayList<>();

    double total1 = 0;
    //Constructors
    public Order(){

    }
    public Order (Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }
    //methods
    public void removeItem(OrderItem orderItem){
        this.list.add(orderItem);
    }
    public void addItem(OrderItem orderItem){
        this.list.add(orderItem);
    }
    public double total(){

        for (OrderItem i : list){
          total1 += i.subTotal();
        }
        return total1;
    }
    @Override
    public String toString(){
        StringBuilder sd = new StringBuilder();
        sd.append("ORDER SUMMARY:\n");
        sd.append("Order moment: " + this.moment);
        sd.append("\nOrder Status: " + this.getStatus());
        sd.append("\nClient: " + client.getName());
        sd.append(", " + client.getBirthDate());
        sd.append(", " + client.getEmail() + "\n");
        sd.append("Order items: \n");

        for(OrderItem l : this.list){
            sd.append(l.getProduct().getNameProduct());
            sd.append(" , $" + l.getProduct().getPrice());
            sd.append(", Quantity: " + l.getQuantity());
            sd.append(", Subtotal: $" + l.subTotal() + "\n");
        }
        return sd.toString();
    }
    //getters and setters
    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getList() {
        return list;
    }
    /*
    public void setList(List<OrderItem> list) {
        this.list = list;

     */

}