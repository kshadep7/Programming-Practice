public class ContiguousSubarray {

    //contiguous subarrays, such that each element of the subarray appears at least twice.

    public static void main(String[] args) {

    }

/*
     static int duplicates(vector<int> v){

        int ans=0;
        for(int end=0;end<v.size();end++){
            unordered_map<int,int> M;
            int num_unique=0;
            for(int start=end;start>=0;start--){
                int x=v[start];
                M[x]++;
                if(M[x]==1)num_unique++;
                else if(M[x]==2)num_unique--;

                if(num_unique==0) ans++;
            }
        }
        return ans;
    }
*/
}
