import java.io.Serializable;

/**
 * The Player class contains all information connetec to the Player
 */
public class Player implements Serializable
{
    // Variables
    private String name;
    private int health, attack, armorClass;
    private double balance;
    private Weapon hand;
    private Armor armor;

    // Constructors
    /**
     * Player constructor
     * @param name
     */
    public Player(String name)
    {
        this.name = name;
        this.health = generateHealth();
        this.attack = generateSkills();
        this.armorClass = generateSkills();
        this.balance = generateMoney();
        this.hand = new Weapon();
        this.armor = new Armor();
    }

    // Getters
    public int getHealth()
    {
        return this.health;
    }
    public double getBalance()
    {
        return this.balance;
    }
    public String getName()
    {
        return this.name;
    }
    public int getAttack()
    {
        return this.attack;
    }
    public Weapon getHand()
    {
        return this.hand;
    }
    public int getArmorClass()
    {
        return this.armorClass;
    }
    public Armor getArmor() { return this.armor; }

    // Setters
    public void setHealth(int health)
    {
        this.health += health;
    }
    public void setBalance(double amount)
    {
        this.balance += amount;
    }
    public void setHand(Weapon weapon)
    {
        this.hand = weapon;
    }
    public void setArmor(Armor armor)
    {
        this.armor = armor;
    }

    // Return of strings with info about this class
    @Override
    public String toString()
    {
        return  this.name + ", " +
                "Balance: " + this.balance + ", " +
                "Attack: " + this.attack + ", " +
                "Items.Armor: " + this.armorClass;
    }
    public String weaponAttributes()
    {
        return this.name +
                ", Attack: " + this.attack + " (" + this.hand.getAttack() + ")" +
                ", Items.Armor: " + this.armorClass + " (" + this.armor.getArmorClass() + ") " +
                ", Total Attack: " + (this.hand.getAttack() + this.attack) +
                ", Total Defence: " + (this.armor.getArmorClass() + this.armorClass) +
                ", Balance: " + this.balance;
    }
    public String storeAttributes()
    {
        return this.name + ", balance: " + this.balance;
    }

    // Private Methods
    /**
     * A generator of money for the creation of a new player
     * @return double
     */
    private double generateMoney()
    {
        Dice dice = new Dice(20);
        return dice.rollDie(4);
    }
    /**
     * Generator of skills for thiss player
     * @return int
     */
    private int generateSkills()
    {
        Dice dice = new Dice(4);
        return dice.rollDie(6);
    }
    /**
     * Generator of health for this player
     * @return int
     */
    private int generateHealth()
    {
        Dice dice = new Dice(6);
        return dice.rollDie(4);
    }
}




















