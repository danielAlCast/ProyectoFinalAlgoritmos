// Java program for Quick Sort on Singly Linled List
import java.util.*;
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
        int pivot=0
        int nodeStart=0;
        int endStart=0;

        switch(listType){
          case 0:
              pivot= end.data.hashCode();
              nodeStart= start.data.hashCode();
              break;
          case 1:
              String pivotStr=end.data.toString();
              String startStr=start.data.toString()

              pivot=pivotStr.compareTo(startStr);
              nodeStart=startStr.compareTo(pivotStr);
              break;
        }
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end)  {
            if (nodeStart < pivot) {
              pivot_prev = curr;
                 int temp = nodeStart;
                 nodeStart = nodeStart;
                 nodeStart = temp;
                 //es el nodo
                 curr = curr.next;
             }
             start = start.next;
         }
         // swap the position of curr i.e.
         // next suitable index and pivot
         switch(listType){
           case 0:
              int temp = curr.data.hashCode();
              curr.data.hashCode() = pivot;
              end.data.hashCode() = temp;
               break;
           case 1:
               String pivotBefore=start.data.toString();
               String pivotStri=curr.data.toString();
               String pivotStr=end.data.toString();

               int temp=pivotStr.compareTo(pivotBefore);
               temp = pivot;

               break;
         }



         // return one previous to current
         // because current is now pointing to pivot
         return pivot_prev;
    }
    void sort(node start, node end){
        if(start == null || start == end|| start == end.next )
            return;

        // split list and partion recurse
        node pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                 && pivot_prev.next != null)
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
        Scanner scan = new Scanner(System.in);
        int n;

        list<String> list1 = new list<>();
         qS.readDataString(scan,list1);
         System.out.println(list1);

          n=list1.length();

         //list1.sort(list1.head, n);
          System.out.println(list1);

    }
}

// This code is contributed by trinadumca
