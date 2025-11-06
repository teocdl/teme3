package files;

import java.util.Objects;

public class Pair<A extends Comparable<? super A>, B extends Comparable<? super B>>
        implements Comparable<Pair<A,B>> {
    private final A first;
    private final B second;

    public Pair(A first, B second) { this.first = first; this.second = second; }
    public A getFirst() { return first; }
    public B getSecond() { return second; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?,?>)) return false;
        Pair<?,?> p = (Pair<?,?>) o;
        return Objects.equals(first, p.first) && Objects.equals(second, p.second);
    }
    @Override public int hashCode() { return Objects.hash(first, second); }
    @Override public String toString() { return "(" + first + ", " + second + ")"; }

    @Override public int compareTo(Pair<A,B> o) {
        int c = first.compareTo(o.first);
        return (c != 0) ? c : second.compareTo(o.second);
    }
}
