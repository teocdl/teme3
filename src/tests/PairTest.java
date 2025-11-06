package tests;


import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import files.Pair;

public class PairTest {
    @Test
    public void testIntegerFloatPairs() {
        Pair<Integer, Float> p1 = new Pair<>(1, 2.5f);
        Pair<Integer, Float> p2 = new Pair<>(1, 2.5f);
        Pair<Integer, Float> p3 = new Pair<>(1, 3.0f);
        Pair<Integer, Float> p4 = new Pair<>(0, 9.9f);

        // equals + hashCode
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);

        // sort by natural order (first, then second)
        List<Pair<Integer, Float>> list = new ArrayList<>(Arrays.asList(p1, p3, p4));
        Collections.sort(list);
        assertEquals(Arrays.asList(p4, p1, p3), list);

        // binary search on the same ordering
        int idx = Collections.binarySearch(list, new Pair<>(1, 2.5f));
        assertTrue(idx >= 0);
        assertEquals(p1, list.get(idx));
    }
}
