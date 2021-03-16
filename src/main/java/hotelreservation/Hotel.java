package hotelreservation;

public class Hotel {
    private String hotelName;
    private int totalCost = 0;
    private int weekdayRate;
    private int weekendRate;

    public Hotel(String hotelName, int weekdayRate, int weekendRate ) {
        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setWeekdayRate(int weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
