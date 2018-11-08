/*
 * sparse-vector
 * github.com/01mu
 */

public class Element implements Comparable<Element>
{
    private int index;
    private double value;

    public Element(int index, double value)
    {
        this.index = index;
        this.value = value;
    }

    public int getIndex()
    {
        return index;
    }

    public double getValue()
    {
        return value;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        String output = "[" + index + ", " + value + "]";

        return output;
    }

    @Override
    public int compareTo(Element other)
    {
        return this.index >
            other.index ? 1 : (this.index < other.index ? -1 : 0);
    }
}
