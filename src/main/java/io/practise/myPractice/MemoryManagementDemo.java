package io.practise.myPractice;
 
public class MemoryManagementDemo {
    public static void main(String[] args) {
        // 1. Stack reference 'mainCourse' points to heap Lasagna object
        Dish mainCourse = new Dish("Lasagna"); 
        
        // 2. Call prepareDessert() -> pushes a new stack frame
        prepareDessert(); 
        // Once prepareDessert() returns, its frame is popped.
        // The Mousse object created inside it is now eligible for GC!
        
        // 3. Re-assigning reference orphans the original Lasagna object
        mainCourse = new Dish("Spaghetti"); 
        // Lasagna is now unreachable and eligible for GC!
        
        // 4. Setting to null breaks the final reference path
        mainCourse = null; 
        // Spaghetti is now also eligible for GC!
        
        System.out.println("Memory setup completed. Ready for cleanup robot!");
    }
 
    private static void prepareDessert() {
        // Stack reference 'tempBowl' exists only inside this method frame
        Dish tempBowl = new Dish("Chocolate Mousse"); 
        System.out.println("Mixing: " + tempBowl.getName());
    }
}
 
class Dish {
    private String name;
 
    public Dish(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
}
