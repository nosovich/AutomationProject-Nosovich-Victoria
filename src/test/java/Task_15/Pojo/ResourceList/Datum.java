package Task_15.Pojo.ResourceList;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Datum {
    public int id;
    public String name;
    public int year;
    public String color;
    public String pantone_value;
}
