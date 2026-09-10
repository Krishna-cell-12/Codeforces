import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);
 
            int oddCount = 0;
            HashMap<Integer, Integer> cntT = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if ((a[i] & 1) == 1) {
                    oddCount++;
                } else {
                    int ti = a[i] / 2;
                    cntT.merge(ti, 1, Integer::sum);
                }
            }
 
            long ans = oddCount;
 
            if (!cntT.isEmpty()) {
                ArrayList<int[]> evenList = new ArrayList<>();
                ArrayList<int[]> oddList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> e : cntT.entrySet()) {
                    int tv = e.getKey();
                    int c = e.getValue();
                    if ((tv & 1) == 0) evenList.add(new int[]{tv, c});
                    else oddList.add(new int[]{tv, c});
                }
                evenList.sort((x, y) -> Integer.compare(x[0], y[0]));
                oddList.sort((x, y) -> Integer.compare(x[0], y[0]));
 
                int en = evenList.size();
                int[] evenTs = new int[en];
                long[] evenPrefix = new long[en];
                for (int i = 0; i < en; i++) {
                    evenTs[i] = evenList.get(i)[0];
                    evenPrefix[i] = (i == 0 ? 0 : evenPrefix[i - 1]) + evenList.get(i)[1];
                }
 
                int on = oddList.size();
                int[] oddTs = new int[on];
                long[] oddPrefix = new long[on];
                for (int i = 0; i < on; i++) {
                    oddTs[i] = oddList.get(i)[0];
                    oddPrefix[i] = (i == 0 ? 0 : oddPrefix[i - 1]) + oddList.get(i)[1];
                }
 
                TreeSet<Long> candidates = new TreeSet<>();
                candidates.add(0L);
                for (int tv : cntT.keySet()) {
                    if (tv - 1 >= 0) candidates.add((long) (tv - 1));
                    candidates.add((long) tv);
                    candidates.add((long) (tv + 1));
                }
 
                long maxEven = 0;
                for (long k : candidates) {
                    int parityK = (int) (k & 1L);
                    long val0 = sumParity(parityK, k, evenTs, evenPrefix, oddTs, oddPrefix);
                    long val2 = sumParity(1 - parityK, k, evenTs, evenPrefix, oddTs, oddPrefix);
                    Integer pointCnt = cntT.get((int) (k + 1));
                    if (pointCnt != null) val2 += pointCnt;
                    if (val0 > maxEven) maxEven = val0;
                    if (val2 > maxEven) maxEven = val2;
                }
 
                ans = Math.max(ans, maxEven);
            }
 
            sb.append(ans).append('
');
        }
 
        System.out.print(sb);
    }
 
    private static long sumParity(int parity, long k, int[] evenTs, long[] evenPrefix,
                                   int[] oddTs, long[] oddPrefix) {
        int[] ts = (parity == 0) ? evenTs : oddTs;
        long[] prefix = (parity == 0) ? evenPrefix : oddPrefix;
        if (ts.length == 0) return 0;
        int lo = 0, hi = ts.length - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (ts[mid] <= k) { res = mid; lo = mid + 1; }
            else hi = mid - 1;
        }
        return (res == -1) ? 0 : prefix[res];
    }
 
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == -1) return -1;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}