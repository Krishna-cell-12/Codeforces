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
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int B = n - k;
            
            // If we require fewer than 2 blocks, all characters would be identical,
            // violating the condition that the counts of 0 and 1 differ by at most 1.
            if (B < 2) {
                out.append("-1
");
                continue;
            }
            
            // Distribute total counts of 0s and 1s evenly
            int c0 = (n + 1) / 2;
            int c1 = n / 2;
            
            // Distribute block counts between 0s and 1s
            int b0 = (B + 1) / 2;
            int b1 = B / 2;
            
            // Determine the sizes of the first blocks
            int first0Size = 1 + (c0 - b0);
            int first1Size = 1 + (c1 - b1);
            
            // Append the first 0 block
            for (int i = 0; i < first0Size; i++) {
                out.append('0');
            }
            
            // Append the first 1 block
            for (int i = 0; i < first1Size; i++) {
                out.append('1');
            }
            
            // Append the remaining alternating blocks of size 1
            for (int i = 2; i < B; i++) {
                if (i % 2 == 0) {
                    out.append('0');
                } else {
                    out.append('1');
                }
            }
            
            out.append("
");
        }
        
        System.out.print(out);
    }
}