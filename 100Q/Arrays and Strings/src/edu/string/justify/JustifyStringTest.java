package edu.string.justify;

import java.util.List;

import org.junit.Test;

public class JustifyStringTest {

	JustifyString anInstance = new JustifyString();

	@Test
	public void test() {
		String[] strArr = { "This", "is", "an", "example", "of", "text",
				"justification." };
		List<String> list = anInstance.fullJustify(strArr, 16);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}

	@Test
	public void testTwo() {
		String[] str = { "What", "must", "be", "shall", "be." };
		List<String> list = anInstance.fullJustify(str, 12);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}
	
	
	@Test
	public void testThree(){
		String[] str2 = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		List<String> list = anInstance.fullJustify(str2, 30);
	
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
	}
	
}
