import java.util.*;

// https://leetcode.com/discuss/interview-question/809456/robinhood-codesignal-online-assessment/675399

/*
 * restore array using given pairs
 * pairs[i] are neighbors of each other
 *
 * {{3, 5}, {2, 4}, {1, 4}, {1, 5}}
 * out -> [3,5,4,1,2] or [2 1 4 5 3]
 * */

public class RestoreArray {

    public static void main(String[] args) {

        int[][] pairs = {{3, 5}, {2, 4}, {1, 4}, {1, 5}};
        restoreArr(pairs);
    }

    static List<Integer> restoreArr(int[][] pairs) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        // create graph

        for (int[] ints : pairs) {
            createGraph(map, ints[0], ints[1]);
            createGraph(map, ints[1], ints[0]);
        }
        System.out.println(map);
        // get start of the res array
        List<Integer> res = new ArrayList<>();
        int start = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                start = key;
                res.add(key);
                break;
            }
        }
        Set<Integer> ans = new LinkedHashSet<>();
        ans.add(start);
        while (!map.get(start).isEmpty()) {
            Deque<Integer> dq = map.get(start);
            if (!dq.isEmpty()) {
                for (int i = 0; i < dq.size(); i++) {
                    int add = dq.removeFirst();
                    if (!ans.contains(add)) {
                        ans.add(add);
                        start = add;
                        break;
                    }
                }
            } else
                break;
        }
        System.out.println(ans);
        res.addAll(ans);
        return res;
    }

    static void createGraph(Map<Integer, Deque<Integer>> map, int key, int value) {
        if (!map.containsKey(key)) {
            Deque<Integer> lsNew = new ArrayDeque<>();
            lsNew.add(value);
            map.put(key, lsNew);
        } else {
            Deque<Integer> ls = map.get(key);
            ls.offerFirst(value);
            map.put(key, ls);
        }
    }


    /*
     int main() {
    int n;
    cin >> n;
    vector<vector<int>> pairs;
    for(int i = 0; i < n; i ++){
        vector<int> add(2);
        cin >> add[0] >> add[1];
        pairs.push_back(add);
    }
    unordered_map<int, queue<int>> map;
    for(int i = 0; i < pairs.size(); i ++){
        map[pairs[i][0]].push(pairs[i][1]);
        map[pairs[i][1]].push(pairs[i][0]);
    }
    vector<int> array;
    int start;
    for(pair<int, queue<int>> key: map){
        if(key.second.size() == 1){
            start = key.first;
            array.push_back(start);
            break;
        }
    }
    while(map[start].size() != 0){
        int add = map[start].front();
        map[start].pop();
        if(add == start || map[add].size() == 0){
            if(map[start].size() == 0)
                break;
            add = map[start].front();
        }
        map[start] = queue<int>();
        start = add;
        array.push_back(start);
    }
    for(int i : array)
        cout << i << " ";
    return 0;
}
     */

}
