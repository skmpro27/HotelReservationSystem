package hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public int dayOfWeek(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date newDate = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
        cal.setTime(newDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public Hotel cheapestHotel(String... dates) throws ParseException {
        this.dates = dates;
        int min = 999999999;
        Hotel cheapest = hotel.get(0);
        for (int i = 0; i < hotel.size(); i++) {
            int totalCost = hotelTotalCost(i);
            hotel.get(i).setTotalCost(totalCost);
            if (min >= totalCost)
                if (cheapest.getRating() < hotel.get(i).getRating()) {
                    cheapest = hotel.get(i);
                    min = totalCost;
                }
        }
        return cheapest;
    }

    public  int hotelTotalCost(int idx) throws ParseException {
        int totalCost = 0;
        for (int j = 0; j < dates.length; j++) {
            if (dayOfWeek(dates[j]) > 1 && dayOfWeek(dates[j]) < 7)
                totalCost += hotel.get(idx).getWeekdayRate();
            else
                totalCost +=  hotel.get(idx).getWeekendRate();
        }
        return totalCost;
    }

    public Hotel bestRating(String... dates) throws ParseException {
        this.dates = dates;
        Hotel maxRating = hotel.get(0);
        for (int i = 0; i < hotel.size(); i++) {
            int totalCost = hotelTotalCost(i);
            hotel.get(i).setTotalCost(totalCost);
            if (maxRating.getRating() < hotel.get(i).getRating())
                maxRating = hotel.get(i);
        }
        return maxRating;
    }
}
