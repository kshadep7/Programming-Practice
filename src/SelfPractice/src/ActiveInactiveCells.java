import java.util.ArrayList;
import java.util.List;

public class ActiveInactiveCells {

    public static void main(String[] args) {
        int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(cellCompete(states, 1));
    }

    public static List<Integer> cellCompete(int[] states, int days) {
        int pre = 0;
        int next = 0;
        while (days-- > 0) {

            for (int i = 0; i < states.length; i++) {

                if (i == 0) {
                    pre = states[i];
                    if(0 == states[i+1])
                        states[i] = 0;
                    else states[i] = 1;
                }
//                pre =
            }
        }
        List<Integer> out = new ArrayList<>();
        for (int i : states)
            out.add(i);

        return out;
    }

}
