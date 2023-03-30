import java.util.Scanner;
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
            else {
                System.out.print("Unknown command\n");
            }
            System.out.println("Tapez une nouvelle commande");
            a = scanner.nextLine();
        }
        if (a.equals("quit"))
            return;

    }

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
}
