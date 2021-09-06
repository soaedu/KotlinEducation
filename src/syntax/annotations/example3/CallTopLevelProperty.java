package syntax.annotations.example3;

public class CallTopLevelProperty {
    public static void main(String[] args) {
        // #5
        // AnnotationsMainKt.answer         // Impossible
        // AnnotationsMainKt.getAnswer();   // Correct

        // #6, #7
        int answerLocal = AnnotationsMainKt.answer;
    }
}
