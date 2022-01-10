package MySQL;

public class UpdatedHelper extends DBConnector<UpdatedHelper> {
    private String table;
    private String set;
    private String where;

    public static UpdatedHelper getUpdate() {
        return new UpdatedHelper();
    }

    public UpdatedHelper set(String set) {
        this.set = set;
        return this;
    }

    public UpdatedHelper where(String where) {
        this.where = where;
        return this;
    }

    public UpdatedHelper table(String table) {
        this.table = table;
        return this;
    }

    @Override
    public UpdatedHelper execute() {
        executeUpdate("update " + this.table + " set " + this.set + " where " + this.where);
        return this;
    }
}
