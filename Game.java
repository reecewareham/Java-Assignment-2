import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Game extends Disc {

    FileManagement FM = new FileManagement();

    //Method that creates each game entry and writes it to a file where all entries are stored.
    public void createGameEntry() {

        //Asks the user for all the details of the discs.
        System.out.println("Please enter the title of the game: ");
        newTitle = userInput.nextLine();
        setTitle(newTitle);
        System.out.println("Please type the genre of the game from the list below: ");
        loopTableGenre();
        genre = userInput.nextLine();
        lookUpGenre();
        for (int i = 0; i < 1; ) {
            if (valid) {
                i++;
            } else {
                System.out.println("Invalid genre! Try again.");
                genre = userInput.nextLine();
                lookUpGenre();
            }
        }
        System.out.println("Please enter the release date of the game (dd/mm/yyyy): ");
        releaseDate = userInput.nextLine();
        System.out.println("Please type the PEGI rating of the game from the list below: ");
        loopTablePEGI();
        PEGIRating = userInput.nextLine();
        lookUpPEGI();
        for (int i = 0; i < 1; ) {
            if (valid) {
                i++;
            } else {
                System.out.println("Invalid PEGI rating! Try again.");
                genre = userInput.nextLine();
                lookUpPEGI();
            }
        }
        System.out.println("Please enter the platform of the game: ");
        platform = userInput.nextLine();

        //Adds all the variables to an arraylist so that it can be easily written to a file.
        ArrayList<String> gameData = new ArrayList<String>();
        gameData.add(getTitle());
        gameData.add(genre);
        gameData.add(releaseDate);
        gameData.add(PEGIRating);
        gameData.add(platform);


        //Writes the arraylist to the file.
        try {
            FileWriter file = new FileWriter(FM.fileName, true);
            BufferedWriter output = new BufferedWriter(file);
            output.newLine();
            output.write(Arrays.toString(gameData.toArray()).replace("[", "").replace("]", ""));
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}





