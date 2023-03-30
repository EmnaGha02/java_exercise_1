import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }
    @Override
    public boolean run(Scanner sc) {
        int f1 = 0;
        int f2 = 1;
        int next = 0;
        System.out.println("Quelle est la valeur n que tu veux proposer?");
        int num =  Integer.parseInt(sc.nextLine());
        for (var i = 0; i <= num; i++ )
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
        return false;
    }

}