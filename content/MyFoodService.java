import factoryClasss.FoodFactory;
import product.commonProduct.FoodList;

public class MyFoodService {
    public static void main(String[] args) {
        
        FoodFactory foodType = new FoodFactory();
        
        FoodList foodList1 = foodType.printFoodList("Italian");
        foodList1.FoodType();

        FoodList foodList2 = foodType.printFoodList("Chines");
        foodList2.FoodType();
    }
}
