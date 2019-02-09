package javatests;

class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}