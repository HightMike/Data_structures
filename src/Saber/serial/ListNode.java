package Saber.serial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            pw.println(currentElement.Data + " -Rand- " + currentElement.Rand.Data);

            currentElement = currentElement.Next;
        }
        pw.flush();
        pw.close();
    }

    public void Deserialize(InputStream s)
    {
        List<String> list = new ArrayList<>();

        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s))) {
            Count=0;
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                String[] s1 = str.split(" -Rand- "); // разделяем на элемент и его rand, чтоб потом по дате восстановить
                this.addLast(s1[0]);
                list.add(s1[1]);
                Count++;
                System.out.println("Десериализован " + s1[0]);
            }
            System.out.println("Всего элементов в списке: "+Count);

        } catch (IOException e) {
            e.getStackTrace();
        }
        addRandsWithData(list);

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

    public void addRandsWithData(List<String> list) { // Определение необходимой ссылки для Rand по дате из сериализованного файла
        ListNode currentElement = Head;

        for (String data:list) {
            ListNode currentElement1 = Head;
            while (currentElement1!=null) {
                if (currentElement1.Data.equals(data)) {
                    currentElement.Rand = currentElement1;
                }
                currentElement1=currentElement1.Next;
            }
            currentElement=currentElement.Next;
        }
    }

    public boolean isEmpty() {
        return (Head == null);
    }
}