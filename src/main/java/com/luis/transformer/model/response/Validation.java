package com.luis.transformer.model.response;

import javax.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Validation {

    private String code;
    private String field;
    private String message;
    
    public static Validation fromFieldError(FieldError error) {
        return new Validation(error.getCode(), error.getField(), error.getDefaultMessage());
    }
    
    public static Validation fromConstraintViolation(ConstraintViolation error) {
        
        final int index = error.getPropertyPath().toString().lastIndexOf(".");
        final String field = error.getPropertyPath().toString().substring(index);
                
        return new Validation(error.getLeafBean().toString(), field, error.getMessage());
    }
    
}
