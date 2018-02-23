package ua.unit.astepovy;

public class Helicopter  extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherOnCoord = weatherTower.getWeather(this.coordinates);

        switch (weatherOnCoord) {
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongtitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongtitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG": this.coordinates = new Coordinates(coordinates.getLongtitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight());
                break;
            default: break;
        }

        Simulation.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): got " + weatherOnCoord + "ified seriously.");

        if (this.coordinates.getHeight() == 0) {
            Simulation.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Simulation.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulation.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
