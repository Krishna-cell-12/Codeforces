import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int[] tokens = new int[3];
            tokens[0] = Integer.parseInt(st.nextToken());
            tokens[1] = Integer.parseInt(st.nextToken());
            tokens[2] = Integer.parseInt(st.nextToken());
            
            int rounds = 0;
            while (true) {
                // If any two players have the exact same number of tokens, the game ends
                if (tokens[0] == tokens[1] || tokens[1] == tokens[2] || tokens[0] == tokens[2]) {
                    break;
                }
                
                // Sort to easily find the players with the most and fewest tokens
                Arrays.sort(tokens);
                
                // The player with the fewest tokens receives 1
                tokens[0]++;
                // The player with the most tokens gives 1
                tokens[2]--;
                
                rounds++;
            }
            
            System.out.println(rounds);
        }
    }
}