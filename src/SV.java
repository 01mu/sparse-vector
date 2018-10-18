/*
 * sparse-vector
 * hithub.com/01mu
 */

import java.util.Collections;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SV
{
    public static void main(String[] args) throws FileNotFoundException
    {
        SparseVector sparseVectorTop = new SparseVector(null);
        SparseVector sparseVectorBottom = new SparseVector(null);

        FileInputStream fstream = new FileInputStream("input");
        boolean topSet = false;

        Scanner input = new Scanner(fstream);

        while(input.hasNextLine()) {
            String line = input.nextLine();

            if(!line.equals("add") && !line.equals("subtract") &&
                !line.equals("dot")) {
                Vector<Element> elements = new Vector<Element>();
                Vector<String> lineVector = new Vector<String>();

                StringTokenizer defaultTokenizer = new StringTokenizer(line);

                while (defaultTokenizer.hasMoreTokens()) {
                    lineVector.addElement(defaultTokenizer.nextToken());
                }

                for(int i = 0, elementTracker = 0;
                    i < lineVector.size(); i = i + 2, elementTracker++) {
                    elements.add(new Element(0, 0));

                    int index = Integer.parseInt(lineVector.get(i));
                    elements.get(elementTracker).setIndex(index);

                    double value = Double.parseDouble(lineVector.get(i + 1));
                    elements.get(elementTracker).setValue(value);
                }

                Collections.sort(elements);

                DoublyLinkedList<Element> toAdd =
                    new DoublyLinkedList<Element>();

                for(int j = 0; j < elements.size(); j++) {
                    toAdd.add(elements.get(j));
                }

                if(topSet == true) {
                    sparseVectorBottom = new SparseVector(toAdd);

                    topSet = false;
                } else {
                    sparseVectorTop = new SparseVector(toAdd);

                    topSet = true;
                }
            } else if(line.equals("add")) {
                sparseVectorTop.add(sparseVectorBottom);
            } else if(line.equals("subtract")) {
                sparseVectorTop.subtract(sparseVectorBottom);
            } else if(line.equals("dot")) {
                sparseVectorTop.dot(sparseVectorBottom);
            }
        }

        input.close();
    }
}
