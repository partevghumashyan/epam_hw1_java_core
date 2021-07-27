import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintCheck {

    public static void printCheck(Order order){
        String time;

        System.out.println("********************************");
        System.out.println("Order: " + order.getOrderNumber());
        System.out.println("Client: " + order.getCustomerNumber());

        List<Pizza> orderItems = order.getItems();

        double totalAmount = 0;
        for (Pizza p: orderItems){
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

}
