import java.util.Arrays;

public class DFSWithPruning {

    static int INF = 1000001;
    static int ans = INF;

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0 || flights == null || flights.length == 0)
            return -1;

        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        visited[src]=1;


        dfs( flights, src, dst, K + 1, 0, visited);
        return ans == INF ? -1 : ans;
    }

    private static void dfs(int[][] flights, int i, int dst, int k, int cost, int[] visited) {
        if (k < 0) {
            return;
        }

        if (i == dst) {
            ans = cost;
            return;
        }

        for (int[] flight : flights) {
            if (flight[0] == i) {
                if (visited[flight[1]] == 1)
                    continue;
                if (cost + flight[2] > ans)
                    continue;
                visited[flight[1]] = 1;
                dfs(flights, flight[1], dst, k-1, cost + flight[2], visited);
                visited[flight[1]] = 0;
            }
        }

    }
}
