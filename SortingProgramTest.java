import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.*;

class SortingProgramTest {
    static Sort sort;
    int[] expected = {1, 2, 3, 4};
    int[] actual = {1, 4, 3, 2};
    int[] sortedArray;
    
    @BeforeAll
    static void initAll() {
        sort = new Sort();
    }

    @Test
    void testBubbleSort() { 
        sortedArray = sort.sortWithBubbleSort(actual);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    void testQuickSort() { 
        sortedArray = sort.sortWithQuickSort(actual, 0, actual.length - 1);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    void testInsertionSort() { 
        sortedArray = sort.sortWithInsertionSort(actual);
        assertArrayEquals(expected, sortedArray);
    }
}