package PageObject.Herokuapp;

public enum HomePageLinksEnum {
    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_UPLOADER("File Upload"),
    FRAMES("Frames");

    String link;
    HomePageLinksEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
