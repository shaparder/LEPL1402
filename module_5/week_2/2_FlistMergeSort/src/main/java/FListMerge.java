
public class FListMerge {
    /*
     * This method receives an FList and returns the FList containing the same values but sorted with the smallest value to the highest one.
     *
     */
    public static FList<Integer> mergeSort(FList<Integer> fList){
        if (fList.length() == 1) return fList;
        FList<Integer> a = FList.nil(), b = FList.nil();
        int mid = fList.length() / 2, n = 0;
        for (Integer i: fList) {
            if (n < mid) a =  a.cons(i);
            else b = b.cons(i);
            n++;
        }

        a = mergeSort(a); b = mergeSort(b);
        a = merge(a, b); b = fList.nil();

        return reverse(a);
    }

    public static FList<Integer> merge(FList<Integer> a, FList<Integer> b) {
        FList<Integer> merged = FList.nil();

        while (a.isNotEmpty() || b.isNotEmpty()) {
            if (a.isEmpty()) {
                merged = merged.cons(b.head());
                b = b.tail();
            }
            else if (b.isEmpty()) {
                merged = merged.cons(a.head());
                a = a.tail();
            }
            else if (a.head() <= b.head()) {
                merged = merged.cons(a.head());
                a = a.tail();
            }
            else if (a.head() > b.head()) {
                merged = merged.cons(b.head());
                b = b.tail();
            }
        }

        return merged;
    }


    public static FList<Integer> reverse(FList<Integer> fList) {
        FList<Integer> reversed = FList.nil();
        for (Integer i: fList) reversed = reversed.cons(i);
        return reversed;
    }
}
