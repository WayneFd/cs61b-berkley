import edu.princeton.cs.algs4.Queue;

public class TestSort {
    public static void main(String[] args) {
        Queue<String> test = new Queue<>();
        test.enqueue("Alice");
        test.enqueue("Bob");
        test.enqueue("Zag");
        test.enqueue("Aka");
        test.enqueue("M416");
        test.enqueue("QBU");
        test.enqueue("SKS");
        test.enqueue("Chris");
        System.out.println(test.toString());
        Queue<String> ans = QuickSort.quickSort(test);
        System.out.print("Origin: ");
        System.out.println(test.toString());
        System.out.print("Sorted: ");
        System.out.println(ans.toString());

    }
}
