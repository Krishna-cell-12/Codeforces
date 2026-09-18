import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            
            long d = y - x;
            long total = 0;
            
            long L = x;
            // We only need to manually compute the modulo while the divisor is <= d
            long R = Math.min(x + k - 1, d);
            long processedCount = 0;
            
            if (L <= R) {
                for (long j = L; j <= R; j++) {
                    total += d % j;
                }
                processedCount = R - L + 1;
            }
            
            // For all divisors j > d, d % j is always exactly d
            long remaining = k - processedCount;
            total += remaining * d;
            
            sb.append(total).append("
");
        }
        
        System.out.print(sb.toString());
    }
}