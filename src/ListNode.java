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

    public void addFirst(String Data) {

        ListNode newNode = new ListNode();
        newNode.Data = Data;

        if (isEmpty()) { // если first = null
            newNode.Next = null;
            newNode.Prev = null;
            Head = newNode;
            Tail = newNode;

        } else {
            Head.Prev = newNode;
            newNode.Next = Head;
            newNode.Prev = null;
            Head = newNode;
        }
    }

    public boolean isEmpty() {
        return (Head == null);
    }

    public void Serialize(OutputStream s)
    {

        PrintWriter pr = new PrintWriter(s);
        ListNode listRand = Head;
        while (listRand!=null) {

            Count++;

            pr.println(listRand.Data + " Под номером: " + Count);
            listRand = listRand.Next;

        }

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