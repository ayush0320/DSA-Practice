// Interface in Java
// - An interface is a reference type in Java, similar to a class, 
// that can contain only constants, method signatures, default methods, 
// static methods, and nested types
// - Interfaces cannot contain instance fields or constructors
// - Pure abstraction can be achieved using interfaces
// - A class can implement multiple interfaces, providing a way to achieve multiple inheritance
// - Interface methods are abstract by default (without a body) unless they are default or static methods
// - All fields in an interface are public, static, and final by default
// - All methods are public & abstract by default
// - A class that implements an interface must implement all of its methods

interface Animal {
    int eyes = 2; // public, static, final by default
    void eat(); // Abstract method
}

interface Herbivore {
    void eatPlants();
}

// Multiple interface implementation
// Not possible to create multiple inheritance using classes in Java
// but can be achieved using interfaces
class Horse implements Animal, Herbivore {
    public void eat() { // Must be public
        System.out.println("Horse eats grass");
    }

    public void eatPlants() {
        System.out.println("Horse eats plants");
    }
}

public class Interface {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.eat();

    }
}
