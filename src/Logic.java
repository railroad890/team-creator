import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Logic {

    public Logic(){

    }

    public ArrayList<Team> createTeams(ArrayList<Integer> limits){

        ArrayList<Team> teams = new ArrayList<Team>();

        for (int limit:limits) {
            teams.add(new Team(limit));
        }

        return teams;
    }

    public void assignTeams(ArrayList<Team> teams, ArrayList<Person> people) throws IOException{

        File out = new File("output.txt");
        PrintStream printOut = new PrintStream(out);

        for(Person person : people){
            int pref = person._choice1;
            if(teams.get(pref-1)._count < teams.get(pref-1)._limit){
                person._assignment = pref;
                teams.get(pref-1)._count++;
            }else{
                pref = person._choice2;
                if(teams.get(pref-1)._count < teams.get(pref-1)._limit){
                    person._assignment = pref;
                    teams.get(pref-1)._count++;
                }else{
                    pref = person._choice3;
                    if(teams.get(pref-1)._count < teams.get(pref-1)._limit){
                        person._assignment = pref;
                        teams.get(pref-1)._count++;
                    }else{
                        System.out.println("Error: all listed teams full");
                        person._assignment = 0;
                    }
                }
            }



            printOut.println(person._name + ": " + person._assignment);
        }
        printOut.close();
    }
}
