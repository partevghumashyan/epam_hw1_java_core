import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDTO {

    @Length(min = 2, max = 20)
    private String name;


    @Email
    private String email;

    @Adulthood
    private LocalDate birthday;

    @Min(min = 0)
    @Max(max = 100)
    private int discountRate;

}
