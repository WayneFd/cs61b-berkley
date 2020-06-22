package tree;

import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;
class k {
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Stack<Character> helper = new Stack<>();
        int next = 0;
        for (int i = 0 ; i < num.length(); i++) {
            if (k == 0) {
                break;
            }
            next ++;
            if (helper.isEmpty()) {
                if (num.charAt(i) != '0')
                {helper.push(num.charAt(i));}
            } else {
                if (num.charAt(i) < helper.peek()) {
                    helper.pop();
                    if (!(num.charAt(i) == '0' && helper.isEmpty())){
                        helper.push(num.charAt(i));
                    }
                    k--;
                } else {
                    helper.push(num.charAt(i));
                }
            }
        }
        String ans = "";
        while(helper.size() > 1) {
            ans = helper.pop() + ans;
        }
        if (!helper.isEmpty() && helper.peek() != '0') {
            ans = helper.pop() + ans;
        }
        ans = ans + num.substring(next);
        while (k != 0) {
            ans = ans.substring(1);
            k--;
        }
        while (ans.startsWith("0")) {
            ans = ans.substring(1);
        }
        if (ans.length() == 0) {
            return "0";
        }
        return ans;
    }
    public static void main(String[] args) {
        String s= "1234567890";
        int n = 9;
        removeKdigits(s,n);
    }
}