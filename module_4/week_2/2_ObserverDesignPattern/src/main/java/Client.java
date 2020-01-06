public class Client extends Observer {

    String news;
    int zone;

    @Override
    public void update(Object o) {

    }

    @Override
    public int getZone() {
        return zone;
    }

    @Override
    public String getNews() {
        return news;
    }
}
