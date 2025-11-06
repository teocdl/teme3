package files;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class FlowerCollection {
    private final HashSet<Flower> set = new HashSet<>();

    public void add(Flower fl) {
        set.add(fl); // de-dup by Flower.equals/hashCode
    }

    public HashSet<Flower> getHashSet() {
        return set;
    }

    // natural ascending (length, then name)
    public List<Flower> getSortedList() {
        List<Flower> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // reverse: length descending, then name descending
    public List<Flower> getReverseSortedList() {
        List<Flower> list = new ArrayList<>(set);
        list.sort(getReverseFlowerComparator());
        return list;
    }

    public Comparator<Flower> getReverseFlowerComparator() {
        return Comparator
                .comparingInt(Flower::getLength).reversed()
                .thenComparing(Flower::getName, Comparator.reverseOrder());
    }
}
