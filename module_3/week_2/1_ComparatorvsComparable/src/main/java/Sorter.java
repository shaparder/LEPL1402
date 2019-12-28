import java.util.List;
import java.awt.Color;

import java.util.Comparator;
import java.util.List;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */
    public static void sortFlowerByColor(List<Flower> list){
        //TODO by student
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        Comparator<Plant> cmp = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                String s1 = o1.getName();
                String s2 = o2.getName();
                for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                    if (s1.charAt(i) > s2.charAt(i)) {return 1;}
                    else if ( s1.charAt(i) < s2.charAt(i)) {return -1;}
                }
                if (s1.length() == s2.length()) {return 0;}
                else {return (s1.length() > s2.length()) ? 1 : -1 ;}
            }
        };

        list.sort(cmp);
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
        //TODO by student
    }
}
