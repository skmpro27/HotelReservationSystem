package hotelreservation;

import java.util.*;

enum CustomerType {
    CUSTOMER_TYPE_REGULAR
}

public class HotelReservation {
    List<Hotel> hotel = new ArrayList<>();
    CustomerType type;
    String dates[];

    public HotelReservation(CustomerType type) {
        this.type = type;
    }

    public void addHotel(Hotel hotelAdd) {
        hotel.add(hotelAdd);
    }

    public int numberOfHotel() {
        return hotel.size();
    }

    public Hotel cheapestHotel(String... dates) {
        this.dates = dates;
        int min = 999999999;
        Hotel cheapest = null;
        int totalCost = 0;
        for (int i = 0; i < hotel.size(); i++) {
            for (int j = 0; j < dates.length; j++) {
                totalCost = totalCost + hotel.get(i).getRegularRate();
            }
            if (min > totalCost) {
                hotel.get(i).setTotalCost(totalCost);
                cheapest = hotel.get(i);
                min = totalCost;
            }
        }
        return cheapest;
    }
}
