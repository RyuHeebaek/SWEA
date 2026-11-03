import java.io.*;
import java.util.*;

class SWEA_5432 {

    static Stack<Character> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int TestCases = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= TestCases; i++) {

            String str = br.readLine();
            int result = 0;

            for(int j = 0 ; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if (str.charAt(j) == ')'  && str.charAt(j-1) != ')') {
                    stack.pop();
                    result += stack.size();
                } else {
                    stack.pop();
                    result += 1;
                }
            }
            sb.append("#").append(i).append(" ").append(result).append("\n");

        }

        System.out.println(sb);

    }
}