import java.io.*;

class ListNode

{
    public ListNode Prev;
    public ListNode Next;
    public ListNode Rand; // произвольный элемент внутри списка
    public String Data;
}

class ListRand

{
    public ListNode Head;
    public ListNode Tail;

    public int Count;

    public void Serialize(OutputStream s)
    {

        PrintWriter pr = new PrintWriter(s);
        pr.println(this.Head.Data);
        pr.println(this.Count);

        pr.flush();


    }

    public void Deserialize(InputStream s)
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s));
        try {
            int k = Integer.parseInt(bufferedReader.readLine());
            System.out.println(k);
        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}