package com.Team1.mechanics;

public class AverageDataCalculator {

    public double calculateAverageTemp(double openweathertemp, double weatherstacktemp, double accuweathertemp) {
        return (double) Math.round(openweathertemp + weatherstacktemp + accuweathertemp) / 3;
    }

    public double calculateAveragePressure(double openweatherpressure, double weatherstackpressure, double accuweatherpressure) {
        return (double) (Math.round(openweatherpressure + weatherstackpressure + accuweatherpressure) / 3);
    }

    public double calculateAverageHumidity(double openweatherhumidity, double weatherstackhumidity, double accuweatherhumidity) {
        return (double) (Math.round(openweatherhumidity + weatherstackhumidity + accuweatherhumidity) / 3);
    }

    public double calculateAverageWindSpeed(double openweatherwindspeed, double weatherstackwindspeed, double accuweatherwindspeed) {
        return (double) (Math.round(openweatherwindspeed + weatherstackwindspeed + accuweatherwindspeed) / 3);
    }

    public double calculateAverageWindDirection(double openweatherwinddir, double weatherstackwinddir, double accuweatherwinddir) {
        return (double) (Math.round(openweatherwinddir + weatherstackwinddir + accuweatherwinddir)/3);
    }
}

