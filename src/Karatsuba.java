public class Karatsuba {

    public static void main(String[] args) {
        // Examples:

        System.out.println(karatsuba(34, 5930));  // 201620

        int x = (int) (Math.pow(2, Math.random() * Integer.SIZE) / 2);
        int y = (int) (Math.pow(2, Math.random() * Integer.SIZE) / 2);
        System.out.println(karatsuba(x, y) == x * y);  // true
    }

    public static int karatsuba(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("No negative factors allowed");
        }

        int n = Integer.SIZE - Math.min(Integer.numberOfLeadingZeros(x), Integer.numberOfLeadingZeros(y));
        int nHalf = n >> 1;

        if (n <= 1) {
            return x & y;
        }

        int xHigh = x >> nHalf;  // higher n/2 bits
        int xLow = x & (1 << nHalf) - 1;  // lower n/2 bits
        int yHigh = y >> nHalf;  // higher n/2 bits
        int yLow = y & (1 << nHalf) - 1;  // lower n/2 bits

        int p1 = karatsuba(xHigh, yHigh);
        int p2 = karatsuba(xLow, yLow);
        int p3 = karatsuba(xHigh + xLow, yHigh + yLow);

        return (p1 << (nHalf << 1)) + ((p3 - (p1 + p2)) << nHalf) + p2;
    }

}
