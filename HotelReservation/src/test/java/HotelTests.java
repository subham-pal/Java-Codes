
import com.subham.hotelreservation.service.HotelFinder;
import com.subham.hotelreservation.models.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelTests {
    private static HotelList myHotels = new HotelList();
    private static Category category1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
    private static Category category2 = new Category(Day.WEEKDAY, CustomerType.REWARD);
    private static Category category3 = new Category(Day.WEEKEND, CustomerType.REGULAR);
    private static Category category4 = new Category(Day.WEEKEND, CustomerType.REWARD);

    @BeforeClass
    public static void setDefaultHotels(){

        HashMap<Category, Double> rateMap1 = new HashMap<Category, Double>();
        rateMap1.put(category1, 110D);
        rateMap1.put(category2, 80D);
        rateMap1.put(category3, 90D);
        rateMap1.put(category4, 80D);
        Hotel hotel1 = new Hotel("Lakewood", 2, rateMap1);
        myHotels.addHotel(hotel1);

        HashMap<Category, Double> rateMap2 = new HashMap<Category, Double>();
        rateMap2.put(category1, 160D);
        rateMap2.put(category2, 110D);
        rateMap2.put(category3, 60D);
        rateMap2.put(category4, 50D);

        Hotel hotel2 = new Hotel("Bridgewood", 3, rateMap2);
        myHotels.addHotel(hotel2);

        HashMap<Category, Double> rateMap3 = new HashMap<Category, Double>();
        rateMap3.put(category1, 220D);
        rateMap3.put(category2, 100D);
        rateMap3.put(category3, 150D);
        rateMap3.put(category4, 40D);
        Hotel hotel3 = new Hotel("Ridgewood", 4, rateMap3);
        myHotels.addHotel(hotel3);
    }
    @Test
    public void mainTest1() {
        ArrayList<Day> daylist = new ArrayList<Day>();
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKEND);
        Request request = new Request(daylist, CustomerType.REGULAR);
        HotelFinder finder = new HotelFinder();
        Hotel res = finder.find(myHotels, request);
        Assert.assertEquals(res.getHotelName(), "Lakewood");
    }

    @Test
    public void mainTest2() {
        ArrayList<Day> daylist = new ArrayList<Day>();
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKDAY);
        daylist.add(Day.WEEKEND);
        Request request = new Request(daylist, CustomerType.REWARD);
        HotelFinder finder = new HotelFinder();
        Hotel res = finder.find(myHotels, request);
        Assert.assertEquals(res.getHotelName(), "Ridgewood");
    }

    @Test
    public void hashCodeTestNotEquals1(){
        Category category1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category category2 = new Category(Day.WEEKEND, CustomerType.REGULAR);
        Assert.assertNotEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void hashCodeTestNotEquals2(){
        Category category1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category category2 = new Category(Day.WEEKDAY, CustomerType.REWARD);
        Assert.assertNotEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void hashCodeTestEquals1(){
        Category category1 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Category category2 = new Category(Day.WEEKDAY, CustomerType.REGULAR);
        Assert.assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void hotelListSizeTest(){
        Assert.assertEquals(myHotels.count(), 3);
    }

    @Test
    public void addHotelTest(){
        HashMap<Category, Double> rateMap4 = new HashMap<Category, Double>();
        rateMap4.put(category1, 220D);
        rateMap4.put(category2, 100D);
        rateMap4.put(category3, 150D);
        rateMap4.put(category4, 40D);
        Hotel hotel = new Hotel("Palwood", 4, rateMap4);
        myHotels.addHotel(hotel);
        Boolean res = myHotels.contains("Palwood");
        Assert.assertEquals(res, true);
    }

    @Test
    public void removeHotelTest(){
        HashMap<Category, Double> rateMap4 = new HashMap<Category, Double>();
        rateMap4.put(category1, 220D);
        rateMap4.put(category2, 100D);
        rateMap4.put(category3, 150D);
        rateMap4.put(category4, 40D);
        Hotel hotel = new Hotel("Donwood", 4, rateMap4);
        myHotels.addHotel(hotel);
        myHotels.removeHotel(hotel);
        Boolean res = myHotels.contains("Donwood");
        Assert.assertEquals(res, false);
    }
}
