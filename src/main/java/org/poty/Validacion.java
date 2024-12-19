package org.poty;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class Validacion {
    private static Validator validator;

    private Validacion(){}

    public static Set<String> listarValidacionesNoCumplidastoSet(Object elemento){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(elemento).
                stream().map(con -> con.getMessage())
                .collect(Collectors.toSet());
    }

    public static List<String> listarValidacionesNoCumplidastoList(Object elemento){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(elemento).
                stream().map(con -> con.getMessage())
                .toList();
    }

    public static void validarElemento(Object elemento){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        for(ConstraintViolation con : validator.validate(elemento)){
            throw new UnsupportedOperationException(con.getMessage());
        }
    }
}
