import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
 
        int t = Integer.parseInt(br.readLine().trim());
 
        while (t-- > 0) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            // We only need the first mountain of Bea.
            st = new StringTokenizer(br.readLine());
            long a1 = Long.parseLong(st.nextToken());
 
            // Read remaining Bea mountains.
            for (int i = 1; i < n; i++) {
                st.nextToken();
            }
 
            // We only need the first mountain of Ver.
            st = new StringTokenizer(br.readLine());
            long b1 = Long.parseLong(st.nextToken());
 
            // Read remaining Ver mountains.
            for (int i = 1; i < m; i++) {
                st.nextToken();
            }
 
            long bea = a1 + n - 1L;
            long ver = b1 + m - 1L;
 
            if (bea >= ver) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}