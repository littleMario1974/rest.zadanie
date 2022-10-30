package pl.wsb.rest.example.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Nie znaleziono zasobu !");
    }
}
