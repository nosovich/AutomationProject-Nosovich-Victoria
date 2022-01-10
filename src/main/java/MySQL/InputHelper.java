package MySQL;

public class InputHelper extends DBConnector<InputHelper> {
    private String table;
    private String into;
    private String values;

    public static InputHelper getInput() {
        return new InputHelper();
    }

    public InputHelper into(String into) {
        this.into = into;
        return this;
    }

    public InputHelper values(String values) {
        this.values = values;
        return this;
    }

    public InputHelper table(String table) {
        this.table = table;
        return this;
    }

    @Override
    public InputHelper execute() {
        executeUpdate("insert into " + this.table + " (" + this.into + ") " + "values" + " (" + this.values + ")");
        return this;
    }
}
