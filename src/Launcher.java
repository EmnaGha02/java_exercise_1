import java.util.Scanner;
public class Launcher {
    public static void main (String[] args){
        System.out.println("Bonjour!");
        Scanner scanner = new Scanner( System.in );
        String a = scanner.nextLine();
        while (!a.equals("quit")) {
            System.out.print("Unknown command\n");
            a = scanner.nextLine();
        }
        return;
        /*if (a.equals("quit"))
            return;
        else
            System.out.print( "Unknown command" );*/
    }
}
