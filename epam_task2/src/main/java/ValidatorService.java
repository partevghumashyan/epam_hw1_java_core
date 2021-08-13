import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;

public class ValidatorService<T> {
    public ArrayList<Error> validate(T object) throws Exception {
        ArrayList<Error> errors = new ArrayList<>();

        Error error1 = LengthValidator.validator(object);
        Error error2 = EmailValidator.validator(object);
        Error error3 = MaxValidator.validator(object);
        Error error4 = MinValidator.validator(object);
        Error error5 = AdultHoodValidator.validator(object);

        errors.add(error1);
        errors.add(error2);
        errors.add(error3);
        errors.add(error4);
        errors.add(error5);

        return errors;
    }

}
