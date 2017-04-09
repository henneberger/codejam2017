package codejam2017.qualify;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by henneberger on 4/8/17.
 */
public class TidyNumbers {

    public static String test(final String num) {
        int nums[] = num.chars()
                .map(c->c-'0')
                .toArray();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                nums[i - 1]--;
                for (int j = i; j < num.length(); j++) {
                    nums[j] = 9;
                }
                i = 0; //restart
            }
        }
        testTidy(nums);
        String number = IntStream.of(nums).collect(StringBuilder::new, StringBuilder::append, (i, j)->{}).toString();

        return new BigInteger(number).toString(); //truncate 0s
    }

    public static void testTidy(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                System.out.println("Something maybe wrong with " + Arrays.toString(nums));
            }
        }
    }
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(Paths.get("/Users/henneberger/Downloads/B-large.in"));
        PrintWriter out = new PrintWriter("src/main/java/codejam2017/qualify/B-large.out");
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++) {
            out.write(String.format("Case #%1$d: %2$s\n", i + 1, test(in.next())));
        }
        out.close();
    }
}
