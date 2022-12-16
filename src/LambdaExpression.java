import java.util.ArrayList;
import java.util.Scanner;

public class LambdaExpression {
    /*
    functional interface is interface which has only one method like this one has one method named validate
    interface
     */
    @FunctionalInterface
    public interface UserValidator {
        public boolean validate(String toBeValidated);
    }


    /**
     * Validate the Email using lambda expression
     * The Lambda expression is used to provide the implementation of an interface
     * which has functional interface.It saves a lot of code.
     *
     * @param args
     */

    public static void main(String[] args) {
        /*
        Taking an Email arraylist to check every email provided
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("abc111@abc.com");
        arrayList.add("abc-100@abc.com");
        arrayList.add("abc.100@yahoo.com");
        arrayList.add("abc+100@gmail.com");
        arrayList.add("abc@1.com");
        arrayList.add("abc-100@yahoo.com");
        arrayList.add("abc_pqr@gmail.com");
        arrayList.add("abc.100@abc.com");
        arrayList.add("abc@gmail.com");
        arrayList.add("abc123@email.com");
    /*
    Defining pattern of email
    */
        String Email_Pattern = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*" + "@([a-zA-Z0-9][-]?)+[.][a-zA-Z]{2,4}([.]{2,4})?$";

    /*
    Using lambda expression to validate input here we are calling interface of UserValidator and making
    it A object named validateEmail. validateEmail is the object of interface class UserValidator.
    And we are calling method validate of UserValidator interface class and giving its parameter email.
    what parameter we give to method validate it comes in the argument (emailValid) of lambda expression
    And we can perform any function on it.
    */


        UserValidator validateEmail = (emailValid) -> emailValid.matches(Email_Pattern);
    /*
    for-each loop to iterate every email providing in the arraylist through a variable named emailList
    */

        for (String emailList : arrayList) {

            boolean isValid = validateEmail.validate(emailList);

            if (isValid) {
                System.out.println("Email pattern is valid");
            } else {
                System.out.println("Email pattern is not valid try again");

            }

        }
    }
}