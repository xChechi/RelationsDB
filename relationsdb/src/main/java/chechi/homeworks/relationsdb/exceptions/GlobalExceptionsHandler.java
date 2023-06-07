package chechi.homeworks.relationsdb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionsHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handlerUserNotFound (UserNotFoundException msg) {

        return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
    }
}
