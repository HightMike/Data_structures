package Serialization_of_a_doubly_linked_list;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        String path = "/home/mike/codes/file2";

        ListRand listRand = new ListRand();
        listRand.addLast("Первый");
        listRand.addLast("Второй");
        listRand.addLast("Третий");

        listRand.Head.Rand = new ListNode();
        listRand.Head.Rand.Data = "произвольный ";
        listRand.Head.Next.Next.Next = listRand.Head.Rand;

        OutputStream outputStream = new FileOutputStream(path);
        listRand.Serialize(outputStream);

        listRand.Head = null; // обнуление списка

        InputStream inputStream = new FileInputStream(path);
        listRand.Deserialize(inputStream);

        OutputStream outputStream2 = new FileOutputStream("/home/mike/codes/file3");
        listRand.Serialize(outputStream2);

    }
}
