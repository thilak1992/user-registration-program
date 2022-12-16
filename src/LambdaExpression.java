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
     * Validating the Mobile Number using lambda expression
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
        System.out.println("Enter mobile number you want to check");
        String mobileNumber = scanner.nextLine();
    /*
    Defining pattern of the input
     */
        String Mobile_Number_Pattern = "^[0-9]{2}\\s{1}[0-9]{10}$";


        /*
        Using lambda expression to validate inputs here we are calling interface of UserValidator and making
        it A object named validateMobileNumber.
         */
        UserValidator validateMobileNumber = (mobileNumberValid) -> mobileNumberValid.matches(Mobile_Number_Pattern);
        /*
    validateMobileNumber is the object of interface class UserValidator. And we are calling method validate of
    UserValidator interface class and giving its parameter mobileNumber. what parameter we give to method validate
    it comes in the argument (mobileNumberValid) of lambda expression And we can perform any function on it.
     */
        boolean isValid = validateMobileNumber.validate(mobileNumber);

        if (isValid) {
            System.out.println("Mobile Number pattern is valid");
        } else {
            System.out.println("Mobile Number pattern is not valid try again");

        }


    }
}