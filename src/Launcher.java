import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
public class Launcher {

    public static void main (String[] args){
         System.out.println("Bonjour");
        List<Command> ma_comm = new ArrayList<>();
        ma_comm.add(new Quit());
        ma_comm.add(new Fibo());
        ma_comm.add(new Freq());
        boolean q = false;
        
        while(!q){
            System.out.println("Passe moi une fonction");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            Command command = null;
            for (Command c : ma_comm) {
                if (c.name().equals(input)) {
                    command = c;
                    break;
                }
            }
            boolean found = false;

            for (Command c : ma_comm) {
                if (c.name().equals(input)) {
                    found = true;
                    q = c.run(sc);
                }
            }
            if(!found){
                System.out.println("Unknown command");
            }
        }
    }
        
}