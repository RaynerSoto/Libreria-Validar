package org.poty;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ConversionObjetos{
    
    public static <T> T convertirHashMapaObject(HashMap<String,Object> lista, Class<T> clase) throws Exception {
        T objeto = clase.getDeclaredConstructor().newInstance();
        for (Field f : clase.getDeclaredFields()){
            if(lista.containsKey(f.getName())){
                f.setAccessible(true);
                f.set(objeto, lista.get(f.getName()));
            }
        }
        return objeto;
    }
}
