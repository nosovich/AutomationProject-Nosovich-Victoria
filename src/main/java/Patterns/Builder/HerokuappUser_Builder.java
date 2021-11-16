package Patterns.Builder;

public class HerokuappUser_Builder {
    private String userName;
    private String password;
    private String statusText;


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getStatusText() {
        return statusText;
    }

    public static class Builder {
        private HerokuappUser_Builder userBuilder;

        public Builder() {
            userBuilder = new HerokuappUser_Builder();
        }

        public Builder withUserName(String username) {
            userBuilder.userName = username;
            return this;
        }

        public Builder withPassword(String password) {
            userBuilder.password = password;
            return this;
        }

        public Builder withStatusText(String statusText) {
            userBuilder.statusText = statusText;
            return this;
        }

        public HerokuappUser_Builder build() {
            return userBuilder;
        }
    }
}
