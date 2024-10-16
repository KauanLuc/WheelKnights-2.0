package wheel.knights.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MiniatureNotFoundException extends RuntimeException {
    public MiniatureNotFoundException(String message) {
        super(message);
    }
}
