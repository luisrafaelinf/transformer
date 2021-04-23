package com.luis.transformer.configuration;

import com.luis.transformer.exception.BattlefieldDestroyedException;
import com.luis.transformer.exception.EntityAlreadyExistException;
import com.luis.transformer.exception.TieTeamBattleException;
import com.luis.transformer.model.response.Validation;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvisor {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({TieTeamBattleException.class})
    public Map handleTieTeamBattleException(TieTeamBattleException ex) {
        return getStatusInfo(ex.getLocalizedMessage());
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BattlefieldDestroyedException.class})
    public Map handleBattlefieldDestroyedException(BattlefieldDestroyedException ex) {
        return getStatusInfo(ex.getLocalizedMessage());
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EntityNotFoundException.class})
    public Map handleItemNotFoundException(EntityNotFoundException ex) {
        return getStatusInfo(ex.getLocalizedMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public Map handleItemNotFoundException(IllegalArgumentException ex) {
        return getStatusInfo(ex.getLocalizedMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({EntityAlreadyExistException.class})
    public Map handleItemAlreadyExistException(EntityAlreadyExistException ex) {
        return getStatusInfo(ex.getLocalizedMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        
        Map body = getStatusInfo("Validation request. Invalid argument");

        List<Validation> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(Validation::fromFieldError)
                .collect(Collectors.toCollection(LinkedList::new));

        body.put("errors", errors);
        
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex) {
        
        Map body = getStatusInfo("Violation request argument");

        List<Validation> errors = ex.getConstraintViolations()
                .stream()
                .map(Validation::fromConstraintViolation)
                .collect(Collectors.toCollection(LinkedList::new));

        body.put("errors", errors);
        
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private Map<String, Object> getStatusInfo(String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message", message);

        return body;
    }
}
