import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-28
 */
public class SolutionWangCong1996 {

    public int numberOfWeakCharacters(int[][] properties) {
        // key表示攻击值i，value表示攻击值i存在的最大防御值，倒序排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<>( (o1, o2) -> o2-o1);
        for(int i = 0 ; i < properties.length; i++) {
            int defence = treeMap.getOrDefault(properties[i][0], 0);
            if( properties[i][1] > defence ) {
                treeMap.put(properties[i][0], properties[i][1]);
            }
        }
        for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            Integer key = entry.getKey();
            Map.Entry<Integer, Integer> lowerEntry = treeMap.lowerEntry(key);
            if(lowerEntry != null) {
                if(lowerEntry.getValue() > entry.getValue()) {
                    entry.setValue(lowerEntry.getValue());
                }
            }
            // System.out.println(entry);
        }
        // Integer firstKey = treeMap.firstKey();
        // treeMap.put(firstKey, 0);
        int result = 0;
        for(int i = 0 ; i < properties.length; i++) {
            Map.Entry<Integer, Integer> lowerEntry = treeMap.lowerEntry(properties[i][0]);
            if(lowerEntry == null) {
                continue;
            }

            // int maxDefence = treeMap.get(properties[i][0]);
            int maxDefence = lowerEntry.getValue();
            // System.out.println(properties[i][0] + "," + properties[i][1]+","+ maxDefence);
            if(maxDefence > properties[i][1]) {
                result++;
            }
        }
        return result;
    }
}
