import java.io.Serializable;

/**
 * Weapon class
 */
public class Weapon implements Serializable
{
    // Variables
    private String name;
    private int ac;
    private double price;
    private double weight;
    // Constructors
    /**
     * Empty hand constructor
     */
    public Weapon()
    {
        this.name = "hand";
        this.ac = 0;
        this.price = 0.0;
        this.weight = 0.0;
    }
    /**
     * Full constructor
     * @param name
     * @param ac
     * @param price
     * @param weight
     */
    public Weapon(String name, int ac, double price, double weight)
    {
        this.name = name;
        this.ac = ac;
        this.price = price;
        this.weight = weight;
    }

    // Getters
    public double getPrice()
    {
        return this.price;
    }
    public String getName()
    {
        return name;
    }
    public int getAttack()
    {
        return this.ac;
    }

    // String to print
    public String toStore()
    {
        return this.name + ", ac: " + this.ac + ", price: " + this.price;
    }
    @Override
    public String toString()
    {
        return "name='" + name + '\'' +
                ", ac=" + ac +
                ", price=" + price +
                ", weight=" + weight +
                "}";
    }
}