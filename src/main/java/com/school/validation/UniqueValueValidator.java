package com.school.validation;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    // Your logic to check uniqueness goes here
    private final Set<String> uniqueValues = new HashSet<>();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Implement your uniqueness check logic

        // If the value is null or empty, consider it valid
        if (value == null || value.trim().isEmpty()) {
            return true;
        }

        // Check if the value is unique
        boolean isUnique = uniqueValues.add(value);

        // If not unique, set a custom error message
        if (!isUnique) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Value must be unique").addConstraintViolation();
        }

        return isUnique;
    }


}
