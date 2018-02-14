/**
 * The smallest class with a very big functionality
 * Used for
 *  Player (skills, money)
 *  Arena (attack, defence)
 */
public class Dice
{
    // Size of the die
    private int range;

    public Dice(int range)
    {
        this.range = range;
    }

    /**
     * Roling the die
     * @param times
     * @return int
     */
    public int rollDie(int times)
    {
        int value = 0;
        for (int i = 0; i < times; i++)
        {
            value += (int)(Math.random() * this.range) + 1;
        }

        return value;
    }
}
