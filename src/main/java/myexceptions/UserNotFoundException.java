// myexceptions/UserNotFoundException.java
package myexceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(int userId) {
        super("User not found with ID: " + userId);
    }
}
