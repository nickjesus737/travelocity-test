package co.com.devco.certification.exceptions.stays;

public class BookStayException extends AssertionError{

    public static final String BOOK_STAY_INCONSISTENT_INFORMATION_MESSAGE = "Inconsistencia en la información de la reserva del hospedaje.";

    public BookStayException(String message, Throwable cause) {
        super(message, cause);
    }

}
