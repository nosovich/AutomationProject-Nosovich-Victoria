package MySQL;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper extends DBConnector<SelectHelper> {
    private String select;
    private String from;
    private String where;

    public static SelectHelper getSelect() {
        return new SelectHelper();
    }

    public SelectHelper select(String select) {
        this.select = select;
        return this;
    }

    public SelectHelper from(String from) {
        this.from = from;
        return this;
    }

    public SelectHelper where(String where) {
        this.where = where;
        return this;
    }

    @Override
    public SelectHelper execute() {
        executeQuery("select " + this.select + " from " + this.from + (this.where == null ? "" : " where " + this.where));
        return this;
    }

    public List<List<String>> getListData() {
        List<List<String>> data = new ArrayList<>();
        try {
            ResultSet resultSet = getResultSet();
            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, List<String>> getMapData() {
        Map<String, List<String>> data = new HashMap<>();
        List<List<String>> listData = getListData();
        ResultSet resultSet = getResultSet();
        try {
            List<String> titles = new ArrayList<>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                titles.add(resultSet.getMetaData().getColumnLabel(i));
            }
            for (int i = 0; i < titles.size(); i++) {
                List<String> column = new ArrayList<>();
                for (List<String> listDatum : listData) {
                    column.add(listDatum.get(i));
                }
                data.put(titles.get(i), column);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}