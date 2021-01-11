public class ConcatenateArrayPieces {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int[][] pieces = {{3}, {1, 2}, {5}};

        int[] arr1 = {1, 2, 5, 3};
        int[][] pieces1 = {{3}, {2, 1}, {5}};

        int[] arr2 = {1, 2, 5, 3};
        int[][] pieces2 = {{1, 3}, {2, 5}};

        System.out.println(canWeConcatenate(arr2, pieces2));
    }

    static boolean canWeConcatenate(int[] arr, int[][] pieces) {

        //check for len(arr) and total length of pieces
        // converting arr into string
        // looping thru the pieces and for every peice tostring check if that substring is preesent in
        // main string if no then false else true

        //base case
        int sum = 0;
        int len = arr.length;
        StringBuilder sb;
        for (int[] piece : pieces) {
            sum += piece.length;
        }

        sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        String mainStr = sb.toString();

        if (sum == len) {
            for (int[] piece : pieces) {
                sb = new StringBuilder();
                for (int i : piece) {
                    sb.append(i);
                }
                String subStr = sb.toString();
                int index = mainStr.indexOf(subStr);
                if (index == -1)
                    return false;
            }
            return true;
        }
        return false;
    }
}
