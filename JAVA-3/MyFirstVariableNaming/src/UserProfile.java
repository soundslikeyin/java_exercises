import java.util.Scanner;
import java.time.LocalDate;

public class UserProfile {
    String userName;
    int age;
    String gender;
    String jobPreference;
    String nationality = "Singapore";
    String bloodType;
    int birthYear;

//    public UserProfile(){
//    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserProfile user = new UserProfile();

        System.out.println("Please enter your name: ");
        user.userName = input.next();

        System.out.println("Please enter your age: ");
        user.age = input.nextInt();
        LocalDate today = LocalDate.now();
        user.birthYear = today.getYear() - user.age;

        System.out.println("Hello " + user.userName);
        System.out.println("Today is  " + today);
        System.out.println("Year now is  " + today.getYear());
        System.out.println("You were born in " + user.birthYear +"\n");

        System.out.println("Please indicate your gender (m/f): ");
        user.gender = input.next();

        System.out.println("Please indicate your job preference: ");
        user.jobPreference = input.next();

        System.out.println("Please indicate your blood type: ");
        user.bloodType = input.next();
    }


}
