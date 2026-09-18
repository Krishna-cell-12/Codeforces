import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String firstToken = scanner.next();
        if (firstToken == null) return;
 
        int t = Integer.parseInt(firstToken);
        StringBuilder out = new StringBuilder();
 
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long m = scanner.nextLong();
 
            // By the Pigeonhole Principle, if m < k, a subarray of length <= m < k 
            // with sum divisible by m is inevitable.
            if (m < k) {
                out.append("NO
");
            } else {
                out.append("YES
");
                long specialVal = m - k + 1;
                for (int i = 1; i <= n; i++) {
                    if (i % k == 0) {
                        out.append(specialVal);
                    } else {
                        out.append(1);
                    }
                    if (i < n) {
                        out.append(' ');
                    } else {
                        out.append('
');
                    }
                }
            }
        }
 
        System.out.print(out.toString());
    }
}