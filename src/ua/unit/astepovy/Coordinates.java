package ua.unit.astepovy;

public class Coordinates {
    private int longtitude;
    private int latitude;
    private int height;

    Coordinates(int longtitude, int latitude, int height) {
        this.longtitude = (longtitude > 0) ? longtitude : 0;
        this.latitude = (latitude > 0) ? latitude : 0;
        this.height = (height > 0 && height <= 100) ? height : (height < 0) ? 0 : 100;
    }

    public int getLongtitude() {
        return this.longtitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }


}
