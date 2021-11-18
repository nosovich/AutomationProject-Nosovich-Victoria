package Tasks.Task_15.Pojo.UserList;

import lombok.Data;

import java.util.List;

@Data
public class UserList {
        public int page;
        public int per_page;
        public int total;
        public int total_pages;
        public List<Datum> data;
        public Support support;
}
