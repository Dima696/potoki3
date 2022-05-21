import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress ( int health, int weapons, int lvl, double distance ) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString () {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame ( Object obj, String fileName ) throws IOException {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    public  void zipFiles ( String archiveFile, String fileName )  {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archiveFile));
             FileInputStream fis = new FileInputStream(fileName);) {
            try {
                ZipEntry entry1 = new ZipEntry(fileName);
                zout.putNextEntry(entry1);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            byte[] buffer = new byte[fis.available()];

            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}

