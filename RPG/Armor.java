import java.io.Serializable;

/**
 * The armor class
 */
public class Armor implements Serializable
{
    // Variables
    private String name;
    private int ac;
    private double price;
    private double weight;

    // Constructors
    /**
     * Creating a new Armor object for an Empty hand
     */
    public Armor()
    {
        this.name = "armor";
        this.ac = 0;
        this.price = 0.0;
        this.weight = 0.0;
    }
    /**
     * Armor constructor
     * @param name
     * @param ac
     * @param price
     * @param weight
     */
    public Armor(String name, int ac, double price, double weight)
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
    public int getArmorClass()
    {
        return this.ac;
    }

    // String to print
    @Override
    public String toString()
    {
        return "Items.Armor{" +
                "name='" + name + '\'' +
                ", ac=" + ac +
                ", price=" + price +
                ", weight=" + weight +
                "}";
    }
}
