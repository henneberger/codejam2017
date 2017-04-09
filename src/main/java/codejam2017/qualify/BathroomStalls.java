package codejam2017.qualify;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by henneberger on 4/8/17.
 */
public class BathroomStalls {

    public static String test(final long cnt, final long p) {
        Stack<Long> lst = new Stack<>();
        long node = p;
        while (node != 1) {
            lst.push(node % 2);
            node = node / 2;
        }

        long parent = cnt;
        for (long rem : lst) {
            parent = (parent - rem) / 2;
        }

        return parent/2 + " " + (parent - 1)/2;
    }

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(Paths.get("/Users/henneberger/Downloads/C-large.in"));
        PrintWriter out = new PrintWriter("src/main/java/codejam2017/qualify/C-large.out");
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            out.write(String.format("Case #%1$d: %2$s\n", i + 1, test(in.nextLong(), in.nextLong())));
        }
        out.close();
    }
}
