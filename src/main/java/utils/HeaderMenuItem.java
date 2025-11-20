package utils;

public enum HeaderMenuItem {
    IL_CARRO("//a[@class=\"logo\"]"),
    SEARCH("//a[text()=\" Search \"]"),
    LET_THE_CAR_WORK("//a[text()=\" Let the car work \"]"),
    TERMS_OF_USE("//a[text()=\" Terms of use \"]"),
    SIGN_UP("//a[text()=\" Sign up \"]"),
    LOGIN("//a[text()=\" Log in \"]"),
    ;

    private final String locator;

    HeaderMenuItem(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
