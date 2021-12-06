import java.util.*;

public class cheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        int[][] e2 = {{0, 3, 7}, {4, 5, 3}, {6, 4, 8}, {6, 5, 6}, {1, 2, 2}, {2, 5, 9}, {2, 6, 8},
                {3, 6, 3}, {4, 0, 10}, {4, 6, 8}, {5, 2, 6}, {1, 4, 3}, {4, 1, 6}, {0, 5, 10}, {3, 1, 5},
                {4, 3, 1}, {5, 4, 10}, {0, 1, 6}};
        long start = System.nanoTime();
        System.out.println(BellmanFord.findCheapestPrice(7, e2, 2, 4, 2));
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time elapsed in nanoseconds is: " + timeElapsed);
    }
}
