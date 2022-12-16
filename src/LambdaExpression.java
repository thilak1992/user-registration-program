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
        System.out.println("Enter Last name you want to check");
        String lastName = scanner.nextLine();
    /*
    Defining pattern of the input
     */
        String Last_Name_Pattern = "^[A-Z ][a-z]{3,}";

        /*
        Using lambda expression to validate inputs here we are calling interface of UserValidator and making
        it A object named validateLastName.
         */
        UserValidator validateLastName = (lastNameValid) -> lastNameValid.matches(Last_Name_Pattern);

        /*
    validateLastName is the object of interface class UserValidator. And we are calling method validate of
    UserValidator interface class and giving its parameter lastName. what parameter we give to method validate
    it comes in the argument (lastNameValid) of lambda expression And we can perform any function on it.
     */
        boolean isValid = validateLastName.validate(lastName);

        if (isValid) {
            System.out.println("Last name pattern is valid");
        } else {
            System.out.println("Last name pattern is not valid try again");

        }


    }
}