import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();
 
        in.nextToken();
        int t = (int) in.nval;
 
        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a[i] = (int) in.nval;
            }
 
            int cap = n + 5; // safe upper bound for indices we care about
            int[] cnt = new int[cap + 1];
            for (int i = 0; i < n; i++) {
                if (a[i] <= cap) cnt[a[i]]++;
            }
 
            int m3 = -1;
            for (int i = 0; i <= cap; i++) {
                if (cnt[i] < 3) { m3 = i; break; }
            }
            int cm3 = cnt[m3];
 
            char[] res = new char[n];
            boolean possible = true;
 
            if (cm3 == 0) {
                // A = B = C = m3
                int[] used = new int[cap + 1];
                for (int i = 0; i < n; i++) {
                    int v = a[i];
                    if (v < m3) {
                        int u = used[v]++;
                        res[i] = u == 0 ? 'A' : u == 1 ? 'B' : u == 2 ? 'C' : 'A';
                    } else {
                        res[i] = 'A';
                    }
                }
            } else if (cm3 == 1) {
                if (m3 == 0) {
                    possible = false;
                } else {
                    // A = B = m3, C = m3 + 1
                    int[] used = new int[cap + 1];
                    for (int i = 0; i < n; i++) {
                        int v = a[i];
                        if (v < m3) {
                            int u = used[v]++;
                            res[i] = u == 0 ? 'A' : u == 1 ? 'B' : u == 2 ? 'C' : 'A';
                        } else if (v == m3) {
                            res[i] = 'C';
                        } else {
                            // v == m3+1 or beyond: must avoid C
                            res[i] = 'A';
                        }
                    }
                }
            } else {
                // cm3 == 2 : A = B = T2, C = m3
                int T2 = -1;
                for (int i = m3 + 1; i <= cap; i++) {
                    if (cnt[i] < 2) { T2 = i; break; }
                }
                int[] used = new int[cap + 1];
                for (int i = 0; i < n; i++) {
                    int v = a[i];
                    if (v < m3) {
                        int u = used[v]++;
                        res[i] = u == 0 ? 'A' : u == 1 ? 'B' : u == 2 ? 'C' : 'A';
                    } else if (v >= m3 && v < T2) {
                        int u = used[v]++;
                        res[i] = u == 0 ? 'A' : u == 1 ? 'B' : 'C';
                    } else if (v == T2) {
                        res[i] = 'C';
                    } else {
                        res[i] = 'A';
                    }
                }
            }
 
            if (!possible) {
                sb.append("NO
");
            } else {
                sb.append("YES
").append(res).append('
');
            }
        }
 
        System.out.print(sb);
    }
}