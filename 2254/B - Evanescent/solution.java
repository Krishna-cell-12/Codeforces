import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            char[] s = br.readLine().trim().toCharArray();
            
            // Calculate the initial length of the compressed string
            int k = 1;
            for (int i = 0; i < n - 1; i++) {
                if (s[i] != s[i + 1]) {
                    k++;
                }
            }
            
            int minDelta = 0;
            // Iterate over all allowed indices to drop to find the minimum Delta 
            for (int i = 1; i < n - 1; i++) {
                char left = s[i - 1];
                char mid = s[i];
                char right = s[i + 1];
                
                int before = (left != mid ? 1 : 0) + (mid != right ? 1 : 0);
                int after = (left != right ? 1 : 0);
                int delta = after - before;
                
                if (delta < minDelta) {
                    minDelta = delta;
                }
                
                // If we hit the absolute theoretical minimum change, no need to search further
                if (minDelta == -2) {
                    break;
                }
            }
            
            sb.append(k + minDelta).append("
");
        }
        
        System.out.print(sb.toString());
    }
}