import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Tester {

    public static void main(String[] args) {

        Input input = new Input();
        Logic logic = new Logic();
        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<Integer> teamLimits = new ArrayList<Integer>();

        try {
            people = input.preferencesIn();
        } catch (IOException e) {
            System.out.println("Error reading in people");
            e.printStackTrace();
        }

        try {
            teamLimits = input.teamLimitsIn();
        } catch (IOException e) {
            System.out.println("Error reading in team limits");
            e.printStackTrace();
        }

        teams = logic.createTeams(teamLimits);
        try {
            logic.assignTeams(teams, people);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error printing output");
        }


    }

    public static void test(ArrayList<Person> people){
        for(Person person : people){
            System.out.println(person._name);
            System.out.println(person._choice1);
            System.out.println(person._choice2);
            System.out.println(person._choice3);
        }
    }

}