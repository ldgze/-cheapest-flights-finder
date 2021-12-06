import java.util.Arrays;

public class BellmanFord {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0 || flights == null || flights.length == 0)
            return -1;

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= K; i++) {
            int[] currCost = cost.clone();

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];

                if (cost[s] == Integer.MAX_VALUE)
                    continue;

                if (currCost[d] > cost[s] + flight[2]) {
                    currCost[d] = cost[s] + flight[2];
                }
            }

            cost = currCost;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
