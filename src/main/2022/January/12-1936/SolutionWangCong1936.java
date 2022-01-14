import java.util.*;
public class SolutionWangCong1936 {
    class UndergroundSystem {

        private Map<String, Map<String, long[]>> stationMap;
        private Map<Integer, String> passengerMap;

        public UndergroundSystem() {
            stationMap = new HashMap<>();
            passengerMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            passengerMap.put(id, stationName + "_" + t);
        }

        public void checkOut(int id, String stationName, int t) {
            String[] checkInArray = passengerMap.get(id).split("_");
            String startStation = checkInArray[0];
            int startTime = Integer.parseInt(checkInArray[1]);
            stationMap.putIfAbsent(startStation, new HashMap<>());
            Map<String, long[]>  desStationMap = stationMap.get(startStation);
            desStationMap.putIfAbsent(stationName,  new long[]{0L, 0L});
            long[] timeCalArray = desStationMap.get(stationName);
            timeCalArray[0] = timeCalArray[0] + t - startTime;
            timeCalArray[1] += 1;
        }

        public double getAverageTime(String startStation, String endStation) {
            Map<String, long[]> desStationMap = stationMap.get(startStation);
            long[] timeCalArray = desStationMap.get(endStation);
            return (double) timeCalArray[0] / timeCalArray[1];
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
