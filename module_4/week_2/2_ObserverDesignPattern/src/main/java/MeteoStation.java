import java.util.ArrayList;
import java.util.List;

public class MeteoStation extends Observable {

    List<Pair<String, Integer>> zones = new ArrayList<>();

    List<Observer> subscribers = new ArrayList<>();

    @Override
    public Observer[] getSubscribers() {
        return subscribers.toArray(new Observer[0]);
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {

    }

    @Override
    public void addObserver(Observer sub) {
        subscribers.add(sub);
    }

    @Override
    public boolean removeObserver(Observer sub) {
        try {
            int subIndex = subscribers.indexOf(sub);
            subscribers.remove(subIndex);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    @Override
    public void setAlert(String alert, int zone) {

    }
}
