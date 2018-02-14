import java.util.Scanner;

/**
 * This is the main starting class
 */
public class GameRun
{
    public static void main(String[] args)
    {
        // Variables
        Arena arena = new Arena();
        Player player = new Player("Hero"); // Used to generate a startup hero
        Scanner scanner = new Scanner(System.in); // Scanner for console inputs
        // Fil handler for saving and getting data from files
        FileHandler fh = new FileHandler();
        READFILE rf = new READFILE();
        // For safety on first runs. This double effect on reading files is re-saving the file
        //  as objects and then the file handler can work with the file again
        rf.readWeaponsFile();

        // Welcome message
        System.out.println("Welcome to this D&D Pathfinder RPG");
        System.out.println("Press any key to continue!");
        scanner.nextLine();

        // Menu runing on boolean true for a future break; to break the loop
        boolean isRunning = true;
        while (isRunning)
        {
            // Printing the player stats
            System.out.println(player.weaponAttributes());
            // The Main Menu
            System.out.println("Menu\n" +
                    "1. Get ready to fight!\n" +
                    "2. Go to Store!\n" +
                    "3. Save player\n" +
                    "4. Load Player\n" +
                    "5. Create new Player\n" +
                    "Press any key to exit!(Where's the anykey)");

            String choice = scanner.next(); // next input as a string
            // Menu choice functionality
            switch (choice)
            {
                case "1": // Arena/Fight Entrance
                    arena.entrance(player);
                    break;
                case "2": // Store Entrance
                    Store store = new Store();
                    store.entrance(player);
                    break;
                case "3": // Save player to file
                    fh.savePlayer(player);
                    break;
                case "4": // Load player from file
                    player = fh.loadPlayer();
                    break;
                case "5": // Create new hero
                    player = new Player("Hero");
                    break;
                // Any other String than the menu choises then the system exits the loop and the program will close down
                default:
                    isRunning = false;
                    break;
            }
        }
    }
}











