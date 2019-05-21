package Saber.serial;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        String path = "/home/mike/codes/file2";

        ListRand listRand = new ListRand();
        listRand.addLast("Первый");
        listRand.addLast("Второй");
        listRand.addLast("Третий");
        listRand.Count=3;



//        // хардкодим
//        listRand.Head.Rand = new ListNode();
//        listRand.Head.Rand.Data = "произвольный ";
//        listRand.Head.Next.Next.Next = listRand.Head.Rand;

        listRand.addRands();

        OutputStream outputStream = new FileOutputStream(path);
        listRand.Serialize(outputStream);
        outputStream.close();

        listRand.Head = null; // обнуление списка

        InputStream inputStream = new FileInputStream(path);
        listRand.Deserialize(inputStream);
        inputStream.close();

        OutputStream outputStream2 = new FileOutputStream("/home/mike/codes/file3");
        listRand.Serialize(outputStream2);
        outputStream2.close();

    }
}
