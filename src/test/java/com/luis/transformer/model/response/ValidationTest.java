package com.luis.transformer.model.response;

import com.google.common.base.Objects;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.validation.FieldError;

public class ValidationTest {

    public ValidationTest() {
    }

    @Test
    public void testFromFieldError() {
        
        String[] a = {"code"};
        Object[] b = {"object"};
        
        FieldError fielError = new FieldError( "object name", "field", "", true, a, b, "message");        
        Validation validation = Validation.fromFieldError(fielError);
        
        assertThat("the code should be equals", Objects.equal(fielError.getCode(), validation.getCode()), is(true));
        assertThat("the field should be equals", Objects.equal(fielError.getField(), validation.getField()), is(true));
        assertThat("the message should be equals", Objects.equal(fielError.getDefaultMessage(), validation.getMessage()), is(true));
        
    }

}
