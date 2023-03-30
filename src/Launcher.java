import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;
import java.util.Map;
import java.util.Comparator;
public class Launcher {

    public static void main (String[] args){
        System.out.println("Bonjour!");
        System.out.println("Passe moi une fonction");
        Scanner scanner = new Scanner( System.in );
        String a = scanner.nextLine();
        while (!a.equals("quit")) {
            if (a.equals("fibo"))
            {
                System.out.println("Quelle est la valeur n que tu veux proposer?");
                int num =  Integer.parseInt(scanner.nextLine());
                fibo_fun(num);
            }
            else if (a.equals("freq"))
            {
                System.out.println("Quel est le Path du texte?");
                String pt = scanner.nextLine();;
                freq_fun(pt);
            }
            else {
                System.out.print("Unknown command\n");
            }
            System.out.println("Tapez une nouvelle commande");
            a = scanner.nextLine();
        }
        if (a.equals("quit"))
            return;

    }
    //Partie 4
    public static void fibo_fun(int num)
    {
        int f1 = 0;
        int f2 = 1;
        int next = 0;
        for (int i = 0; i <= num; i++ )
        {
            if (i <= 1)
                next = i;
            else
            {
                next = f2 + f1;
                f1 = f2;
                f2 = next;
            }
        }
        System.out.println("F(" + num + ")=" + next);
    }

    //Partie 5
    public static void freq_fun(String pt)
    {
        try{
            Path paths = Paths.get(pt);
            String initialString = java.nio.file.Files.readString(paths);
            String secondString = initialString.replaceAll("\\p{Punct}"," ");
            String my_text = secondString.toLowerCase();
            Stream<String> words = Arrays.stream(my_text.split(" "));
            Stream<String> w_w = words.filter(word -> !word.isBlank());
            Map<String, Long> frequecy = w_w.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
            String fin_w = frequecy.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(" "));

            System.out.println("Les 3 mots les plus repetés: " + fin_w);


        }
        catch (Exception e)
        {
            System.err.println("Unreadable file: ");
            e.printStackTrace();
        }
    }
}
