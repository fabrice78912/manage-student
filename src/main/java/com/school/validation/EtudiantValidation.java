package com.school.validation;

import com.school.model.Etudiant;



import javax.validation.*;
import java.util.Set;

public class EtudiantValidation {

    private static final Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static void validate(Etudiant etudiant) throws ValidationException {
        Set<ConstraintViolation<Etudiant>> violations = validator.validate(etudiant);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation failed for Etudiant:\n");

            for (ConstraintViolation<Etudiant> violation : violations) {
                errorMessage.append("- ").append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new org.example.common.exception.ValidationException(errorMessage.toString());
        }
    }
}

