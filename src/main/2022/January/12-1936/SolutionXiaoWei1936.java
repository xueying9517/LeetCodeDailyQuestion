import java.util.*;
public class SolutionXiaoWei1936 {
    class UndergroundSystem {
    Map<String, List<Integer>> index;
    Map<Integer, Entry> idIndex;
    private static class Entry {
        public String stationName;
        public int t;
        public Entry(String stationName, int t) {
            this.stationName = stationName;
            this.t = t;
        }
    }
    public UndergroundSystem() {
        index = new HashMap<>();
        idIndex = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idIndex.put(id, new Entry(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Entry entry = idIndex.get(id);
        idIndex.remove(id);
        String key = entry.stationName + "_" + stationName;
        if(!index.containsKey(key)) {
            index.put(key, new ArrayList<>());
        }
        index.get(key).add(t - entry.t);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "_" + endStation;
        double sum = 0.0;
        int cnt = 0;
        for(Integer i : index.get(key)) {
            sum += i;
            cnt++;
        }
        return sum / cnt;
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
