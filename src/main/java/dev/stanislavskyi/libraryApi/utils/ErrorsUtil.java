package dev.stanislavskyi.libraryApi.utils;

import dev.stanislavskyi.libraryApi.exception.PersonNotCreatedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsUtil {
    public static String returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMsg.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage())
                    .append(";");
        }

        //throw new PersonNotCreatedException((errorMsg.toString()));
        return errorMsg.toString();
    }
}
