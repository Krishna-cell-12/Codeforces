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
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            boolean[] avail = new boolean[26];
            
            // Populate the initial set of available characters from ordinary words
            for (int i = 0; i < n; i++) {
                String w = br.readLine().trim();
                if (!w.isEmpty()) {
                    char first = w.charAt(0);
                    if (first >= 'a' && first <= 'z') {
                        avail[first - 'a'] = true;
                    } else if (first >= 'A' && first <= 'Z') {
                        avail[first - 'A'] = true;
                    }
                }
            }
            
            // Read abbreviations
            String[] abbrs = new String[m];
            for (int i = 0; i < m; i++) {
                abbrs[i] = br.readLine().trim();
            }
            
            boolean[] used = new boolean[m];
            int count = 0;
            boolean changed = true;
            
            // Greedily form abbreviations while our pool of available letters expands
            while (changed) {
                changed = false;
                for (int i = 0; i < m; i++) {
                    if (!used[i]) {
                        boolean canForm = true;
                        
                        // Check if all characters to form this abbreviation are available
                        for (int j = 0; j < abbrs[i].length(); j++) {
                            char c = abbrs[i].charAt(j);
                            if (c >= 'A' && c <= 'Z' && !avail[c - 'A']) {
                                canForm = false;
                                break;
                            }
                        }
                        
                        if (canForm) {
                            used[i] = true;
                            count++;
                            char first = abbrs[i].charAt(0);
                            
                            // If the new abbreviation grants us a character we didn't already have,
                            // we flag `changed = true` to verify the remaining words again.
                            if (first >= 'A' && first <= 'Z' && !avail[first - 'A']) {
                                avail[first - 'A'] = true;
                                changed = true;
                            }
                        }
                    }
                }
            }
            
            if (count == m) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}