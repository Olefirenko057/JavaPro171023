package org.example.lesson12_homework.task3;

public class Auto implements Comparable<Auto> {
    private CarTypes autoType;
    private String colour;
    private int queueId;

    public Auto(CarTypes autoType, String colour) {
        this.autoType = autoType;
        this.colour = colour;
        GasStation.getInstance().getAutos().add(this);
        this.queueId = GasStation.getInstance().getAutos().size();
    }

    @Override
    public int compareTo(Auto o) {
        int result = Integer.compare(this.autoType.priorityExtent,o.autoType.priorityExtent);
        if(result == 0) {
            result = Integer.compare(this.queueId,o.queueId);
            return result;
        }
        return result;
    }

    public CarTypes getAutoType() {
        return autoType;
    }

    public String getColour() {
        return colour;
    }

    public int getQueueId() {
        return queueId;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "autoType=" + autoType +
                ", colour='" + colour + '\'' +
                ", queueId=" + queueId +
                '}';
    }
}
