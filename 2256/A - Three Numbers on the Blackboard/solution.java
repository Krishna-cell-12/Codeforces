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
            long[] nums = new long[3];
            nums[0] = Long.parseLong(st.nextToken());
            nums[1] = Long.parseLong(st.nextToken());
            nums[2] = Long.parseLong(st.nextToken());
            
            // Sort the array to easily identify x (smallest), y (middle), and z (largest)
            Arrays.sort(nums);
            
            long x = nums[0];
            long y = nums[1];
            long z = nums[2];
            
            // The minimum range is either the initial range or replacing the largest with the sum of the other two
            long initialRange = z - x;
            long replacedRange = y;
            
            System.out.println(Math.min(initialRange, replacedRange));
        }
    }
}