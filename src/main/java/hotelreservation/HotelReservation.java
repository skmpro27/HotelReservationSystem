package hotelreservation;

import java.util.ArrayList;
import java.util.List;

enum CustomerType {
    CUSTOMER_TYPE_REGULAR
}

public class HotelReservation {
    List<Hotel> hotel = new ArrayList<>();
    CustomerType type;

    public HotelReservation(CustomerType type) {
        this.type = type;
    }

    public void addHotel(Hotel hotelAdd) {
        hotel.add(hotelAdd);
    }

    public int numberOfHotel() {
        return hotel.size();
    }
}
