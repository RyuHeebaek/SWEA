import java.io.*;
import java.util.*;

public class SWEA_1983 {

    static int T, N, K;
    static student[] students;

    static String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            students = new student[N];

            putVal();

       
            Arrays.sort(students, new stdSort());

            int rank = 0;
            for (int i = 0; i < N; i++) {
                if (students[i].idx == (K - 1)) {
                    rank = i;
                    break;
                }
            }

            int gradeIdx = rank / (N / 10);

            sb.append("#").append(tc).append(" ")
              .append(grades[gradeIdx])
              .append("\n");
        }
        System.out.println(sb);
    }

    private static void putVal() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int middle = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pj = Integer.parseInt(st.nextToken());

            double total = (middle * 0.35) + (end * 0.35) + (pj * 0.20);
            students[i] = new student(total, i);
        }
    }
}

class stdSort implements Comparator<student> {
    @Override
    public int compare(student o1, student o2) {
        return Double.compare(o2.grade, o1.grade);
    }
}

class student {
    double grade;
    int idx;   
    public student(double grade, int idx) {
        this.grade = grade;
        this.idx = idx;
    }
}