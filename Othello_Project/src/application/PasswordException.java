package application;

/**
 * Custom exception for handling incorrect passwords
 */
class PasswordException extends Exception {
	public PasswordException(String string) {
        super(string);
    }
}