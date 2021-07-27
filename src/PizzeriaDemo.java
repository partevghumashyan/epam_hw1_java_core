import java.text.DateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzeriaDemo {
    public static void main(String[] args) {
        Order order1 = new Order();

        Pizza margarita = new Pizza("Margarita", 2);
        margarita.addIngredient(Ingredients.tomatoPaste);
        margarita.addIngredient(Ingredients.pepperoni);
        margarita.addIngredient(Ingredients.garlic);
        margarita.addIngredient(Ingredients.bacon);
        margarita.isWithCalzone();

        Pizza pepperoniOro = new Pizza("Pep", 3);
        pepperoniOro.addIngredient(Ingredients.tomatoPaste);
        pepperoniOro.addIngredient(Ingredients.cheese);
        pepperoniOro.addIngredient(Ingredients.salami);
        pepperoniOro.addIngredient(Ingredients.olives);

        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(margarita);
        pizzas.add(pepperoniOro);

        order1.makeAnOrder(pizzas);

        PrintCheck.printCheck(order1);



    }
}
