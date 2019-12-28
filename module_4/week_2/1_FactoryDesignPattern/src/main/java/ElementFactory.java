public class ElementFactory extends Factory {

    private static ElementFactory obj = null;

    private ElementFactory() {}

    public static ElementFactory getInstance() {
        if (obj == null){
            obj = new ElementFactory();
        }
        return obj;
    }

    public LevelComponent getElement(char c){

        LevelComponent element = null;

        switch(c){
            case '#':
                element = new Wall();
                break;
            case '-':
                element = new Floor();
                break;
            case 'K':
                element = new Key();
                break;
            case 'D':
                element = new Door();
                break;
        }

        if (element == null) { throw new IllegalArgumentException(); }
        else { return element; }
    }

    public char getChar(Object o){

        if (o instanceof Wall){ return '#'; }
        else if (o instanceof Floor){ return '-'; }
        else if (o instanceof Key){ return 'K'; }
        else if (o instanceof Door){ return 'D'; }
        else { throw new IllegalArgumentException(); }
    }

}
