package Dataclass2;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTest {
	public static void main(String[] args) {
		Date now = new Date();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}

}
