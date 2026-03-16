import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/
public class WildCardSimpleExample {
    // <?> = unbounded Wildcard
    // artinya method bisa menerima Collection dengan tipe data apapun
    public static void printCollection(Collection<?> c) {
        //
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // ArrayList
        Collection<String> collection = new ArrayList<>();
        collection.add("ArrayList Collection");
        // printCollection menerima Arraylist dengan aman
        printCollection(collection);

        Collection<String> collection2 = new LinkedList<>();
        collection2.add("LinkedList Collection");
        // printCollection menerima Linkedlist dengan aman
        printCollection(collection2);

        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection");
        // printCollection menerima HashMap dengan aman
        printCollection(collection3);
    }
}
