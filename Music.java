import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Music extends Disc {


    //Method that creates each music entry and writes it to a file where all entries are stored.
    public void createMusicEntry() {

        FileManagement FM = new FileManagement();

        //Asks the user all the details of the discs.
        System.out.println("Please enter the title of the disc: ");
        newTitle = userInput.nextLine();
        setTitle(newTitle);
        System.out.println("Please enter the artist of the disc: ");
        artist = userInput.nextLine();
        System.out.println("Please type the name of the genre from the list below: ");
        loopTable();
        genre = userInput.nextLine();
        lookUpMGenre();
        for (int i = 0; i < 1; ) {
            if (valid) {
                i++;
            } else {
                System.out.println("Invalid genre! Try again.");
                genre = userInput.nextLine();
                lookUpMGenre();
            }
        }
        System.out.println("Please enter the release date of the disc (dd/mm/yyyy): ");
        releaseDate = userInput.nextLine();
        System.out.println("Please enter the number of songs contained on the disc: ");
        numberSongs = userInput.nextLine();
        System.out.println("Please enter the duration of the disc (minutes.seconds): ");
        duration = userInput.nextLine();

        //Adds all the variables to an arraylist so that it can be easily written to a file.
        ArrayList<String> musicData = new ArrayList<String>();
        musicData.add(getTitle());
        musicData.add(artist);
        musicData.add(genre);
        musicData.add(releaseDate);
        musicData.add(numberSongs);
        musicData.add(duration);

        //Writes the arraylist to the file.
        try {
            FileWriter file = new FileWriter(FM.fileName, true);
            BufferedWriter output = new BufferedWriter(file);
            output.newLine();
            output.write(Arrays.toString(musicData.toArray()).replace("[", "").replace("]", ""));
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}


