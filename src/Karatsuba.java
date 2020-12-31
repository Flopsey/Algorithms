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

        int x_h = x >> nHalf;  // higher n/2 bits
        int x_l = x & (1 << nHalf) - 1;  // lower n/2 bits
        int y_h = y >> nHalf;  // higher n/2 bits
        int y_l = y & (1 << nHalf) - 1;  // lower n/2 bits

        int p1 = karatsuba(x_h, y_h);
        int p2 = karatsuba(x_l, y_l);
        int p3 = karatsuba(x_h + x_l, y_h + y_l);

        return (p1 << (nHalf << 1)) + ((p3 - (p1 + p2)) << nHalf) + p2;
    }

}
