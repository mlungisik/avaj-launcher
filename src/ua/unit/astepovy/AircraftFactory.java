package ua.unit.astepovy;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longtitude, latitude, height);

        switch (type) {
            case("Helicopter"): return new Helicopter(name, coordinates);
            case("JetPlane"): return new JetPlane(name, coordinates);
            case("Baloon"): return new Baloon(name, coordinates);
            default: return null;
        }
    }
}
