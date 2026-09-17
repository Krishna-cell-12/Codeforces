import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) throws IOException {
        // The maximum value of n is 2 * 10^5, so n + 1 can be up to 200001
        int MAX = 200005;
        boolean[] isPrime = new boolean[MAX + 1];
        
        // Sieve of Eratosthenes to precompute primes
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= MAX; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= MAX; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            
            // The only card that can win against all others is n + 1, and only if it's prime
            if (isPrime[n + 1]) {
                sb.append("YES
");
            } else {
                sb.append("NO
");
            }
        }
        
        System.out.print(sb.toString());
    }
}