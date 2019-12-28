public class Plant implements Comparable<Plant>{

    private String name;
    private int age;

    public Plant(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /*
     * Should compare Plant by using name and age in that specific order
     * returns:
     *      > 0 if this is greater then o
     *      0 if they are equal
     *      < 0 if this is less than o
     */
    @Override
    public int compareTo(Plant o) {
        String s1 = this.getName();
        String s2 = o.getName();
        Integer i1 = this.getAge();
        Integer i2 = o.getAge();
        if (s1.compareTo(s2) == 0) { return i1.compareTo(i2); }
        else { return s1.compareTo(s2); }
    }
}
