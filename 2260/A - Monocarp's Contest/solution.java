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
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            
            int[] a = new int[n];
            int zerosCount = 0;
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == 0) {
                    zerosCount++;
                }
            }
            
            // If there are less than 2 easy problems overall, it's impossible
            if (zerosCount < 2) {
                sb.append("-1
");
            } else {
                int swaps = 0;
                // Check if the first problem needs to be swapped
                if (a[0] == 1) {
                    swaps++;
                }
                // Check if the last problem needs to be swapped
                if (a[n - 1] == 1) {
                    swaps++;
                }
                sb.append(swaps).append("
");
            }
        }
        
        System.out.print(sb.toString());
    }
}