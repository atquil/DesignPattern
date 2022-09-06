public class Singleton {
    
    // Creating a object of a 
    private static Singleton singletonInstance = new Singleton();

    // Making it private so that it is not accessible from outside 
    /// e.g. cannot do new Singleton() from outside. 
    private Singleton(){}

    public static Singleton getInstance(){
        return singletonInstance;
    }

    public void printMessage(){
        System.out.println("SINGLETON OBJECT");
    }
}
