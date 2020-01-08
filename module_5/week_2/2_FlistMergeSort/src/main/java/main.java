public class main {

    public static void main(String[] args) {
        FList<Integer> test = FList.nil();
        test = test.cons(34);
        test = test.cons(3);
        test = test.cons(31);
        test = test.cons(1);
        test = test.cons(12);
        test = test.cons(23);

        System.out.println(test);

        FList<Integer> sorted = FListMerge.mergeSort(test);

        System.out.println(sorted);
    }

}
