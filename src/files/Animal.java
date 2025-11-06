package files;

import java.util.List;

public class Animal {
    protected int value;

    public Animal() { this.value = 1; }

    public int getValue() { return value; }

    //  the three methods go here
    public static void addAnimal(List<? super Animal> dst, Animal a) { dst.add(a); }
    public static void addCat(List<? super Cat> dst, Cat c) { dst.add(c); }
    public static void addFish(List<? super Fish> dst, Fish f) { dst.add(f); }

    
    public static int sum(List<? extends Animal> src) {
        int s = 0;
        for (Animal a : src) s += a.getValue();
        return s;
    }
}
