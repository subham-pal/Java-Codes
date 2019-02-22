
import com.subham.hotelreservation.service.HotelFinder;
import com.subham.hotelreservation.models.*;
import com.subham.hotelreservation.utils.Comp;
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

        HashMap<Category, Integer> rateMap1 = new HashMap<Category, Integer>();
        rateMap1.put(category1, 110);
        rateMap1.put(category2, 80);
        rateMap1.put(category3, 90);
        rateMap1.put(category4, 80);
        Hotel hotel1 = new Hotel("Lakewood", 2, rateMap1);
        myHotels.addHotel(hotel1);

        HashMap<Category, Integer> rateMap2 = new HashMap<Category, Integer>();
        rateMap2.put(category1, 160);
        rateMap2.put(category2, 110);
        rateMap2.put(category3, 60);
        rateMap2.put(category4, 50);

        Hotel hotel2 = new Hotel("Bridgewood", 3, rateMap2);
        myHotels.addHotel(hotel2);

        HashMap<Category, Integer> rateMap3 = new HashMap<Category, Integer>();
        rateMap3.put(category1, 220);
        rateMap3.put(category2, 100);
        rateMap3.put(category3, 150);
        rateMap3.put(category4, 40);
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
        Assert.assertEquals("Lakewood", res.getHotelName());
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
        Assert.assertEquals("Ridgewood", res.getHotelName());
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
        HashMap<Category, Integer> rateMap4 = new HashMap<Category, Integer>();
        rateMap4.put(category1, 220);
        rateMap4.put(category2, 100);
        rateMap4.put(category3, 150);
        rateMap4.put(category4, 40);
        Hotel hotel = new Hotel("Palwood", 4, rateMap4);
        myHotels.addHotel(hotel);
        Boolean res = myHotels.contains("Palwood");
        Assert.assertEquals(res, true);
    }

    @Test
    public void removeHotelTest(){
        HashMap<Category, Integer> rateMap4 = new HashMap<Category, Integer>();
        rateMap4.put(category1, 220);
        rateMap4.put(category2, 100);
        rateMap4.put(category3, 150);
        rateMap4.put(category4, 40);
        Hotel hotel = new Hotel("Donwood", 4, rateMap4);
        myHotels.addHotel(hotel);
        myHotels.removeHotel(hotel);
        Boolean res = myHotels.contains("Donwood");
        Assert.assertEquals(res, false);
    }

}
