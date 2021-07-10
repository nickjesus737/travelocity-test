package co.com.devco.certification.exceptions.flights;

public class BookFlightException extends AssertionError{

    public static final String BOOK_INCONSISTENT_INFORMATION_MESSAGE = "Inconsistencia en la información de la reserva del vuelo.";

    public BookFlightException(String message, Throwable cause) {
        super(message, cause);
    }

}
