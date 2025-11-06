package files;

import java.util.Objects;

public class Flower implements Comparable<Flower> {
    private final String name;
    private final int length;

    public Flower(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() { return name; }
    public int getLength() { return length; }

    // equality by content (both fields) so HashSet removes duplicates
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower f = (Flower) o;
        return length == f.length && Objects.equals(name, f.name);
    }

    @Override public int hashCode() { return Objects.hash(name, length); }

    // natural order: length ascending, then name
    @Override public int compareTo(Flower o) {
        int c = Integer.compare(this.length, o.length);
        if (c != 0) return c;
        return this.name.compareTo(o.name);
    }

    @Override public String toString() {
        return name + "(" + length + ")";
    }
}
