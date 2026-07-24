package DailyTask;
import java.io.*;

public class Byte_Stream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("input.png");
			FileOutputStream fos = new FileOutputStream("output.png");
			
			int data;
			while( (data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			System.out.println("File Copied Successfully");
		}  catch(IOException e) {
			System.out.println(e);
		}
	}

}
