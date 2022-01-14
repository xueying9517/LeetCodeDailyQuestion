import java.util.*;

public class SolutionXueYing1936 {
    class UndergroundSystem {
        Map<Integer, CheckIn> in;
        Map<String, Map<String, CheckOut>> out;
        public UndergroundSystem() {
            in = new HashMap<>();
            out = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            in.put(id, new CheckIn(t, stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckIn c = in.get(id);
            if (out.containsKey(c.stationName)) {
                Map<String, CheckOut> map = out.get(c.stationName);
                if (map.containsKey(stationName)) {
                    CheckOut o = map.get(stationName);
                    map.put(stationName, new CheckOut(o.sum + t - c.t, o.count + 1));
                } else {
                    map.put(stationName, new CheckOut(t - c.t, 1));
                }
                out.put(c.stationName, map);
            } else {
                Map<String, CheckOut> map = new HashMap<>();
                map.put(stationName, new CheckOut(t - c.t, 1));
                out.put(c.stationName, map);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            Map<String, CheckOut> map = out.get(startStation);
            CheckOut o = map.get(endStation);
            return o.sum / o.count;
        }
        class CheckIn {
            int t;
            String stationName;
            CheckIn(int t, String stationName) {
                this.t = t;
                this.stationName = stationName;
            }
        }
        class CheckOut {
            double sum;
            int count;
            CheckOut(double sum, int count) {
                this.sum = sum;
                this.count = count;
            }
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
