class Animal {
    String type;
    int age;

    // Polymorphism is the ability of an object to take on many forms
    // Two types of polymorphism in Java:
    // 1. Compile-time polymorphism (method overloading)
    // - same method name with different parameters
    // - resolved at compile time
    public void printInfo(String type) {
        System.out.println(type);
    }

    public void printInfo(int age) {
        System.out.println(age);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.type = "Dog";
        a1.age = 5;
        a1.printInfo(a1.type); // Compile-time polymorphism
        a1.printInfo(a1.age); // Compile-time polymorphism
    }
}
