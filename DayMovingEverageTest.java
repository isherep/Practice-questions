import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;

public class DayMovingEverageTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetBulishDays(){
        File file = new File(("/Users/student/Dropbox/input.txt"));
        DayMovingEverage test = new DayMovingEverage();

        ArrayList<String> expected = new ArrayList<String>();
        String[] dates = {"2009-05-11", "2009-05-12", "2009-05-13", "2009-05-14", "2009-05-15"};
        for(String date: dates){
            expected.add(date);
        }
        assertEquals(expected, test.getBulishDays(file));
    }

    public void testShouldReturnNullIfGetBulishDaysHasNoDays(){
        File file1 = new File(("/Users/student/Dropbox/input.txt"));
        DayMovingEverage test = new DayMovingEverage();

        ArrayList<String> expected = new ArrayList<>();
        assertEquals("NULL", test.getBulishDays(file1).get(0));
    }

}
