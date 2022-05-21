import java.io.*;
import java.util.zip.ZipEntry;

public class Main {

    public static void main ( String[] args ) throws IOException, FileNotFoundException {
        GameProgress gameProgress1 = new GameProgress(5, 10, 20, 1.0);
        GameProgress gameProgress2 = new GameProgress(10, 20, 30, 2.0);
        GameProgress gameProgress3 = new GameProgress(20, 30, 40, 3.0);


        new File("Games").mkdir();
        new File("Games", "savegames").mkdir();

        gameProgress1.saveGame(gameProgress1, "C:\\Games\\savegames\\save1.dat");
        gameProgress2.saveGame(gameProgress2, "C:\\Games\\savegames\\save2.dat");
        gameProgress3.saveGame(gameProgress3, "C:\\Games\\savegames\\save3.dat");


        gameProgress1.zipFiles("C:\\Games\\savegames\\zip.zip", "C:\\Games\\savegames\\save1.dat");
        gameProgress1.zipFiles("C:\\Games\\savegames\\zip.zip", "C:\\Games\\savegames\\save2.dat");
        gameProgress1.zipFiles("C:\\Games\\savegames\\zip.zip", "C:\\Games\\savegames\\save3.dat");

        try {
            File file1 = new File("C:\\Games\\savegames\\save1.dat");
            File file2 = new File("C:\\Games\\savegames\\save2.dat");
            File file3 = new File("C:\\Games\\savegames\\save3.dat");
            if (file1.exists() && file2.exists() && file3.exists()) {
                file1.delete();
                file2.delete();
                file3.delete();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

}
