package factory;

import product.commonProduct.FoodList;
import product.concreteProduct.ChinesFood;
import product.concreteProduct.ItalianFood;

public class FoodFactory {

    //Factory Method
    public FoodList printFoodList(String foodType){
        switch(foodType){
            case "Italian":
                return new ItalianFood();
            case "Chines":
                return new ChinesFood();
            default:
                throw new IllegalArgumentException("Food Type Not Defined");
        }
    }
    
}
