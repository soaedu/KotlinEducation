package data.type.classes.type.object_class.companion_object.example8;

public class CallCompanionObjectMethods {
    public static void main(String[] args) {
        C.Companion.foo();
        C.Companion.bar();

        C.foo();
        // C.bar();    // impossible
    }
}
