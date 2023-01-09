package db;

import Entity.Location;
import Entity.Weather;
import Entity.WeatherDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {
    public List<Weather> weatherList(Location location, WeatherDate date1, WeatherDate date2) {
        List<Weather> weatherList = new ArrayList<>();
        String query = "SELECT l.locationName, wd.date, w.weather FROM sinoptik.weather w\n" +
                "INNER JOIN sinoptik.location l On w.idlocation=l.idlocation\n" +
                "INNER JOIN sinoptik.weatherdate wd on w.idweatherDate=wd.idweatherDate\n" +
                "where l.locationName=? and wd.date between ? and ?" +
                "order by wd.date;";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getLocationName());
            preparedStatement.setDate(2, date1.getDate());
            preparedStatement.setDate(3, date2.getDate());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location locationName = new Location(resultSet.getString(1));
                WeatherDate date = new WeatherDate(resultSet.getDate(2));
                String weather = resultSet.getString(3);
                Weather weatherToList = new Weather(weather, locationName, date);
                weatherList.add(weatherToList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherList;
    }

    public Weather weatherOneDay(Location location, WeatherDate date1) {
        String query = "SELECT l.locationName, wd.date, w.weather FROM sinoptik.weather w\n" +
                "INNER JOIN sinoptik.location l On w.idlocation=l.idlocation\n" +
                "INNER JOIN sinoptik.weatherdate wd on w.idweatherDate=wd.idweatherDate\n" +
                "where l.locationName=? and wd.date=?";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getLocationName());
            preparedStatement.setDate(2, date1.getDate());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Location locationName = new Location(resultSet.getString(1));
                WeatherDate date = new WeatherDate(resultSet.getDate(2));
                String weather = resultSet.getString(3);
                Weather weatherToReturn = new Weather(weather, locationName, date);
                return weatherToReturn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addWeather(Weather weather) {
        String query1="INSERT IGNORE INTO sinoptik.location (locationName) VALUES(?);";
        String query2="INSERT IGNORE INTO sinoptik.weatherdate (date) VALUES(?);";
        String query3 = "INSERT INTO sinoptik.weather(idlocation, idweatherDate, weather) VALUES\n" +
                " ((SELECT idlocation From sinoptik.location where locationName=?)," +
                "(SELECT idweatherDate From sinoptik.weatherdate where date=?),?);";
        try (DBConnection db = new DBConnection()) {
            Connection connection = db.getConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
            preparedStatement1.setString(1, weather.getLocation().getLocationName());
            preparedStatement2.setDate(1, weather.getWeatherDate().getDate());
            preparedStatement3.setString(1, weather.getLocation().getLocationName());
            preparedStatement3.setDate(2,weather.getWeatherDate().getDate());
            preparedStatement3.setString(3, weather.getWeather());
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
