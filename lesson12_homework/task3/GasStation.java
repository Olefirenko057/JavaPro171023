package org.example.lesson12_homework.task3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GasStation {
    private PriorityQueue<Auto> autos = new PriorityQueue<>();
    private class GasStationInstance{
        private static final GasStation GAS_STATION_INSTANCE = new GasStation();
    }
    public static GasStation getInstance(){
        return GasStationInstance.GAS_STATION_INSTANCE;
    }

    private void fillTheCars(PriorityQueue<Auto> autos) {
        while (!autos.isEmpty()) {
            Auto currentAuto = autos.poll();
            System.out.println(currentAuto.getColour() + " " + currentAuto.getAutoType() + " has been filled");
        }
    }

    public void fillCars(OpeningHours currentTime) {
        OpeningHours currentHour = currentTime;

        if(currentHour.getCurrentWeather() == WeatherTypes.BLIZZARD || currentHour.getCurrentWeather() == WeatherTypes.FLOOD) {
            CarTypes.TECHNOLOGICAL_TRANSPORT.setPriorityExtent(1);
            PriorityQueue<Auto> newQueue = new PriorityQueue<>((o1,o2) -> {
                int result = Integer.compare(o1.getAutoType().getPriorityExtent(),o2.getAutoType().getPriorityExtent());
                if(result == 0) {
                    if(o2.getAutoType() == CarTypes.TECHNOLOGICAL_TRANSPORT) {
                        result = o1.getAutoType().compareTo(o2.getAutoType());
                        return result;
                    }
                    if(o2.getAutoType() == CarTypes.AMBULANCE) {
                        result = o2.getAutoType().compareTo(o1.getAutoType());
                        return result;
                    }
                    result = Integer.compare(o1.getQueueId(),o2.getQueueId());
                    return result;
                }
                return result;
            });
            newQueue.addAll(this.autos);
            fillTheCars(newQueue);
            CarTypes.TECHNOLOGICAL_TRANSPORT.setPriorityExtent(2);
        } else if(currentHour == OpeningHours.THIRTEEN || currentHour == OpeningHours.FOURTEEN || currentHour == OpeningHours.FIFTEEN) {
            CarTypes.BUS.setPriorityExtent(1);
            PriorityQueue<Auto> newQueue = new PriorityQueue<>((o1,o2) -> {
                int result = Integer.compare(o1.getAutoType().getPriorityExtent(),o2.getAutoType().getPriorityExtent());
                if(result == 0) {
                    if(o2.getAutoType() == CarTypes.BUS) {
                        result = o2.getAutoType().compareTo(o1.getAutoType());
                        return result;
                    }
                    if(o2.getAutoType() == CarTypes.AMBULANCE) {
                        result = o1.getAutoType().compareTo(o2.getAutoType());
                        return result;
                    }
                    result = Integer.compare(o1.getQueueId(),o2.getQueueId());
                    return result;
                }
                return result;
            });
            newQueue.addAll(this.autos);
            fillTheCars(newQueue);
            CarTypes.BUS.setPriorityExtent(2);
        } else {
            fillTheCars(this.autos);
        }
        autos.clear();
    }

    public PriorityQueue<Auto> getAutos() {
        return autos;
    }
}
