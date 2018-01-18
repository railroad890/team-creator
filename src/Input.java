import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Input {

    public Input() {

    }

    public ArrayList<Person> preferencesIn() throws IOException{

        int pref1, pref2, pref3;
        String name;

        File file = new File("preferences.txt");
        Scanner inFile = new Scanner(file);
        ArrayList<Person> people = new ArrayList<Person>();

        while(inFile.hasNextLine()) {
            name = inFile.nextLine();
            pref1 = inFile.nextInt();
            pref2 = inFile.nextInt();
            pref3 = inFile.nextInt();
            people.add(new Person(name, pref1, pref2, pref3));
        }
        inFile.close();
        return people;

    }

    public ArrayList<Integer> teamLimitsIn() throws IOException{

        int limit;

        File file = new File("limits.txt");
        Scanner inFile = new Scanner(file);
        ArrayList<Integer> limits = new ArrayList<Integer>();

        while (inFile.hasNextLine()){
            limit = inFile.nextInt();
            limits.add(limit);
        }
        inFile.close();
        return limits;
    }


}