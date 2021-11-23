public class Menu extends Main {

    boolean exit;

    //Method that combines all the menu components into one so it can all be executed at the same time.
    public void runMenu() {
        FM.findFileName();
        while (!exit) {
            menuHeader();
            mainMenu();
            int choice = -1;
            choice = getInput();
            menuAction(choice);
        }
    }

    //Method that prints the header of the menu out.
    private void menuHeader() {
        System.out.println("\nWelcome to the Disc Information");
        System.out.println("       Management System");
    }

    //Method that prints the main menu options out.
    private void mainMenu() {
        System.out.println("\nPlease choose an option from the list:");
        System.out.println("\n(1) Add new music");
        System.out.println("(2) Add new game");
        System.out.println("(3) Display media");
        System.out.println("(4) Search for media");
        System.out.println("(5) Rename file");
        System.out.println("(6) Delete media");
        System.out.println("(7) Display media in reverse order");
        System.out.println("(0) Exit Program");
    }

    //Takes the user's input and makes sure it is between 0 and 7. The user's choice is then returned where it will be used in the switch.
    private int getInput() {

        int choice = -1;
        while (choice < 0 || choice > 7) {
            try {
                System.out.println("\nEnter your option: ");
                choice = Integer.parseInt(userInput.next());
                if (choice > 7) {
                    System.out.println("You have entered an invalid option. Please try again.");
                } else if (choice < 0) {
                    System.out.println("You have entered an invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have not entered an integer value. Please try again.");
            }
        }
        return choice;
    }

    //Takes the choice from the above method and uses it to call the correct method from each class.
    private void menuAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("\nThank you for using this application. Goodbye.");
                break;
            case 1:
                M.createMusicEntry();
                break;
            case 2:
                G.createGameEntry();
                break;
            case 3:
                FM.readFile();
                break;
            case 4:
                FM.findDisc();
                break;
            case 5:
                FM.renameFile();
                break;
            case 6:
                FM.userDeleteChoice();
                FM.removeDisc(FM.lineToRemove);
                break;
            case 7:
                FM.readFileReverse();
                break;
            default:
        }
    }
}



