package Tasks.Task_15_RestAPI.Pojo.UserList;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Datum {
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
}
