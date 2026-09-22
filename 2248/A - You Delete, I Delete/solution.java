import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            int n = s.length();
            String bestAlice = "";
            
            // Alice tries deleting every possible '0'
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    StringBuilder sb = new StringBuilder(s);
                    sb.deleteCharAt(i); // Alice's move
                    
                    // Bob's optimal move is always to delete the first '1' he finds
                    int firstOne = sb.indexOf("1");
                    if (firstOne != -1) {
                        sb.deleteCharAt(firstOne); // Bob's move
                    }
                    
                    String candidate = sb.toString();
                    
                    // Alice wants to maximize the lexicographical value
                    if (bestAlice.isEmpty() || candidate.compareTo(bestAlice) > 0) {
                        bestAlice = candidate;
                    }
                }
            }
            
            System.out.println(bestAlice);
        }
        
        scanner.close();
    }
}