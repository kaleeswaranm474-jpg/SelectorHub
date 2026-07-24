package DailyTask;

public class String_Builder {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("Java");

        // append()
        sb.append(" Programming");
        System.out.println("Append: " + sb);

        // insert()
        sb.insert(4, " Language");
        System.out.println("Insert: " + sb);

        // replace()
        sb.replace(0, 4, "Core");
        System.out.println("Replace: " + sb);

        // delete()
        sb.delete(4, 13);
        System.out.println("Delete: " + sb);

        // reverse()
        sb.reverse();
        System.out.println("Reverse: " + sb);

        // reverse again
        sb.reverse();

        // length()
        System.out.println("Length: " + sb.length());

        // capacity()
        System.out.println("Capacity: " + sb.capacity());

        // charAt()
        System.out.println("Character at index 3: " + sb.charAt(3));

        // setCharAt()
        sb.setCharAt(3, 'X');
        System.out.println("After setCharAt: " + sb);

        // deleteCharAt()
        sb.deleteCharAt(3);
        System.out.println("After deleteCharAt: " + sb);
}

}

