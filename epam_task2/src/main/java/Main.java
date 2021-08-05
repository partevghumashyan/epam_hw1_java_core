import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDTO userDTO = new UserDTO("A","arm*mail.ru",LocalDate.of(2007,8,15),500);

        ValidatorService<UserDTO> validatorService = new ValidatorService();
        ArrayList<Error> errors = validatorService.validate(userDTO);
        System.out.println(errors);

    }
}
