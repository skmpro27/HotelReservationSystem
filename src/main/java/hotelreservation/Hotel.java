package hotelreservation;

public class Hotel {
    private String hotelName;
    private final int REGULAR_RATE;

    public Hotel(String hotelName, int regularRate) {
        this.hotelName = hotelName;
        this.REGULAR_RATE = regularRate;
    }
}
