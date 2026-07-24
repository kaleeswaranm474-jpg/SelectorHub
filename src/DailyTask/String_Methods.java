package DailyTask;

public class String_Methods {

	public static void main(String[] args) {
		String str1 = "Vishnu";
		String str2 = "kaleeswaran";
		String str3 = "Stackly";
		
		        // length()
		        System.out.println("Length: " + str1.length());

		        // concat()
		        System.out.println("Concat: " + str1.concat(" ").concat(str2));

		        // equals()
		        System.out.println("Equals: " + str1.equals(str2));

		        // equalsIgnoreCase()
		        System.out.println("Equals Ignore Case: " + "hello".equalsIgnoreCase("HELLO"));

		        // compareTo()
		        System.out.println("CompareTo: " + str1.compareTo(str2));

		        // charAt()
		        System.out.println("Character at index 1: " + str1.charAt(1));

		        // substring()
		        System.out.println("Substring: " + str1.substring(1, 4));

		        // contains()
		        System.out.println("Contains : " + str1.contains("ky"));

		        // indexOf()
		        System.out.println("Index of 'l': " + str1.indexOf('l'));

		        // lastIndexOf()
		        System.out.println("Last Index of 'l': " + str1.lastIndexOf('l'));

		        // toUpperCase()
		        System.out.println("Uppercase: " + str1.toUpperCase());

		        // toLowerCase()
		        System.out.println("Lowercase: " + str2.toLowerCase());

		        // replace()
		        System.out.println("Replace: " + str1.replace('l', 'x'));

		        // trim()
		        System.out.println("Trim: '" + str3.trim() + "'");

		        // startsWith()
		        System.out.println("Starts with : " + str1.startsWith("Vi"));

		        // endsWith()
		        System.out.println("Ends with : " + str2.endsWith("an"));

		        // isEmpty()
		        String s = "";
		        System.out.println("Is Empty: " + s.isEmpty());


	}

}
