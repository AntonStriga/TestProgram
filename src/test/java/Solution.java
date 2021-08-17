import java.util.Arrays;

import static java.lang.Math.abs;

public class Solution {

    public static void main(String[] args) {

        String target = "(){}[]";

        System.out.println(isValid(target));

    }

    public static boolean isValid(String s) {
        boolean result = true;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    break;
                case ')':
                    break;
                case '[':
                    break;
                case ']':
                    break;
                case '{':
                    break;
                case'}':
                    break;
                default:
                    System.out.println(s.charAt(i));
            }
        }

        return result;
    }

}
