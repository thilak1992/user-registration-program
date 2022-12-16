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


    /*
     * Validating the Information using lambda expression
     * The Lambda expression is used to provide the implementation of an interface
     * which has functional interface.It saves a lot of code.
     * @param args
     */

    public static void main(String[] args) throws InvalidUserException {
         /*
        Taking inputs from the user
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name you want to check");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last name you want to check");
        String lastName = scanner.nextLine();
        System.out.println("Enter email you want to check");
        String email = scanner.nextLine();
        System.out.println("Enter mobile number you want to check");
        String mobile = scanner.nextLine();
        System.out.println("Enter password you want to check");
        String password = scanner.nextLine();

    /*
    Defining pattern of the various inputs
     */
        String first_Name_Pattern = "^[A-Z ][a-z]{3,}";
        String last_Name_Pattern = "^[A-Z ][a-z]{3,}";
        String mobile_Number_Pattern = "^[0-9]{2}\\s{1}[0-9]{10}$";
        String password_Pattern = "(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}";
        String email_Pattern = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*" + "@([a-zA-Z0-9][-]?)+[.][a-zA-Z]{2,4}([.]{2,4})?$";

    /*
    Using lambda expression to validate inputs here we are calling interface of UserValidator and making
    it A object named validateFirstName,validateLastName,validateEmail,validateMobileNumber.
    */
        UserValidator validateFirstName = (firstNameValid) -> firstNameValid.matches(first_Name_Pattern);
        UserValidator validateLastName = (lastNameValid) -> lastNameValid.matches(last_Name_Pattern);
        UserValidator validateMobileNumber = (mobileNumberValid) -> mobileNumberValid.matches(mobile_Number_Pattern);
        UserValidator validatePassword = (passwordValid) -> passwordValid.matches(password_Pattern);
        UserValidator validateEmail = (emailValid) -> emailValid.matches(email_Pattern);
    /*
    validateFirstName is the object of interface class UserValidator. And we are calling method validate of
    UserValidator interface class and giving its parameter firstName. what parameter we give to method validate
    it comes in the argument (firstNameValid) of lambda expression And we can perform any function on it.
    */
        boolean isValid1 = validateFirstName.validate(firstName);
    /*
    if it is valid it is printing pattern is valid else it throws custom exception which we have create in the
    InvalidUserException class
    */
        if (isValid1) {
            System.out.println("First name pattern is valid");
        } else {
            throw new InvalidUserException(InvalidUserException.exceptionType.Invalid_First_Name, "Please enter proper first name");

        }
        boolean isValid2 = validateLastName.validate(lastName);

        if (isValid2) {
            System.out.println("Last name pattern is valid");
        } else {
            throw new InvalidUserException(InvalidUserException.exceptionType.Invalid_last_Name, "Please enter proper last name");

        }
        boolean isValid3 = validateMobileNumber.validate(mobile);

        if (isValid3) {
            System.out.println("Mobile Number pattern is valid");
        } else {
            throw new InvalidUserException(InvalidUserException.exceptionType.Invalid_Mobile_Number, "Please enter proper email address");

        }
        boolean isValid4 = validatePassword.validate(password);

        if (isValid4) {
            System.out.println("Password pattern is valid");
        } else {
            throw new InvalidUserException(InvalidUserException.exceptionType.Invalid_Password, "Please Enter proper password");

        }
        boolean isValid5 = validateEmail.validate(email);

        if (isValid5) {
            System.out.println("Email pattern is valid");
        } else {
            throw new InvalidUserException(InvalidUserException.exceptionType.Invalid_Email, "Please enter proper email address");

        }


    }
}