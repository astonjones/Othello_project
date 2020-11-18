package application;

/**
 * Custom exception for handling incorrect passwords
 *
 * Author: Ryan Campbell
 */
class PasswordException extends Exception {

    private static final long serialVersionUID = 1L;

    public PasswordException(String string) {
        super(string);
    }
}
