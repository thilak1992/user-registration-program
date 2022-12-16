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
     * Validating the Password using lambda expression
     * The Lambda expression is used to provide the implementation of an interface
     * which has functional interface.It saves a lot of code.
     *
     * @param args
     */

    public static void main(String[] args) {
        /*
        Taking input from the user
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password you want to check");
        String password = scanner.next();
    /*
    Defining pattern of password
    */
        String Password_Pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}";

        /*
        Using lambda expression to validate input here we are calling interface of UserValidator and making
        it A object named validatePassword.
         */
        UserValidator validatePassword = (passwordValid) -> passwordValid.matches(Password_Pattern);
        /*
    validatePassword is the object of interface class UserValidator. And we are calling method validate of
    UserValidator interface class and giving its parameter mobileNumber. what parameter we give to method validate
    it comes in the argument (passwordValid) of lambda expression And we can perform any function on it.
     */
        boolean isValid = validatePassword.validate(password);

        if (isValid) {
            System.out.println("Password pattern is valid");
        } else {
            System.out.println("Password pattern is not valid try again");

        }


    }
}