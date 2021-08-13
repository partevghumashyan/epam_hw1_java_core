import java.lang.reflect.Field;

public class MaxValidator {
    public static Error validator(Object o) throws Exception {
        Class cls = o.getClass();


        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Max.class)) {
                Object o1 = field.get(o);
                Max annotation = field.getAnnotation(Max.class);
                field.set(o,annotation.max());
                if (o1 instanceof Integer) {
                    if (!(((int) o1) < annotation.max())) {
                        return new Error("Invalid value(max)");
                    }
                }
            }

        }
        return null;
    }
}
