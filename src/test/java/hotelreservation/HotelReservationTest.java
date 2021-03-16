package hotelreservation;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void givenHotelAddInHotelReservationReturnNumberOfHotel() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110);
        Hotel bridgewood = new Hotel( "Bridgewood", 160);
        Hotel ridgewood = new Hotel( "Ridgewood", 220);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        //check for added hotels
        int hotelCount = hotelReservation.numberOfHotel();
        Assert.assertEquals(3, hotelCount);
    }

    @Test
    public void givenHotelRateAddInHotelReservationReturnCheapestHotel() {
        HotelReservation hotelReservation = new HotelReservation(CustomerType.CUSTOMER_TYPE_REGULAR);
        Hotel lakewood = new Hotel( "Lakewood", 110);
        Hotel bridgewood = new Hotel( "Bridgewood", 160);
        Hotel ridgewood = new Hotel( "Ridgewood", 220);
        //adding hotels
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        //check for added hotels
        Hotel hotel = hotelReservation.cheapestHotel("10Sep2020", "11Sep2020");
        System.out.println("Name: " + hotel.getHotelName() + ", Total Rates: " + hotel.getTotalCost());
        Assert.assertEquals("Lakewood", hotel.getHotelName());
    }
}
