package src.main.Input;

public class City {
    public int name;
    public double x;
    public double y;

    public City(int name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double distanceBetweenTwoCities(City other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2.0) + Math.pow(this.y - other.y, 2.0));
    }
}
