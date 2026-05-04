// Encapsulation is the wrapping up of data under a single unit
// It is the mechanism that binds together code and the data it manipulates

// Data Hiding is the process of protecting members of a class from unintended changes
// whereas, Abstraction is the process of hiding the implementation details 
// and showing only functionality to the user

// Abstraction is the concept of hiding the complex implementation details 
// and showing only the essential features of the object
// It helps in reducing programming complexity and effort

// Abstract Class:
// - A class that cannot be instantiated and is declared using the 'abstract' keyword
// - It can have abstract methods (without body) as well as concrete methods (with body)
// Abstract Method:
// - A method that is declared without an implementation
// - It must be implemented by the subclasses of the abstract class

// It can have constructors and static methods

abstract class Animals{
    abstract void walk(); // Abstract method
    public void eat(){
        System.out.println("Animals eat food"); // Concrete method
    }

    Animals(){
        System.out.println("Animal constructor called");
    }
}

class Horse extends Animals{
    Horse(){
        System.out.println("Horse constructor called");
    }
    public void walk(){
        System.out.println("Horse walks on 4 legs");
    }
}

class Duck extends Animals{
    public void walk(){
        System.out.println("Duck walks on 2 legs");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.walk();

        // Animals snake = new Animals(); // Error: Cannot instantiate the abstract class

        // Constructor chaining in abstract classes
        // - first the constructor of the abstract class Animals is called, 
        // then the constructor of the subclass Horse is called


    }
}
