import java.text.DateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Order {
    private static int orderNumber = 0;
    private int customerNumber;
    private List<Pizza> items;
    private String time;
    //private List<Integer> quantity;
    private int quantity;


    public Order() {
        Random random = new Random();
        orderNumber++;
        this.customerNumber = random.nextInt(10000);
        this.items = new ArrayList<>();

    }

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public static int getOrderNumber() {
        return orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }


    public List<Pizza> getItems() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.addAll(items);

        return pizzas;
    }

    public void makeAnOrder(List<Pizza> pizzas){
        items.addAll(pizzas);
        checkTheNameOfPizza();
    }


    public void checkTheNameOfPizza(){
        for (int i = 0; i < items.size();i++){
            if ((items.get(i).getName().length() < 4) || (items.get(i).getName().length() > 20)){
                items.get(i).setName("customer_name_" + orderNumber);
            }

        }

    }
/*
    public void printCheck(){
        System.out.println("********************************");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + customerNumber);


        double totalAmount = 0;
        for (Pizza p:items){
            double amount = 0;
            System.out.println(p.getName());
            System.out.println("--------------------------------");
            if (p.getValueOfCalzone()) {
                System.out.println("Pizza base(Calzone)" + " " + p.getPrice() + "$");
            }else {
                System.out.println("Pizza base" + " " + p.getPrice() + "$");
            }

            amount += p.getPrice();
        for (Ingredient i:p.getIngredients()){
            System.out.print(i);
            amount += i.getPrice();

        }

            System.out.println("--------------------------------");
            System.out.println("Amount: " + amount + "$");
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("--------------------------------");
            amount = amount * p.getQuantity();
            totalAmount += amount;
        }

        time = DateFormat.getTimeInstance().format(new Date());
        System.out.println("Total amount: " + totalAmount + "$");
        System.out.println("Order time: " + time);
        System.out.println("********************************");
    }
 */


    @Override
    public String toString() {
        if (items != null ) {
            for (Pizza p : items) {
                return "[" + orderNumber + " : " + customerNumber + "" + p.getName() + " : " + p.getQuantity();
            }
        }
        return "There is no order";
    }
}
