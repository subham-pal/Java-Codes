import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Arraylist {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		System.out.print("Enter the size : ");
		int size = in.nextInt();
		System.out.print("Enter data : ");
		for(int i = 0; i < size; ++i) {
			int x = in.nextInt();
			a.add(x);
		}
		
		//Accessing through for loop
		int sum1 = 0;
		for(int i = 0; i < size; ++i) {
			sum1 += a.get(i);
		}
		
		//Accessing via  iterator
		int sum2 = 0;
		Iterator<Integer> it = a.iterator();
		while(it.hasNext()) {
			sum2 += (int)it.next();
		}
		
		//Accessing via foreach loop
		int sum3 = 0;
		for(int x : a) {
			sum3 += x;
		}
		
		System.out.println("Sum of arraylist is : ");
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		in.close();
	}
}
