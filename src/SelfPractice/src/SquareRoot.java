public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(findSquareRoot(16));
	}

	// using binary search
	// the idea is applt this logic where i^2 <= n
	// so all values in array from 1 to n will be true for above condition
	// so check mid <= n/mid and we have find the last true index as that will be the ans
	// eg 1 2 3 4 5 6 7 8 9
	//    t t t f f f f f f  -> for above condition arr[i] ^ 2 <= n
	// in this case 3 will the ans
	static int findSquareRoot(int n){
		int lo = 1, hi = n;
		int res = -1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(mid  <= n/mid){
				res = mid;
				lo = mid +1;
			}else
				hi = mid -1;
		}

		return res;
	}
}
