package hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

enum CustomerType {
    CUSTOMER_TYPE_REGULAR,
    CUSTOMER_TYPE_REWARD
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

    public int typeCustomer(boolean weekday, Hotel hotel) {
        if (type == CustomerType.CUSTOMER_TYPE_REGULAR && weekday)
            return hotel.getWeekdayRate();
        else if (type == CustomerType.CUSTOMER_TYPE_REGULAR)
            return hotel.getWeekendRate();
        else if (weekday)
            return hotel.getWeekdayRewardRate();
        else
            return hotel.getWeekendRewardRate();
    }

    public int dayOfWeek(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        Date newDate = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
        cal.setTime(newDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public Hotel cheapestHotel() throws ParseException {
        Hotel cheapest = hotel.stream()
                .min(Comparator.comparing(Hotel::getTotalCost))
                .orElseThrow(NoSuchElementException::new);

        return hotel.stream()
                .filter(ht -> ht.getTotalCost() == cheapest.getTotalCost())
                .max(Comparator.comparing(Hotel::getRating))
                .orElseThrow(NoSuchElementException::new);
    }

    public void setHotelTotalCost(String... dates) {
        this.dates = dates;
        hotel.forEach(ht -> ht.setTotalCost(Arrays.stream(dates)
                .map(date -> {
                    try {
                        return dayOfWeek(date) == 1 || dayOfWeek(date) == 7;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .mapToInt(weekday -> typeCustomer(weekday, ht)).sum()));
    }

    public Hotel bestRating() throws ParseException {
        return hotel.stream()
                .max(Comparator.comparing(Hotel::getRating))
                .orElseThrow(NoSuchElementException::new);
    }
}
