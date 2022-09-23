//package weshare.webtests;
//
///*
// ** DO NOT CHANGE!!
// */
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import weshare.model.Person;
//import weshare.persistence.PersonDAO;
//import weshare.server.ServiceRegistry;
//
//import java.io.IOException;
//import java.util.stream.Stream;
//
//import static weshare.model.DateHelper.TODAY;
//import static weshare.model.DateHelper.TOMORROW;
//
//
//@Disabled
//@DisplayName("For an expense")
//public class PaymentRequestFormTests extends WebTestRunner {
//
//    private final WebSession session = new WebSession(PaymentRequestFormTests.this);
//
//    @Override
//    protected void setupTestData() {
//
//    }
//
//    @Test
//    @DisplayName("I can view the page to capture a payment request")
//    public void noPaymentRequests() throws IOException {
//        session.openLoginPage()
//                .login("student1@wethinkcode.co.za")
//                .shouldBeOnExpensesPage()
//                .clickOnExpense("Airtime")
//                .shouldBeOnPaymentRequestPage("Airtime")
//                .takeScreenshot("payment-request")
//                .clickOnExpensesLinkOnPaymentRequestPage()
//                .shouldBeOnExpensesPage();
//    }
//
//    @Test
//    @DisplayName("I can see prior payment requests")
//    public void hasPriorPaymentRequests() throws IOException {
//        session.openLoginPage()
//                .login("student1@wethinkcode.co.za")
//                .shouldBeOnExpensesPage()
//                .clickOnExpense("Lunch")
//                .shouldBeOnPaymentRequestPage("Lunch")
//                .takeScreenshot("payment-request")
//                .shouldHavePaymentRequest("Student2")
//                .clickOnExpensesLinkOnPaymentRequestPage()
//                .shouldBeOnExpensesPage();
//    }
//
//    @Test
//    @DisplayName("I can submit a payment request")
//    public void capturePaymentRequest() throws IOException {
//        session.openLoginPage()
//                .login("student1@wethinkcode.co.za")
//                .shouldBeOnExpensesPage()
//                .clickOnExpense("Lunch")
//                .shouldBeOnPaymentRequestPage("Lunch")
//                .takeScreenshot("payment-request-before-capture")
//                .shouldHavePaymentRequest("Student2")
//                .fillPaymentRequestForm("student3@wethinkcode.co.za", amountOf(100), TOMORROW)
//                .submitPaymentRequestForm()
//                .takeScreenshot("payment-request-form-filled")
//                .shouldBeOnPaymentRequestPage("Lunch")
//                .shouldHavePaymentRequest("Student2")
//                .shouldHavePaymentRequest("Student3")
//                .takeScreenshot("payment-request-after-capture");
//    }
//}
