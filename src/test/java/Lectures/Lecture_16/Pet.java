package Lectures.Lecture_16;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Pet {
    private String type;
    private Integer age;
    private String name;
}
