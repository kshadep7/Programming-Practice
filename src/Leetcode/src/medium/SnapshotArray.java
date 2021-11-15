package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {

	int[] arr;
	Map<Integer, int[]> snapHistory;
	int snap_id = -1;

	public static void main(String[] args) {
		SnapshotArray snapshotArray = new SnapshotArray(3);
		snapshotArray.set(0, 5);
		snapshotArray.snap();
		snapshotArray.set(0, 6);
		System.out.println(snapshotArray.get(0, 0));
	}

	public SnapshotArray(int length) {
		arr = new int[length];
		snapHistory = new HashMap<>();
	}

	// n as set is called n times
	public void set(int index, int val) {
		arr[index] = val;
	}

	// 1
	public int snap() {
		snapHistory.put(++snap_id, Arrays.copyOf(arr, arr.length));
		return snap_id;
	}

	// 1 as map lookup and get value from arr using index
	public int get(int index, int snap_id) {
		if (snapHistory.containsKey(snap_id)) {
			return snapHistory.get(snap_id)[index];
		}
		return -1;
	}

	/*
	Time Complexity:

SnapshotArray(int length): O(n)
set(int index, int val): O(1)
snap(): O(1)
get(int index, int snap_id): O(log(Set))

	class SnapshotArray {
    List<int[]>[] record;
    int sid;

    public SnapshotArray(int length) {
        record = new List[length];
        sid = 0;
        for (int i = 0; i < length; i++) {
            record[i] = new ArrayList<>();
            record[i].add(new int[]{0, 0});
        }
    }

    public void set(int index, int val) {
        if (record[index].get(record[index].size() - 1)[0] == sid) {
            record[index].get(record[index].size() - 1)[1] = val;
        } else
            record[index].add(new int[]{sid, val});
    }

    public int snap() {
        return sid++;
    }

    public int get(int index, int snap_id) {
        int idx = Collections.binarySearch(record[index], new int[]{snap_id, 0},
                                           (a, b) -> Integer.compare(a[0], b[0]));
        if (idx < 0) idx = - idx - 2;
        return record[index].get(idx)[1];
    }
}
	 */
}
