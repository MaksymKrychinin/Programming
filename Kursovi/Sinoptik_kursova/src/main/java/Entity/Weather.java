package Entity;

public class Weather {
    String weather;
    WeatherDate weatherDate;
    Location location;


    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public WeatherDate getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(WeatherDate weatherDate) {
        this.weatherDate = weatherDate;
    }

    public Weather(String weather, Location location, WeatherDate weatherDate) {
        this.weather = weather;
        this.location = location;
        this.weatherDate = weatherDate;
    }
}
