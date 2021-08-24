package com.Team1.mechanics;

public class AverageDataCalculator {

    public double calculateAverageTemp(double openweathertemp, double weatherstacktemp, double accuweathertemp) {
        double avgTemp = Math.round(openweathertemp + weatherstacktemp + accuweathertemp) / 3;
        return avgTemp;
    }

    public double calculateAveragePressure(double openweatherpressure, double weatherstackpressure, double accuweatherpressure) {
        double avgPressure = Math.round(openweatherpressure + weatherstackpressure + accuweatherpressure) / 3;
        return avgPressure;
    }

    public double calculateAverageHumidity(double openweatherhumidity, double weatherstackhumidity, double accuweatherhumidity) {
        double avgHumidity = Math.round(openweatherhumidity + weatherstackhumidity + accuweatherhumidity) / 3;
        return avgHumidity;
    }

    public double calculateAverageWindSpeed(double openweatherwindspeed, double weatherstackwindspeed, double accuweatherwindspeed) {
        double avgWindSpeed = Math.round(openweatherwindspeed + weatherstackwindspeed + accuweatherwindspeed) / 3;
        return avgWindSpeed;
    }

    public double calculateAverageWindDirection(double openweatherwinddir, double weatherstackwinddir, double accuweatherwinddir) {
        double avgWindDir = Math.round(openweatherwinddir + weatherstackwinddir + accuweatherwinddir);
        return avgWindDir;
    }
}

