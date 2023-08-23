import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DummySection14 {

	
	public static void main(String[] args) {
		// TODO 
		// COUNT THE NUMBER OF NAMES THAT STARTS WITH PARTICULAR LETTER 
		// PRINT THE LIST OF NAMES WHOSE LENGTH>4
		// PRINT ONLY ONE NAME WHOSE LENGTH>4
		// PRINT THE LIST OF NAMES WHOSE LAST LETTER IS "A" IN UPPERCASE
		// PRINT THE LIST OF NAMES WHOSE FIRST LETTER IS "A" IN UPPERCASE IN SORTED ORDER
		// MERGE TWO LISTS AND CHECK IF CONTAINS A PARTICULAR NAME
		// PRINT UNIQUE NUMBERS FROM AN ARRAY
		// SORT IT AND RETURN THE 3RD INDEX

	}
	//1.
	@Test
	public void StreamDemo()
	{
		
				ArrayList<String> names = new ArrayList<>();
				names.add("Abhay");
				names.add("Rahul");
				names.add("sahil");
				names.add("Ankit");
				
				long count = names.stream().filter(s->s.startsWith("A")).count();
				System.out.println("Total number of names starting with letter 'a' : "+count);	
	}
	//2.
	@Test
	public void streamLength()
	{
		System.out.println("Names with length>4 : ");
		Stream.of("Sourabh", "Rahul", "Jae", "Han", "Monty").filter(s -> s.length()> 4)
				.forEach(s -> System.out.println(s));
		
	}
	//3.
	@Test
	public void streamOne()
	{
		Stream.of("Sourabh", "Rahul", "Jae", "Han", "Monty").filter(s -> s.length() > 4).limit(1)
				.forEach(s -> System.out.println("Name with length>4 : "+s));
		
		//4.
		System.out.println("Names with Last letter 'a' in  Uppercase : ");
		
		Stream.of("Sana", "Rahul", "Ace", "Ana", "Monty").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).forEach(s -> System.out.println(s));
		
		//5.
		System.out.println("Names with First letter 'A' in  Uppercase in Sorted order : ");
		
		Stream.of("Sana", "Rahul", "Ace", "Ana", "Monty").filter(s->s.startsWith("A"))
		.map(s->s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
	}
	
	@Test
	public void streamList()
	{
		//6.
		String[] array = {"Sana", "Rahul", "Ace", "Ana", "Monty"};
		List<String> list = Arrays.asList(array);
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhay");
		names.add("Rahul");
		names.add("sahil");
		names.add("Ankit");
		
		System.out.println("Concatenated Stream: ");
		Stream<String> newStream = Stream.concat(list.stream(), names.stream());
		//newStream.forEach(s->System.out.println(s));
		
		boolean match = newStream.anyMatch(s->s.equalsIgnoreCase("Sahil"));
		System.out.println(match);
		Assert.assertTrue(match);
//		SoftAssert a = new SoftAssert();
//		a.assertTrue(match);
		
		
		//7.
		System.out.println("PRINT UNIQUE NUMBERS FROM AN ARRAY: ");
		//int [] arr= {1,3,5,2,1,10};
		List<Integer> list1 = Arrays.asList(1,3,5,2,1,10,2);
		
		list1.stream().distinct().forEach(s->System.out.println(s));
		
		//8.
		System.out.println("SORT ARRAY WITH DISTINCT VALUES AND RETURN THE 3RD INDEX : ");
		List<Integer> resultList = list1.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(resultList.get(3));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
