public class ExceptionAlarm {

	public static void main(String[] args) {

	}

	//
	public static boolean[] isAlarm(int[] requests, int inARow, int expCount, int lastRequests) {
		int count = 0;
		int lastRecentRequests = 0;
		boolean[] res = new boolean[requests.length];

		for (int i = 0; i < requests.length; i++) {
			if (requests[i] == 'E') {
				count++;
				if (lastRecentRequests <= lastRequests)
					lastRecentRequests++;
				else lastRecentRequests = 0;
			}


		}

		return res;
	}
}
