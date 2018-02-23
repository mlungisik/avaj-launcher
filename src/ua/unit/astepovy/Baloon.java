package ua.unit.astepovy;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherOnCoord = weatherTower.getWeather(this.coordinates);

        switch (weatherOnCoord) {
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongtitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case "FOG": this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
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
