import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Store
{
    // Variables
    private ArrayList<Weapon> weaponList;
    private ArrayList<Armor> armorList;

    // Constructor
    /**
     * Common constructor
     */
    public Store()
    {
        this.weaponList = readWeaponData();
        this.armorList = readArmorData();
    }

    /**
     * The hole store menu
     * @param player
     */
    public void entrance(Player player)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Store!\n" +
                           "My name is ShopKeeper! What can i help yogi the bear with?");

        boolean isRunning = true;
        while (isRunning)
        {
            System.out.println("Shop-Menu\n" +
                    "1. See Inventory\n" +
                    "2. Buy Items.Weapon\n" +
                    "3. Buy Items.Armor\n" +
                    "4. See player stats\n" +
                    "Any other key to exit!");

            System.out.println("player: " + player.storeAttributes());

            String choice = scanner.next();
            switch (choice)
            {
                case "1":
                    displayInventory();
                    break;
                case "2":
                    displayWeaponInventory();

                    System.out.println("Buy weapon by ID:");
                    try
                    {
                        player.setBalance(
                                sellWeapon(
                                        player.getHand()
                                )
                        );
                        player.setHand(
                                buyWeapon(
                                        scanner.nextInt()
                                )
                        );

                        player.setBalance(
                                -player.getHand().getPrice()
                        );
                    }
                    catch (InputMismatchException eIM)
                    {
                        System.out.println("Not a Number!");
                    }
                    break;
                case "3":
                    displayArmorInventory();
                    try {
                        System.out.println("Buy an armor by id?");
                        player.setBalance(
                                sellArmor(
                                        player.getArmor()
                                )
                        );
                        player.setArmor(this.armorList.get(scanner.nextInt()));
                        player.setBalance(-player.getArmor().getPrice());
                    }
                    catch (InputMismatchException eIM)
                    {

                    }
                    catch (IndexOutOfBoundsException eIOOB)
                    {

                    }
                    break;
                case "4":
                    System.out.println(player.weaponAttributes());
                    break;
                default:
                    isRunning = false;
                    break;
            }
        }
    }

    // Private methods
    /**
     * Gets the armor list
     * @return ArrayList of armors
     */
    private ArrayList<Armor> readArmorData()
    {
        READFILE rf = new READFILE();
        return rf.readArmorsFile();
    }
    /**
     * Gets weapon list
     * @return ArrayList of weapons
     */
    private ArrayList<Weapon> readWeaponData()
    {
        FileHandler fh = new FileHandler();
        return fh.readWeaponList();
    }
    // - Store functionality
    private double sellArmor(Armor armor)
    {
        return armor.getPrice();
    }
    private double sellWeapon(Weapon weapon)
    {
        return weapon.getPrice();
    }
    private Weapon buyWeapon(int id)
    {
        return this.weaponList.get(id);
    }
    // -displays for the menu
    private void displayWeaponInventory()
    {
        System.out.println("ID");
        for (int i = 0; i < this.weaponList.size(); i++)
        {
            System.out.println(i + ": " + this.weaponList.get(i));
        }
    }
    private void displayArmorInventory()
    {
        System.out.println("ID");
        for (int i = 0; i < this.armorList.size(); i++)
        {
            System.out.println(i + ": " + this.armorList.get(i));
        }
    }
    private void displayInventory()
    {
        displayWeaponInventory();
        displayArmorInventory();
    }
}






















