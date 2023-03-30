import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;
public class Freq implements Command {
    @Override
    public String name(){
        return "freq";
    }
    @Override
    public boolean run(Scanner sc)
    {
        try{
            Path paths = Paths.get(sc.nextLine());
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
            return false;
        }
        catch (Exception e)
        {
            System.err.println("Unreadable file: ");
            e.printStackTrace();
            return false;
        }
    }
    
}