public class Level extends AbstractLevel {

    int size;
    LevelComponent[][] components;
    ElementFactory factoryInstance = ElementFactory.getInstance();

    public Level(String input){
        size = 0;
        int dim = input.length() - input.replace("\n", "").length();
        int i = 0;
        int j = 0;

        components = new LevelComponent[dim][dim];
        for (char ch: input.toCharArray()) {
            if (ch == '\n') {
                i++;
                j = 0;
            } else {
                components[i][j] = factoryInstance.getElement(ch);
                j++;
                size++;
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public LevelComponent[][] getComponents() {
        return components;
    }

    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < Math.sqrt(size); i++) {
            for (int j = 0; j < Math.sqrt(size); j++) {
                s += factoryInstance.getChar(components[i][j]);
            }
            s += "\n";
        }
        return s;
    }
}
