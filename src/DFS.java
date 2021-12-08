
public class DFS {
    static int INF = 1000001;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0 || flights == null || flights.length == 0)
            return -1;

        int cost = dfs(flights, src, dst, K + 1);
        return cost >= INF? -1 : cost;
    }

    private static int dfs(int[][] flights, int i, int dst, int k) {
        if (k < 0) {
            return INF;
        }

        if (i == dst) {
            return 0;
        }

        int min = INF;
        for (int[] flight : flights) {
            if (flight[0] == i) {
                min = Math.min(min, dfs(flights, flight[1], dst, k - 1) + flight[2]);
            }
        }


        return min;
    }


}