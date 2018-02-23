package ua.unit.astepovy;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN","FOG","SUN","SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[((coordinates.getLongtitude() > 10) ? 1 : 0) + ((coordinates.getLatitude() > 20) ? 1 : 0) + ((coordinates.getHeight() > 5) ? 1 : 0)];
    }
}
