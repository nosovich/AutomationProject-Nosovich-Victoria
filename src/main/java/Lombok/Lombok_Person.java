package Lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lombok_Person {

    private String firstName;
    private String lastName;
    private String zipCode;

}

