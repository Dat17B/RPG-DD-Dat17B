import java.io.*;
import java.util.ArrayList;

/**
 * File handler class to read and write to and from files of weapons and armors
 * Here you can also find the save and load Player functionality
 */
public class FileHandler
{
    // Variables
    private File file;
    // -Output Streams
    private FileOutputStream fileOutputStream;
    private BufferedOutputStream bufferedOutputStream;
    private ObjectOutputStream objectOutputStream;
    // -Input Streams
    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private ObjectInputStream objectInputStream;

    // Weapon
    /**
     * Writing a stream to a file
     * @param weapons
     */
    public void writeWeaponList(ArrayList<Weapon> weapons)
    {
        try
        {
            // Instantiate all the output streams for writing to a file
            this.file = new File("Weapons.txt"); // File
            this.fileOutputStream = new FileOutputStream(this.file);
            this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);
            this.objectOutputStream = new ObjectOutputStream(this.bufferedOutputStream);

            // Stream an object to a file
            this.objectOutputStream.writeObject(weapons);

            // closing the stream
            this.objectOutputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Reading the file of weapons
     * @return List of weapons
     */
    public ArrayList<Weapon> readWeaponList()
    {
        ArrayList<Weapon> valueReturn = new ArrayList<Weapon>();

        try
        {
            this.file = new File("Weapons.txt");
            this.fileInputStream = new FileInputStream(this.file);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
            this.objectInputStream = new ObjectInputStream(this.bufferedInputStream);

            valueReturn = (ArrayList<Weapon>)this.objectInputStream.readObject();

            this.objectInputStream.close();
        }
        catch (FileNotFoundException eFNF)
        {
            System.out.println(eFNF);
            eFNF.printStackTrace();
        }
        catch (IOException eIO)
        {
            System.out.println(eIO);
            eIO.printStackTrace();
        }
        catch (ClassNotFoundException eCNF)
        {
            System.out.println(eCNF);
            eCNF.printStackTrace();
        }

        return valueReturn;
    }

    // Player
    public void savePlayer(Player player)
    {
        try
        {
            this.file = new File("Player.txt");
            this.fileOutputStream = new FileOutputStream(this.file);
            this.bufferedOutputStream = new BufferedOutputStream(this.fileOutputStream);
            this.objectOutputStream = new ObjectOutputStream(this.bufferedOutputStream);

            this.objectOutputStream.writeObject(player);

            this.objectOutputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Player loadPlayer()
    {
        Player player = new Player("");

        try
        {
            this.file = new File("Player.txt");
            this.fileInputStream = new FileInputStream(this.file);
            this.bufferedInputStream = new BufferedInputStream(this.fileInputStream);
            this.objectInputStream = new ObjectInputStream(this.bufferedInputStream);

            player = (Player)this.objectInputStream.readObject();

            this.objectInputStream.close();
        }
        catch (FileNotFoundException eFNF)
        {
            System.out.println(eFNF);
            eFNF.printStackTrace();
        }
        catch (IOException eIO)
        {
            System.out.println(eIO);
            eIO.printStackTrace();
        }
        catch (ClassNotFoundException eCNF)
        {
            System.out.println(eCNF);
            eCNF.printStackTrace();
        }

        return player;
    }
}
