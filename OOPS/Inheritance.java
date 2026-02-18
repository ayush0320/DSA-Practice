// Inheritance in Java
// Inheritance is a mechanism where one class acquires the properties (fields) and behaviors (methods) of another class
// The class which inherits the properties of another class is called the subclass (child class)
// The class whose properties are inherited is called the superclass (parent class)

// Access Modifiers in Inheritance
// 1. public: The member is accessible from any other class
// 2. protected: The member is accessible within the same package and subclasses
// 3. default (no modifier): The member is accessible only within the same package
// 4. private: The member is accessible only within the same class

class Shape {
    String color;
}

// 1.Single Level Inheritance
// Triangle will inherit the properties of Shape class
class Triangle extends Shape {

    public void area(int l, int h) {
        System.out.println(0.5 * l * h);
    }
}

// 2.Multilevel Inheritance
// EquilateralTriangle inherits from Triangle, which in turn inherits from Shape
class EquilateralTriangle extends Triangle {
    public void area(int side) {
        System.out.println("This is an equilateral triangle.");
    }
}

// 3.Hierarchical Inheritance
// Circle will inherit the properties of Shape class
class Circle extends Shape {
    public void area(int r) {
        System.out.println(Math.PI * r * r);
    }
}

// 4.Hybrid Inheritance is not directly supported in Java due to the "Diamond
// Problem"
// 5. Multiple Inheritance is not supported in Java using classes to avoid
// complexity and ambiguity

public class Inheritance {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        t1.color = "Red"; // Inherited property from Shape class

    }
}
