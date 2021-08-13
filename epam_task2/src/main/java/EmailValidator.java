import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static Error validator(Object o) throws Exception {
        Class cls = o.getClass();

        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        Pattern pattern = Pattern.compile(regex);


        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Email.class)) {
                Object o1 = field.get(o);
                if (o1 instanceof String) {
                    Matcher matcher = pattern.matcher((String) o1);
                    if (!(matcher.matches())) {
                        return new Error("Invalid email");
                    }
                }
            }

        }
        return null;
    }
}
