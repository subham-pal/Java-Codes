
import com.subham.hotelreservaion.service.HotelFinder;
import com.subham.hotelreservation.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelTests {
    private static HotelList myHotels = new HotelList();
    private static Request r1 = new Request(Day.WEEKDAY, Type.REGULAR);
    private static Request r2 = new Request(Day.WEEKDAY, Type.REWARD);
    private static Request r3 = new Request(Day.WEEKEND, Type.REGULAR);
    private static Request r4 = new Request(Day.WEEKEND, Type.REWARD);

    @BeforeClass
    public static void setDefaultHotels(){

        HashMap<Request, Double> rateMap1 = new HashMap<Request, Double>();
        rateMap1.put(r1, 110D);
        rateMap1.put(r2, 80D);
        rateMap1.put(r3, 90D);
        rateMap1.put(r4, 80D);
        Hotel h1 = new Hotel("Lakewood", 2, rateMap1);
        myHotels.addHotel(h1);

        HashMap<Request, Double> rateMap2 = new HashMap<Request, Double>();
        rateMap2.put(r1, 160D);
        rateMap2.put(r2, 110D);
        rateMap2.put(r3, 60D);
        rateMap2.put(r4, 50D);

        Hotel h2 = new Hotel("Bridgewood", 3, rateMap2);
        myHotels.addHotel(h2);

        HashMap<Request, Double> rateMap3 = new HashMap<Request, Double>();
        rateMap3.put(r1, 220D);
        rateMap3.put(r2, 100D);
        rateMap3.put(r3, 150D);
        rateMap3.put(r4, 40D);
        Hotel h3 = new Hotel("Ridgewood", 4, rateMap3);
        myHotels.addHotel(h3);
    }
    @Test
    public void mainTest1() {
        ArrayList<Day> daylist = new ArrayList<Day>();
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKEND);
        Customer c = new Customer(daylist, Type.REGULAR);
        HotelFinder finder = new HotelFinder();
        Hotel res = finder.find(myHotels, c);
        Assert.assertEquals(res.getHotelName(), "Lakewood");
    }

    @Test
    public void mainTest2() {
        ArrayList<Day> daylist = new ArrayList<Day>();
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKEND);
        Customer c = new Customer(daylist, Type.REWARD);
        HotelFinder finder = new HotelFinder();
        Hotel res = finder.find(myHotels, c);
        Assert.assertEquals(res.getHotelName(), "Ridgewood");
    }

    @Test
    public void hashCodeTestNotEquals1(){
        Request r1 = new Request(Day.WEEKDAY, Type.REGULAR);
        Request r2 = new Request(Day.WEEKEND, Type.REGULAR);
        Assert.assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hashCodeTestNotEquals2(){
        Request r1 = new Request(Day.WEEKDAY, Type.REGULAR);
        Request r2 = new Request(Day.WEEKDAY, Type.REWARD);
        Assert.assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hashCodeTestEquals1(){
        Request r1 = new Request(Day.WEEKDAY, Type.REGULAR);
        Request r2 = new Request(Day.WEEKDAY, Type.REGULAR);
        Assert.assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hotelListSizeTest(){
        Assert.assertEquals(myHotels.size(), 3);
    }

    @Test
    public void addHotelTest(){
        HashMap<Request, Double> rateMap4 = new HashMap<Request, Double>();
        rateMap4.put(r1, 220D);
        rateMap4.put(r2, 100D);
        rateMap4.put(r3, 150D);
        rateMap4.put(r4, 40D);
        Hotel h4 = new Hotel("Palwood", 4, rateMap4);
        myHotels.addHotel(h4);
        Boolean res = myHotels.contains("Palwood");
        Assert.assertEquals(res, true);
    }

    @Test
    public void removeHotelTest(){
        HashMap<Request, Double> rateMap4 = new HashMap<Request, Double>();
        rateMap4.put(r1, 220D);
        rateMap4.put(r2, 100D);
        rateMap4.put(r3, 150D);
        rateMap4.put(r4, 40D);
        Hotel h4 = new Hotel("Donwood", 4, rateMap4);
        myHotels.addHotel(h4);
        myHotels.removeHotel(h4);
        Boolean res = myHotels.contains("Donwood");
        Assert.assertEquals(res, false);
    }
}
