//package weshare.webtests.pages;
//
///*
// ** DO NOT CHANGE!!
// */
//
//
//import org.openqa.selenium.By;
//import weshare.webtests.WebTestRunner;
//
//public class LoginPage extends AbstractPage {
//    public static final String PAGE_PATH = "/";
//    private final By EMAIL_FIELD = By.name("email");
//
//    @Override
//    public String path() {
//        return PAGE_PATH;
//    }
//
//    public LoginPage(WebTestRunner testRunner) {
//        super(testRunner);
//    }
//
//    public aExpensesPage loginUser(String email) {
//        fillText(EMAIL_FIELD, email);
//        submit();
//        return new ExpensesPage(testRunner);
//    }
//
//}
