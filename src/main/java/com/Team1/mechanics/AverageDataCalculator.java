package com.Team1.mechanics;

public class AverageDataCalculator {

    public double calculateAverageTemp(double openweathertemp, double weatherstacktemp, double accuweathertemp) {
        double avgTemp = (openweathertemp + weatherstacktemp + accuweathertemp) / 3;
        System.out.println("Srednia temperatura: " + avgTemp);
        return avgTemp;
    }

    public double calculateAveragePressure(double openweatherpressure, double weatherstackpressure, double accuweatherpressure) {
        double avgPressure = (openweatherpressure + weatherstackpressure + accuweatherpressure) / 3;
        System.out.println("Srednia wartość ciśnienia: " + avgPressure);
        return avgPressure;
    }

    public double calculateAverageHumidity(double openweatherhumidity, double weatherstackhumidity, double accuweatherhumidity) {
        double avgHumidity = (openweatherhumidity + weatherstackhumidity + accuweatherhumidity) / 3;
        System.out.println("Srednia wilgotnoć: " + avgHumidity);
        return avgHumidity;
    }

    public double calculateAverageWindSpeed(double openweatherwindspeed, double weatherstackwindspeed, double accuweatherwindspeed) {
        double avgWindSpeed = (openweatherwindspeed + weatherstackwindspeed + accuweatherwindspeed) / 3;
        System.out.println("Srednia prędkość wiatru: "+avgWindSpeed);
        return avgWindSpeed;
    }

    public double calculateAverageWindDirection(double openweatherwinddir, double weatherstackwinddir, double accuweatherwinddir) {
        double avgWindDir = (openweatherwinddir + weatherstackwinddir + accuweatherwinddir);
        System.out.println("Sreddna wartość kierunku wiatru w stopniach: "+avgWindDir);
        return avgWindDir;
    }
}

