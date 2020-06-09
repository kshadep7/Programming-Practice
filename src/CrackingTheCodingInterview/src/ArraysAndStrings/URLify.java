package ArraysAndStrings;

import java.util.Arrays;

public class URLify {

    public static void main(String[] args) {

    }

    public static void URLify(char[] str, int trueLen) {
        // TODO: Not working -> work on it
        int space = 0, newIndex = 0;
        for (int i = 0; i < trueLen; i++) {
            if (str[i] == ' ')
                space++;
        }
        newIndex = trueLen + space * 3;
        if (trueLen < newIndex)
            str[trueLen] = '\0';
        for (int i = trueLen - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newIndex - 1] = '0';
                str[newIndex - 2] = '2';
                str[newIndex - 3] = '%';
                newIndex -= 3;
            } else {
                str[newIndex - 1] = str[i];
                newIndex--;
            }
        }
        System.out.println(Arrays.toString(str));
    }

}
