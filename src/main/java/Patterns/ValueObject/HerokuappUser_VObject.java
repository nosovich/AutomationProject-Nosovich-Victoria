package Patterns.ValueObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HerokuappUser_VObject {
    private String userName;
    private String password;
    private String statusText;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String errorText) {
        this.statusText = statusText;
    }
}
