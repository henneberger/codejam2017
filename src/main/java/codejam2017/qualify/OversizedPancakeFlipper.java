package codejam2017.qualify;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by henneberger on 4/8/17.
 */
public class OversizedPancakeFlipper {

    public static String test(final String test, final int k) {
        BitSet bit = new BitSet(); // + == 0, - == 1
        char[] c = test.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '-') bit.set(i);
        }
        if (bit.isEmpty()) {
            return "0";
        }

        int flipIndex = 0;
        int count = 0;
        do{
            while (!bit.get(flipIndex)) flipIndex++; //clear from right to left
            if (c.length - flipIndex >= k) { //sanity check
                bit.flip(flipIndex, flipIndex + k); //flip k bits
                count++;
            }
        } while (!bit.isEmpty() && c.length - flipIndex >= k);

        return bit.isEmpty() ? count + "" : "IMPOSSIBLE";
    }

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(Paths.get("/Users/henneberger/Downloads/A-large.in"));
        PrintWriter out = new PrintWriter("src/main/java/codejam2017/qualify/A-large-2.out");
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            out.write(String.format("Case #%1$d: %2$s\n", i + 1, test(in.next(), in.nextInt())));
        }
        out.close();
    }
}
