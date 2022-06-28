package Activity;

public class ClientTest {
    public static void main(String[] args) {
        Activity a = new ActivityBuilder("aaaa", "bbb").buildA("aaaa", 100);
        RunTimeData runTimeData = new RunTimeData(200);
        a.save();


        Activity b = new Activity();
        try {
            b.load("aaaa");
            b.run(runTimeData);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
