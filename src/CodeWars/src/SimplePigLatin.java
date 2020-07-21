public class SimplePigLatin {

    public static void main(String[] args) {
        String str = "Hello World !";

        System.out.println(pigIt(str));
    }

    static String pigIt(String str) {
        if (str == null || str.length() == 0)
            return str;
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (Character.isAlphabetic(temp.charAt(0))) {
                String newStr = rearrange(temp);
                arr[i] = newStr;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    static String rearrange(String temp) {
        return temp.substring(1, temp.length()) +
                temp.charAt(0) +
                "ay";
    }
}
