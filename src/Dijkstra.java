import java.util.*;

public class Dijkstra {
    static class Flight {
        int src;
        int dst;
        int price;

        Flight (int src, int dst, int price) {
            this.src = src;
            this.dst = dst;
            this.price = price;
        }
    }

    static class Stop {
        int id, cost, count;
        Stop(int id, int cost, int count) {
            this.id = id;
            this.cost = cost;
            this.count = count;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, ArrayList<Flight>> map = new HashMap<>();

        for (int[] flight: flights) {
            if (!map.containsKey(flight[0])) {
                map.put(flight[0], new ArrayList<>());
            }
            map.get(flight[0]).add(new Flight(flight[0], flight[1], flight[2]));
        }
        Comparator<Stop> cmp = Comparator.comparingInt(s -> s.cost);
        PriorityQueue<Stop> q = new PriorityQueue<>(cmp);

        q.offer(new Stop(src, 0, K));
        while (q != null && !q.isEmpty()) {
            Stop cur = q.poll();
            if (cur.id == dst) {
                return cur.cost;
            }

            if (cur.count >= 0) {
                List<Flight> list = map.get(cur.id);
                if (list == null) {
                    continue;
                }
                for (Flight f: list) {
                    q.offer(new Stop(f.dst, f.price + cur.cost, cur.count - 1));
                }
            }
        }
        return -1;
    }
}



