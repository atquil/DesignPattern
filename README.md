# Factory Design Pattern [Under Creational Pattern]

### Problem
A resturant can have different menus, and in future other list can be added. 

```
        ┌────────────────────┐
        │                    │
   ┌────┤                    ├─────┐
   │    │     RESTURANT      │     │
   │    │                    │     │
   │    └─────────┬──────────┘     │
   ▼              │                ▼
┌─────────┐       │         ┌─────────┐
│         │       │         │         │
│ INDIAN  │       │         │ ITALIAN │     ┌─────────────────┐
└─────────┘       │         └─────────┘     │ Something Elase │
                  ▼                         └─────────────────┘
           ┌──────────┐
           │ CHINES   │
           └──────────┘
```

### Solution : 

### Step 1 : Common Interface
Create an `common product / product` i.e. `interface` with having basic functionality that you want to have

```
public interface FoodList {
    void FoodType();
}
```

### Step 2 : Create Concrete class and implement the interface
Create a `concrete product` i.e. `implementing` class/ abstract class, for specific product group like Indian or Chines

```
public class ChinesFood implements FoodList {

    @Override
    public void FoodType() {
       System.out.println("Chines food : MOMO");
        
    }
    
}
```

```
public class ItalianFood implements FoodList {


@Override
public void FoodType() {
    System.out.println("Italian food : Pasta");
    
    }
}
```

### Step 3: Create a ` Factory ` to generate object of concrete class
The `creator class` declares the `factory method` , which returns the new product object which matches the `product interface`
    - Can declare factory method `abstract` : To force all subclasses to implement their own versions of the method. 
    - Creator class generally has some `business logic` related to product classes
```

public class FoodFactory {

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
```

### Step 4 Create `Service` to use the Factory to get the object of concrete class by passing information 
`concrete creator` will override the base factory method, to return different type of product
```
public class MyFoodService {
    public static void main(String[] args) {
        
        FoodFactory foodType = new FoodFactory();
        
        FoodList foodList1 = foodType.printFoodList("Italian");
        foodList1.FoodType();

        FoodList foodList2 = foodType.printFoodList("Chines");
        foodList2.FoodType();
    }
}
```

### Output : 

```
Italian food : Pasta
Chines food : MOMO
```

