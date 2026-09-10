import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in));
        StringBuilder sb = new StringBuilder();
        in.nextToken();
        int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a[i] = (int) in.nval;
            }
 
            int firstMinus1 = -1, lastMinus1 = -1;
            int firstOne = -1, lastOne = -1;
            int prevOne = -1;
            int maxGapLen = 0;
 
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) {
                    if (firstMinus1 == -1) firstMinus1 = i;
                    lastMinus1 = i;
                } else if (a[i] == 1) {
                    if (firstOne == -1) firstOne = i;
                    lastOne = i;
                    if (prevOne != -1) {
                        int gap = i - prevOne + 1;
                        if (gap > maxGapLen) maxGapLen = gap;
                    }
                    prevOne = i;
                }
            }
 
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = (a[i] == -1) ? 0 : a[i];
            }
 
            if (firstOne == -1) {
                // no existing 1 at all
                if (firstMinus1 == -1) {
                    // no -1 either, array stays all zeros
                } else if (firstMinus1 == lastMinus1) {
                    res[firstMinus1] = 1;
                } else {
                    res[firstMinus1] = 1;
                    res[lastMinus1] = 1;
                }
            } else {
                int leftExtLen = 0;
                if (firstMinus1 != -1 && firstMinus1 < firstOne) {
                    leftExtLen = firstOne - firstMinus1 + 1;
                }
                int rightExtLen = 0;
                if (lastMinus1 != -1 && lastMinus1 > lastOne) {
                    rightExtLen = lastMinus1 - lastOne + 1;
                }
 
                int best = maxGapLen;
                int type = 0; // 0 = internal gap (or nothing needed), 1 = left ext, 2 = right ext
                if (leftExtLen > best) {
                    best = leftExtLen;
                    type = 1;
                }
                if (rightExtLen > best) {
                    best = rightExtLen;
                    type = 2;
                }
 
                if (type == 1) {
                    res[firstMinus1] = 1;
                } else if (type == 2) {
                    res[lastMinus1] = 1;
                }
            }
 
            for (int i = 0; i < n; i++) {
                sb.append(res[i]);
                if (i < n - 1) sb.append(' ');
            }
            sb.append('
');
        }
 
        System.out.print(sb);
    }
}