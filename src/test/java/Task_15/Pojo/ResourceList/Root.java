package Task_15.Pojo.ResourceList;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Root {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum> data;
    public Support support;
}
