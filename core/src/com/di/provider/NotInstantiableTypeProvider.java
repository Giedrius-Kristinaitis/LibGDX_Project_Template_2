package com.di.provider;

public class NotInstantiableTypeProvider {

    private static final Class<?>[] NOT_INSTANTIABLE_TYPES = {
            Byte.class,
            Short.class,
            Integer.class,
            Long.class,
            Float.class,
            Double.class,
            String.class,
            Character.class,
            Boolean.class,
            byte.class,
            short.class,
            int.class,
            long.class,
            float.class,
            double.class,
            char.class,
            boolean.class
    };

    public Class<?>[] getTypes() {
        return NOT_INSTANTIABLE_TYPES;
    }
}
