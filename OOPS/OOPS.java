// https://www.youtube.com/watch?v=bSrm9RXwBaI
// Example of OOPS concepts: Class and Object

// OOPS - Object Oriented Programming Systems
// 1. Class and Object
// 2. Inheritance
// 3. Polymorphism
// 4. Abstraction
// 5. Encapsulation
// 6. Interface

// Class is a blueprint for creating objects
// Object is an instance of a class
// Class is a user-defined data type 
// that contains data members (attributes) and member functions (methods)

// Static members belong to the class rather than any specific instance
// and can be accessed without creating an object of the class

// Defining a class named 'pen'
// Blueprint for creating pen objects
class Pen {

    // Data members (attributes) of the class
    String colour;
    String type;

    // Member function to simulate writing action
    public void write() {
        System.out.println("Writing something");
    }

    public void printColour() {
        System.out.println(this.colour);
    }
}

class Student {
    String name;
    int age;

    // public void info() {
    // System.out.println(this.name);
    // System.out.println(this.age);
    // }

    // this is a keyword that refers to the current object

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Student(Student s2) {
        this.name = s2.name;
        this.age = s2.age;
    }
    public void info() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

// Main class to demonstrate the use of the 'pen' class
public class OOPS {
    public static void main(String[] args) {

        Pen p1 = new Pen(); // Creating an object of the Pen class
        p1.colour = "blue"; // Setting the colour attribute
        p1.type = "gel"; // Setting the type attribute
        p1.write(); // Calling the write method

        // new is a keyword that allocates memory to the object in the heap memory

        Pen p2 = new Pen();
        p2.colour = "black";
        p2.type = "ballpoint";

        // p1.printColour();
        // p2.printColour();

        // ----------------------------------------------------------------------

        Student s1 = new Student("Alice", 22);
        s1.info();

        Student s2 = new Student(s1); // Using copy constructor
        s2.info();

        // Student() is the constructor that initializes the object
        // -name of class and name of constructor should be the same
        // -constructor does not have a return type
        // -constructor is called automatically when a object is created
        // -constructor is called only once per object
        // -three types of constructors:
        // 1. default constructor (no parameters)
        // 2. parameterized constructor (with parameters)
        // 3. copy constructor (not in Java, but in C++)
        // Java has automatic garbage collection, so no need for destructors
    }
}