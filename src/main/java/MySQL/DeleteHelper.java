package MySQL;

public class DeleteHelper extends DBConnector{
    private String from;
    private String where;

    public static DeleteHelper getDelete() {
        return new DeleteHelper();
    }

    public DeleteHelper from(String from) {
        this.from = from;
        return this;
    }

    public DeleteHelper where(String where) {
        this.where = where;
        return this;
    }

    @Override
    public DeleteHelper execute() {
        executeUpdate("delete from " + this.from + " where " + this.where);
        return this;
    }
}

}
