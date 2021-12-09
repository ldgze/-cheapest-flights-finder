public class DFSWithMemoization {


    static int INF = 1000001;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0 || flights == null || flights.length == 0)
            return -1;
        int[][] memo = new int[n][K+2];
        int ans = dfs(flights, src, dst, K + 1, memo);
        return ans >= INF ? -1 : ans;
    }

    private static int dfs(int[][] flights, int i, int dst, int k, int[][] memo) {
        if (k < 0) {
            return INF;
        }

        if (i == dst) {
            return 0;
        }

        if (memo[i][k] != 0) {
            return memo[i][k];
        }

        int cost = INF;
        for (int[] flight : flights) {
            if (flight[0] == i) {
                int weight = flight[2];
                cost = Math.min(cost, dfs(flights, flight[1], dst, k - 1, memo) + weight);
            }
        }

        memo[i][k] = cost;

        return cost;
    }

}
