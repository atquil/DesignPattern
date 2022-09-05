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

 1. Create an `common product / product` i.e. `interface` with having basic functionality that you want to have
 2. Create a `concrete product` i.e. `implementing` class/ abstract class, for specific product group like Indian or Chines
 3. Create a `creator` class to declare a `factory method` or `client code` which will have a object of `concrete product`
 4. 
## Steps

### Step 1 : Create Common Interface

```
public interface FoodList {
    void FoodType();
}
```

### Step 2 : Create Concrete class and implement the interface

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

