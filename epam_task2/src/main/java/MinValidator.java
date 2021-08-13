import java.lang.reflect.Field;

public class MinValidator {
    public static Error validator(Object o) throws Exception {
        Class cls = o.getClass();

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Min.class)) {
                Object o1 = field.get(o);
                Min annotation = field.getAnnotation(Min.class);
                if (o1 instanceof Integer) {
                    if (!(((int) o1) > annotation.min())) {
                        return new Error("Invalid value(min)");
                    }
                }
            }

        }
        return null;
    }
}
