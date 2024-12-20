package org.poty;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class Validacion{
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private Validacion(){}

    public static <T> Set<String> listarValidacionesNoCumplidastoSet(T elemento){
        return validator.validate(elemento).
                stream().map(con -> con.getMessage())
                .collect(Collectors.toSet());
    }

    public static <T> List<String> listarValidacionesNoCumplidastoList(T elemento){
        return validator.validate(elemento).
                stream().map(con -> con.getMessage())
                .toList();
    }

    /**
     * @apiNote {@summary = Función de validación de los elementos}
     * @exception UnsupportedOperationException
     * @param elemento
     */
    public static <T> void validarElemento(T elemento){
        for(ConstraintViolation con : validator.validate(elemento)){
            throw new UnsupportedOperationException(con.getMessage());
        }
    }
}
