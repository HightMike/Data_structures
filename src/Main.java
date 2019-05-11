import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {


    public static void main(String[] args) throws Exception{

        ListRand listRand = new ListRand();
        listRand.Head = new ListNode();
        listRand.Head.Data = "asdsd";
        listRand.Count = 3;
        OutputStream outputStream = new FileOutputStream("/home/mike/codes/file2");
        InputStream inputStream = new FileInputStream("/home/mike/codes/file2");
        listRand.Serialize(outputStream);
        //listRand.Deserialize(inputStream);

    }
}
