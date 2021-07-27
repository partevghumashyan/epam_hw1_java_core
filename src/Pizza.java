import java.util.ArrayList;
import java.util.List;

public class Pizza {
   private String name;
   private double price = 1.00;
   private boolean withCalzone = false;
   private int quantity;
   private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        List<Ingredient> newIngredients = new ArrayList<>();
        newIngredients.addAll(ingredients);
        return newIngredients;
    }

    public Pizza(String name,int quantity) {
        this.name = name;
        ingredients = new ArrayList<>();
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void isWithCalzone() {

        withCalzone = true;
        price += 0.50;
    }

   public boolean getValueOfCalzone(){
        return withCalzone;
   }

    public double getPrice() {
        return price;
    }

    public void addIngredient(Ingredient ingredient){
        if (ingredients.size() == 8){
            System.out.println("Pizza is full(all ingredients are already used)");
        }
        ingredients.add(ingredient);
    }


    @Override
    public String toString() {
        return name;
    }
}
