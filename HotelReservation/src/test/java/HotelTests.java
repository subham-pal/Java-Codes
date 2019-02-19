
import com.subham.hotelreservation.service.HotelFinder;
import com.subham.hotelreservation.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelTests {
    private static HotelList myHotels = new HotelList();
    private static Category c1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
    private static Category c2 = new Category(Day.WEEKDAY, CustomerType.REWARD);
    private static Category c3 = new Category(Day.WEEKEND, CustomerType.REGULAR);
    private static Category c4 = new Category(Day.WEEKEND, CustomerType.REWARD);

    @BeforeClass
    public static void setDefaultHotels(){

        HashMap<Category, Double> rateMap1 = new HashMap<Category, Double>();
        rateMap1.put(c1, 110D);
        rateMap1.put(c2, 80D);
        rateMap1.put(c3, 90D);
        rateMap1.put(c4, 80D);
        Hotel h1 = new Hotel("Lakewood", 2, rateMap1);
        myHotels.addHotel(h1);

        HashMap<Category, Double> rateMap2 = new HashMap<Category, Double>();
        rateMap2.put(c1, 160D);
        rateMap2.put(c2, 110D);
        rateMap2.put(c3, 60D);
        rateMap2.put(c4, 50D);

        Hotel h2 = new Hotel("Bridgewood", 3, rateMap2);
        myHotels.addHotel(h2);

        HashMap<Category, Double> rateMap3 = new HashMap<Category, Double>();
        rateMap3.put(c1, 220D);
        rateMap3.put(c2, 100D);
        rateMap3.put(c3, 150D);
        rateMap3.put(c4, 40D);
        Hotel h3 = new Hotel("Ridgewood", 4, rateMap3);
        myHotels.addHotel(h3);
    }
    @Test
    public void mainTest1() {
        ArrayList<Day> daylist = new ArrayList<Day>();
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKEND);
        Request c = new Request(daylist, CustomerType.REGULAR);
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
        Request c = new Request(daylist, CustomerType.REWARD);
        HotelFinder finder = new HotelFinder();
        Hotel res = finder.find(myHotels, c);
        Assert.assertEquals(res.getHotelName(), "Ridgewood");
    }

    @Test
    public void hashCodeTestNotEquals1(){
        Category r1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category r2 = new Category(Day.WEEKEND, CustomerType.REGULAR);
        Assert.assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hashCodeTestNotEquals2(){
        Category r1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category r2 = new Category(Day.WEEKDAY, CustomerType.REWARD);
        Assert.assertNotEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hashCodeTestEquals1(){
        Category r1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category r2 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Assert.assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    public void hotelListSizeTest(){
        Assert.assertEquals(myHotels.count(), 3);
    }

    @Test
    public void addHotelTest(){
        HashMap<Category, Double> rateMap4 = new HashMap<Category, Double>();
        rateMap4.put(c1, 220D);
        rateMap4.put(c2, 100D);
        rateMap4.put(c3, 150D);
        rateMap4.put(c4, 40D);
        Hotel h4 = new Hotel("Palwood", 4, rateMap4);
        myHotels.addHotel(h4);
        Boolean res = myHotels.contains("Palwood");
        Assert.assertEquals(res, true);
    }

    @Test
    public void removeHotelTest(){
        HashMap<Category, Double> rateMap4 = new HashMap<Category, Double>();
        rateMap4.put(c1, 220D);
        rateMap4.put(c2, 100D);
        rateMap4.put(c3, 150D);
        rateMap4.put(c4, 40D);
        Hotel h4 = new Hotel("Donwood", 4, rateMap4);
        myHotels.addHotel(h4);
        myHotels.removeHotel(h4);
        Boolean res = myHotels.contains("Donwood");
        Assert.assertEquals(res, false);
    }
}
