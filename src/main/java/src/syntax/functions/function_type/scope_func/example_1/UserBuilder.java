package src.syntax.functions.function_type.scope_func.example_1;

import src.syntax.functions.function_type.scope_func.example_1.User;

public class UserBuilder {
    String name = null;
    String address = null;
    String email = null;

    public void setName(final String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User build() {
        return new User(name, address, email);
    }
}
