/**
 * See the Arena class as a place where there will be done fights
 */
public class Arena
{
    /**
     * The entrance to the arena
     * @param player
     * @return returns the player
     */
    public Player entrance(Player player)
    {
        Player beast = new Player("Beast"); // The beast/opponent
        System.out.println(beast); // Print of the beast object

        System.out.println("Your now at the entrance of the fight\n" +
                "Get Ready to fight!");

        // Instantiate a fight and gets the hero object returnned
        // If heros health is over 0 then he is still alive and
        if (fight(player, beast).getHealth() > 0)
        {
            // Adds winnings from the beast to the hero balance
            player.setBalance(beast.getBalance());
        }

        // Return the player
        return player;
    }

    /**
     * The fight simulation
     * @param hero
     * @param attacker
     * @return the hero
     */
    private Player fight(Player hero, Player attacker)
    {
        Dice dice = new Dice(20);

        int plusToAttack = 0; // The modifier
        while (hero.getHealth() > 0 && attacker.getHealth() > 0)
        {
            // The roll and attack of the first player
            int attackDiff = (dice.rollDie(1) + hero.getAttack() +
                              hero.getHand().getAttack() + plusToAttack) -
                             (attacker.getArmorClass() + dice.rollDie(1));
            plusToAttack = 0; // sets the modifier to 0 so next attack dosn't get the modifier
            if (attackDiff == 0)
            {
                // Nothing happens
            }
            else if (attackDiff < 0)
            {
                plusToAttack = 1; // if the difference between the attack and defence is negative
            }
            else
            {
                attacker.setHealth(-(attackDiff / 2));
            }

            // Beast attack
            attackDiff = (dice.rollDie(1) + attacker.getAttack() + attacker.getHand().getAttack() + plusToAttack) -
                         (dice.rollDie(1) + hero.getArmorClass());
            plusToAttack = 0; // sets the modifier to 0 so next attack dosn't get the modifier
            if (attackDiff == 0)
            {

            }
            else if (attackDiff < 0)
            {
                plusToAttack = 1; // if the difference between the attack and defence is negative
            }
            else
            {
                hero.setHealth(-(attackDiff / 2));
            }

            lifeDisplay(hero);
            lifeDisplay(attacker);
        }
        return hero;
    }

    // Dislpays the life of a player object
    public void lifeDisplay(Player player) {
        System.out.println("Life of " + player.getName() + ": " + player.getHealth());
    }
}

