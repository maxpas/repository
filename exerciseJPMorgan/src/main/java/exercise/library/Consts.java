package exercise.library;

public final class Consts {
    public static final String ISBN_PREFIX = "ISBN-";
    public static final String ISBN_NOT_FOUND = "the book with isbn %s has not been found";
    public static final String ISBN_INVALID = "the book isbn must begin with '%s'";
    private Consts(){
        throw new AssertionError();
    }
}
