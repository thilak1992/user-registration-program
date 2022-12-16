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
     * Validating the name using lambda expression
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
        System.out.println("Enter first name you want to check");
        String firstName = scanner.nextLine();
    /*
    Defining pattern of the input
     */
        String first_Name_Pattern = "^[A-Z ][a-z]{3,}";

        /*
        Using lambda expression to validate inputs here we are calling interface of UserValidator and making
        it A object named validateFirstName.
         */
        UserValidator validateFirstName = (firstNameValid) -> firstNameValid.matches(first_Name_Pattern);

        /*
    validateFirstName is the object of interface class UserValidator. And we are calling method validate of
    UserValidator interface class and giving its parameter firstName. what parameter we give to method validate
    it comes in the argument (firstNameValid) of lambda expression And we can perform any function on it.
     */
        boolean isValid = validateFirstName.validate(firstName);

        if (isValid) {
            System.out.println("First name pattern is valid");
        } else {
            System.out.println("First name pattern is not valid try again");

        }


    }
}