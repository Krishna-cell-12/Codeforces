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
        
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            
            // Check even indices (0, 2, 4, ...)
            boolean aValid = true; // Pattern A: 0, 1, 0, 1...
            boolean bValid = true; // Pattern B: 1, 0, 1, 0...
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) != '?') {
                    int val = s.charAt(i) - '0';
                    int expA = (i / 2) % 2;
                    int expB = 1 - expA;
                    if (val != expA) aValid = false;
                    if (val != expB) bValid = false;
                }
            }
            
            // Check odd indices (1, 3, 5, ...)
            boolean cValid = true; // Pattern C: 0, 1, 0, 1...
            boolean dValid = true; // Pattern D: 1, 0, 1, 0...
            for (int i = 1; i < n; i += 2) {
                if (s.charAt(i) != '?') {
                    int val = s.charAt(i) - '0';
                    int expC = (i / 2) % 2;
                    int expD = 1 - expC;
                    if (val != expC) cValid = false;
                    if (val != expD) dValid = false;
                }
            }
            
            // Calculate valid combinations
            int evenWays = (aValid ? 1 : 0) + (bValid ? 1 : 0);
            int oddWays = (cValid ? 1 : 0) + (dValid ? 1 : 0);
            
            sb.append(evenWays * oddWays).append("
");
        }
        
        System.out.print(sb.toString());
    }
}