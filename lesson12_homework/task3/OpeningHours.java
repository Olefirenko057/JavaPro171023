package org.example.lesson12_homework.task3;

public enum OpeningHours {
    TEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    ELEVEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    TWELVE(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    THIRTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    FOURTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    FIFTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY}),
    SIXTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.SUNNY,WeatherTypes.RAINY,WeatherTypes.FLOOD,WeatherTypes.BLIZZARD}),
    SEVENTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.RAINY,WeatherTypes.FLOOD,WeatherTypes.BLIZZARD}),
    EIGHTEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.RAINY,WeatherTypes.FLOOD,WeatherTypes.BLIZZARD}),
    NINETEEN(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.RAINY,WeatherTypes.FLOOD,WeatherTypes.BLIZZARD}),
    TWENTY(new WeatherTypes[]{WeatherTypes.CLOUDY,WeatherTypes.RAINY,WeatherTypes.FLOOD,WeatherTypes.BLIZZARD});

    final WeatherTypes[] possibleWeather;
    WeatherTypes currentWeather;

    OpeningHours(WeatherTypes[] possibleWeather) {
        this.possibleWeather = possibleWeather;
    }

    public WeatherTypes[] getPossibleWeather() {
        return possibleWeather;
    }

    public WeatherTypes getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(WeatherTypes currentWeather) {
        this.currentWeather = currentWeather;
    }
}
