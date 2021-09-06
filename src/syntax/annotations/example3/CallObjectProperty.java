package syntax.annotations.example3;

public class CallObjectProperty {
    public static void main(String[] args) {
        // #1
        // SuperComputer.INSTANCE.getAnswer();

        // #2
        // SuperComputer.getAnswer();

        // #3, #4
        int answerLocal = SuperComputer.answer;
    }
}
