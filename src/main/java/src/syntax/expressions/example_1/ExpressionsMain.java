package src.syntax.expressions.example_1;

public class ExpressionsMain {
    public static void main(String[] args) {
        // #1
        System.out.println(
            "Check if zero for value: " +
            "\n\t'3': " +isZero(3) +
            "\n\t'0': " +isZero(0)
        );
    }

    // #1
    // The 'if..else' in Java is not an expression but statement.
    // It doesn't evaluate to a value, that's why we simply assign the results
    // to a variable initialized outside the block.
    public static boolean isZero(int x) {
        boolean isZero;

        if (x == 0)
            isZero = true;
        else
            isZero = false;

        return isZero;
    }
}
