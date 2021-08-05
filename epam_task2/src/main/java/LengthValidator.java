import lombok.SneakyThrows;


import java.lang.reflect.Field;

public class LengthValidator{
    public static Error validator(Object o) throws Exception {
        Class cls = o.getClass();

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Length.class)) {
                Object o1 = field.get(o);
                Length annotation = field.getAnnotation(Length.class);

                if (o1 instanceof String) {
                    if (!(((String) o1).length() > annotation.min() && ((String) o1).length() < annotation.max())) {
                        return new Error("Specified word is not of a valid length");
                    }
                }
            }

        }
        return null;
    }
}
