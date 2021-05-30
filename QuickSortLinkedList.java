// Java program for Quick Sort on Singly Linled List
import java.util.*;
/*sort a linked list using quick sort*/
public
class QuickSortLinkedList {
    // takes first and last node,
    // but do not break any links in
    // the whole linked list
    node paritionLast(node start, node end)
    {
        if (start == end || start == null || end == null)
            return start;

        node pivot_prev = start;
        node curr = start;
        int pivot = (end.data).hashCode();

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if ((start.data).hashCode() < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = (curr.data).hashCode();
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = (curr.data).hashCode();
        curr.data = pivot;
        end.data = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    void sort(node start, node end)
    {
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
    public void readDataString(Scanner s,list c)
    {
      while(s.hasNext())
      {
       if(s.hasNext())
       {
         c.add(s.next());
       }

      }
    }

    // Driver Code
public
    static void main(String[] args)
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
