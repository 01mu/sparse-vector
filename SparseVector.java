import java.util.*;
import java.math.BigDecimal;

public class SparseVector
{
    private DoublyLinkedList<Element> values;

    SparseVector(DoublyLinkedList<Element> values)
    {
        this.values = values;
    }

    public SparseVector add(SparseVector sv)
    {
        Vector<Element> elements = new Vector<Element>();

        for(int i = 0; i < values.size(); i++) {
            boolean inBothVectors = false;

            for(int k = 0; k < sv.values.size(); k++) {
                if(values.get(i).getIndex() == sv.values.get(k).getIndex()) {
                    double f = values.get(i).getValue() +
                        sv.values.get(k).getValue();

                    if(new BigDecimal(f).compareTo(BigDecimal.ZERO) != 0) {
                        elements.addElement(
                            new Element(values.get(i).getIndex(),
                                Math.round(f * 100) / 100.0d));
                    }

                    inBothVectors = true;
                }
            }

            if(inBothVectors == false) {
                elements.addElement(new Element(values.get(i).getIndex(),
                    values.get(i).getValue()));
            }
        }

        for(int i = 0; i < sv.values.size(); i++) {
            boolean inBothVectors = false;

            for(int k = 0; k < values.size(); k++) {
                if(values.get(k).getIndex() == sv.values.get(i).getIndex()) {
                    inBothVectors = true;
                }
            }

            if(inBothVectors == false) {
                elements.addElement(
                    new Element(sv.values.get(i).getIndex(),
                        sv.values.get(i).getValue()));
            }
        }

        Collections.sort(elements);

        DoublyLinkedList<Element> list = new DoublyLinkedList<Element>();

        for(int i = 0; i < elements.size(); i++) {
            list.add(elements.get(i));
        }

        SparseVector sum = new SparseVector(list);

        System.out.println(this.toString());
        System.out.println("+");
        System.out.println(sv.toString());
        System.out.println("=");

        System.out.println(sum.toString() + "\n");

        return sum;
    }

    public SparseVector subtract(SparseVector sv)
    {
        Vector<Element> elements = new Vector<Element>();

        for(int i = 0; i < values.size(); i++) {
            boolean inBothVectors = false;

            for(int k = 0; k < sv.values.size(); k++) {
                if(values.get(i).getIndex() == sv.values.get(k).getIndex()) {
                    double f = values.get(i).getValue() -
                        sv.values.get(k).getValue();

                    if(new BigDecimal(f).compareTo(BigDecimal.ZERO) != 0) {
                        elements.addElement(
                            new Element(values.get(i).getIndex(),
                                Math.round(f * 100) / 100.0d));
                    }

                    inBothVectors = true;
                }
            }

            if(inBothVectors == false) {
                elements.addElement(new Element((values.get(i)).getIndex(),
                    (values.get(i)).getValue()));
            }
        }

        for(int i = 0; i < sv.values.size(); i++) {
            boolean inBothVectors = false;

            for(int k = 0; k < values.size(); k++) {
                if(values.get(k).getIndex() == sv.values.get(i).getIndex()) {
                    inBothVectors = true;
                }
            }

            if(inBothVectors == false) {
                elements.addElement(new Element(sv.values.get(i).getIndex(),
                    -1 * sv.values.get(i).getValue()));
            }
        }

        Collections.sort(elements);

        DoublyLinkedList<Element> list = new DoublyLinkedList<Element>();

        for(int i = 0; i < elements.size(); i++) {
            list.add(elements.get(i));
        }

        SparseVector difference = new SparseVector(list);

        System.out.println(this.toString());
        System.out.println("-");
        System.out.println(sv.toString());
        System.out.println("=");

        System.out.println(difference.toString() + "\n");

        return difference;
    }

    public double dot(SparseVector sv)
    {
        double result = 0;

        for(int i = 0; i < values.size(); i++) {
            for(int k = 0; k < sv.values.size(); k++) {
                if(values.get(i).getIndex() == sv.values.get(k).getIndex()) {
                    double f = values.get(i).getValue() *
                        sv.values.get(k).getValue();

                    result = result + f;
                }
            }
        }

        if(result < 0) {
            result = -1 * Math.round(result * 100) / 100.0d;
        } else {
            result = Math.round(result * 100) / 100.0d;
        }

        char dotCharacter = (char) 183;

        System.out.println(this.toString());
        System.out.println(dotCharacter);
        System.out.println(sv.toString());
        System.out.println("=");
        System.out.println(result + "\n");

        return result;
    }

    @Override
    public String toString()
    {
        String output = "( ";

        for(int i = 0; i < values.size(); i++) {
            output = output + values.get(i) + " ";
        }

        output = output + ")";

        return output;
    }
}
