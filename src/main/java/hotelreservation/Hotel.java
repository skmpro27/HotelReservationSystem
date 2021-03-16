package hotelreservation;

public class Hotel {
    private String hotelName;
    private int totalCost = 0;
    private final int REGULAR_RATE;

    public Hotel(String hotelName, int regularRate) {
        this.hotelName = hotelName;
        this.REGULAR_RATE = regularRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRegularRate() {
        return REGULAR_RATE;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
