package hotelreservation;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class HotelReservationTest {
    @Test
    public void givenHotelAddInHotelReservationReturnNumberOfHotel() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 90, 0);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 50, 0);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 150, 0);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        //check for added hotels
        int hotelCount = hotelReservation.numberOfHotel();
        Assert.assertEquals(3, hotelCount);
    }

    @Test
    public void givenHotelRateAddInHotelReservationReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 90, 0);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 50, 0);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 150, 0);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Hotel hotel = hotelReservation.cheapestHotel("10-Sep-2020", "11-Sep-2020");
        System.out.println("Name: " + hotel.getHotelName() + ", Total Rates: " + hotel.getTotalCost());
        Assert.assertEquals("Lakewood", hotel.getHotelName());
    }

    @Test
    public void givenWeekdayAndWeekendRatesHotelReservationReturnSame() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 0, 0);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 0, 0);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 0, 0);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        lakewood.setWeekendRate(90);
        bridgewood.setWeekendRate(50);
        ridgewood.setWeekendRate(150);
        Assert.assertEquals(90, lakewood.getWeekendRate());
    }

    @Test
    public void givenHotelRatesReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 90, 0);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 50, 0);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 150, 0);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Hotel hotel = hotelReservation.cheapestHotel("11-Sep-2020", "12-Sep-2020");
        System.out.println("Name: " + hotel.getHotelName() + ", Total Rates: " + hotel.getTotalCost());
        Assert.assertEquals("Lakewood", hotel.getHotelName());
    }

    @Test
    public void givenRatingAddRatesHotelReservationReturnSame() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 90, 0);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 50, 0);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 150, 0);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        lakewood.setRating(3);
        bridgewood.setRating(4);
        ridgewood.setRating(5);
        Assert.assertEquals(3, lakewood.getRating());
    }

    @Test
    public void givenHotelRatingReturnCheapestHotel() throws ParseException {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110, 90, 3);
        Hotel bridgewood = new Hotel( "Bridgewood", 150, 50, 4);
        Hotel ridgewood = new Hotel( "Ridgewood", 220, 150, 5);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Hotel hotel = hotelReservation.cheapestHotel("11-Sep-2020", "12-Sep-2020");
        System.out.println("Name: " + hotel.getHotelName() + ", Total Rates: " + hotel.getTotalCost());
        Assert.assertEquals("Bridgewood", hotel.getHotelName());
    }
}
