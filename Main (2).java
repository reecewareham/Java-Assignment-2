import java.util.Scanner;
public class Main {



    Scanner userInput = new Scanner(System.in);
    boolean exit;


    static Menu menu = new Menu();
    Music M = new Music();
    Game G = new Game();
    FileManagement FM = new FileManagement();




    public static void main(String[] args) {

        menu.runMenu();
    }
}
