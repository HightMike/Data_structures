package Saber.serial;

import java.io.*;

import static java.lang.Math.random;

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
    public int Count; // количество элементов

    public void Serialize(OutputStream s)
    {
        PrintWriter pw = new PrintWriter(s);
        ListNode currentElement = Head;
        while (currentElement!=null) {
            Count++;
            pw.println(currentElement.Data + ", случайная ссылка у данного элемента: " + currentElement.Rand);

            currentElement = currentElement.Next;
        }
        pw.flush();
        pw.close();
    }

    public void Deserialize(InputStream s)
    {
        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s))) {
            int count=0;
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                this.addLast(str);
                count++;
                System.out.println("Десериализован " + str);
            }
            System.out.println("Всего элементов в списке: "+count);

        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void addLast(String Data)
    {
        ListNode newNode = new ListNode();
        newNode.Data = Data;
        if (isEmpty()) { // если Head = null
            newNode.Next = null;
            newNode.Prev = null;
            Head = newNode;
            Tail = newNode;

        } else {
            Tail.Next = newNode; // раскидал ссылки
            newNode.Prev = Tail;
            newNode.Next = null;
            Tail = newNode; // переместил Tail на новый элемент
        }
    }
    public void addRands() { // записываем в Rand произвольные элементы
        ListNode currentElement1 = Head;
        while (currentElement1!=null) { // пока не кончится список
            ListNode currentElement2 = Head;
            int random = (int) (Math.random()*(Count));
            for ( int i=0; i<random; i++) { // выбираем случайный элемент
                currentElement2  = currentElement2.Next;
            }
            currentElement1.Rand = currentElement2;
            currentElement1 = currentElement1.Next;
        }
    }

    public boolean isEmpty() {
        return (Head == null);
    }
}