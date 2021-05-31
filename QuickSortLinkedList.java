// Java program for Quick Sort on Singly Linled List
import java.util.*;
import java.time.Instant;
import java.time.Duration;
/*sort a linked list using quick sort*/
public class QuickSortLinkedList {
  //guarda que tipo de datos es la lista
  private static int listType;
    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    node paritionLast(node start, node end)
    {
        if (start == end || start == null || end == null)
            return start;

        node pivot_prev = start;
        node curr = start;
        int pivot=(int)end.data;

        while (start != end){
            if ((int)start.data < pivot){
              // keep tracks of last modified item
                 pivot_prev = curr;
                 int temp = (int)curr.data;
                 curr.data = (int)start.data;
                 start.data = temp;
                 curr = curr.next;
             }
             start = start.next;
         }

         // swap the position of curr i.e.
         // next suitable index and pivot
         int temp =(int) curr.data;
         curr.data = pivot;
         end.data = temp;
         // return one previous to current
         // because current is now pointing to pivot
         return pivot_prev;
    }
    node paritionLastStr(node start, node end)
    {
        if (start == end || start == null || end == null)
            return start;

        node pivot_prev = start;
        node curr = start;
        //Sacar valor de los nodos en Strings
        String nS=start.data.toString();
        String nP=end.data.toString();
        //comparamos para saber el valor de la diferencia entre el final con incial
        int pivot=nP.compareTo(nS);
        //comparamos para saber el valor de la diferencia entre el inicial con final
        int sD=nS.compareTo(nP);
        //Obtenemos valor de nodo curr en String
        String currN=curr.data.toString();
        //System.out.println(curr.data.toString());
        //System.out.println(pivot.data.toString());

        while (start != end){
          //comparamos las diferencias entre los Strings
            if (sD < pivot){
              // keep tracks of last modified item
                //adquiere valor del curr anterior
                 pivot_prev = curr;
                 String temp = curr.data.toString();
                 curr.data = start.data.toString();
                 start.data=temp;
                 //curr se mueve
                 curr = curr.next;
             }
             start = start.next;
             nS=start.data.toString();
             sD=nS.compareTo(nP);
             pivot=nP.compareTo(nS);
         }
         // swap the position of curr i.e.
         // next suitable index and pivot
         String temp =curr.data.toString();
         curr.data= end.data.toString();
         end.data = temp;
         // return one previous to current
         // because current is now pointing to pivot
         return pivot_prev;
    }
    void sort(node start, node end){
        if(start == null || start == end|| start == end.next )
            return;
        // split list and partion recurse
        node pivot_prev = paritionLastStr(start, end);
        sort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }
    public int readData(Scanner s,list c){
      int lt=s.nextInt();

      while(s.hasNext()){
        if(lt==0){
          if(s.hasNextInt()){
            c.add(s.nextInt());
          }
        }

        if(lt==1){
          if(s.hasNext()){
            c.add(s.next());
          }
        }

      }
      return lt;
    }

    // Driver Code
public static void main(String[] args)
    {
        QuickSortLinkedList qS= new QuickSortLinkedList();
        Instant start = Instant.now();
        Scanner scan = new Scanner(System.in);

      //dependiendo del tipo de variable que quieras la declaras en <->
        list<String> list1 = new list<>();
         qS.readData(scan,list1);
         System.out.println(list1);

         node n = list1.head;
         while (n.next != null)
             n = n.next;

         qS.sort(list1.head, n);
         System.out.println(list1);
         Instant finish = Instant.now();
         long timeElapsed = Duration.between(start, finish).toMillis();
         System.out.println("Tiempo de ejecucion (ms): " + timeElapsed);
    }

}

// This code is contributed by trinadumca
