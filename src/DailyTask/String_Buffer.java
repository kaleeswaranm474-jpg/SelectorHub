package DailyTask;

public class String_Buffer {

	public static void main(String[] args) {
		
				        StringBuffer sb = new StringBuffer("Hello");

				        // append()
				        sb.append(" Vishnu");
				        System.out.println("Append: " + sb);

				        // insert()
				        sb.insert(5, ",");
				        System.out.println("Insert: " + sb);

				        // replace()
				        sb.replace(0, 5, "Hi");
				        System.out.println("Replace: " + sb);

				        // delete()
				        sb.delete(2, 4);
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
				        System.out.println("Character at index 2: " + sb.charAt(2));

				        // setCharAt()
				        sb.setCharAt(2, 'N');
				        System.out.println("After setCharAt: " + sb);

				        // deleteCharAt()
				        sb.deleteCharAt(2);
				        System.out.println("After deleteCharAt: " + sb);
				 
			}
		}
		

