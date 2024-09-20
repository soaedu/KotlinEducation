package src.syntax.functions.function_type.scope_func.example_1;

public class User {
    private String name = null;
    private String address = null;
    private String email = null;

    public User(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}