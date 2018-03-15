public class Calculator {
    public int Add(int a, int b){
        int result = a ^ b;
        int carry = (a & b) << 1;
        if (carry != 0) {
            return Add(result, carry);
        }
        return result;
    }

    public int Subtract(int a, int b){
        while (b != 0)
        {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }

    public int Divide(int dividend, int divisor) {
        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { // Check for signed bit
            negative = !negative;
            dividend = Add(~dividend, 1);  // Negation
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = Add(~divisor, 1);  // Negation
        }
        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i = Subtract(i, 1)) {
            r = (divisor << i);
            // Left shift divisor until it's smaller than dividend
            if (r < Integer.MAX_VALUE && r >= 0) { // Avoid cases where comparison between long and int doesn't make sense
                if (r <= dividend) {
                    quotient |= (1 << i);
                    dividend = Subtract(dividend, (int) r);
                }
            }
        }
        if (negative) {
            quotient = Add(~quotient, 1);
        }
        return quotient;
    }


    public int Multiply(int a, int b){
        // initialize result
        int res = 0;

        // While second number doesn't become 1
        while (b > 0)
        {
            // If second number becomes odd,
            // add the first number to result
            if ((b & 1) != 0)
                res = res + a;

            // Double the first number
            // and halve the second number
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }
}
