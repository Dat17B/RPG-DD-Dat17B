import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple read file Scanner class
 */
public class READFILE
{
    /**
     * Read weapons from the weapons file
     */
    public void readWeaponsFile()
    {
        File file = new File("Weapons.csv"); // Instance of the file
        ArrayList<Weapon> weapons = new ArrayList<>(); // Empty instance of weapons

        // Here we will try to read the file with the scanner
        try {
            Scanner scanner = new Scanner(file); // Instance of scanner pointing to the file

            // Read the file if it exists
            while (scanner.hasNextLine())
            {
                String nextLine = scanner.nextLine(); // Scan new line

                // String split on ";"
                String[] weapon = nextLine.split(";");
                // Adds new weapon to the weapons list
                weapons.add(new Weapon(weapon[0],
                        Integer.parseInt(weapon[2]),
                        Double.parseDouble(weapon[1]),
                        Double.parseDouble(weapon[3]))
                );
            }

            // Close scanner
            scanner.close();
        }
        catch (FileNotFoundException eFNF)
        {
            eFNF.printStackTrace();
        }

        // Saves the newly read file as a stream to a new file
        FileHandler fh = new FileHandler();
        fh.writeWeaponList(weapons);
    }
    /**
     * Gets a list armors from a file
     * INFO: Read the readWeaponsFile for information
     * @return ArrayList of armors
     */
    public ArrayList<Armor> readArmorsFile()
    {
        File file = new File("armorList.csv");
        ArrayList<Armor> armors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
            {
                String nextLine = scanner.nextLine();

                String[] armor = nextLine.split(";");
                armors.add(new Armor(armor[0],
                        Integer.parseInt(armor[2]),
                        Double.parseDouble(armor[1]),
                        Double.parseDouble(armor[5]))
                );
            }

            scanner.close();
        }
        catch (FileNotFoundException eFNF)
        {
            eFNF.printStackTrace();
        }

        return armors;
    }
}
