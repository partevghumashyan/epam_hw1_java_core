import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class AdultHoodValidator {
    public static Error validator(Object o) throws Exception {
        Class cls = o.getClass();
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Adulthood.class)) {
                Object o1 = field.get(o);
                LocalDate now = LocalDate.now();
                if (o1 instanceof LocalDate) {
                    Period period = Period.between((LocalDate) o1,now);
                    if (!(period.getYears() >= 18)){
                       return new Error("Adulthood is not reached");
                    }
                }
            }

        }
        return null;
    }
}
