import java.util.*;
public class mS{
private static int listType;

node sortedMerge(node a, node b)
{
  int nodeA=0;
  int nodeB=0;
  node result = null;
  /* Base cases */
  if (a == null)
    return b;
  if (b == null)
    return a;

  /* Pick either a or b, and recur */

  //se utiliza hashCode para que no haya problema
  //cuando se compara string,int o char

  //crear un if para saber
  if(listType==0){
    nodeA=a.data.hashCode();
    nodeB=b.data.hashCode();
  }
  if(listType==1){
      String nA =a.data.toString();
       String nB= b.data.toString();
       nodeA=nA.compareTo(nB);
       nodeB=nB.compareTo(nA);

  }
  if (nodeA<=nodeB)
  {
    result = a;
    result.next = sortedMerge(a.next, b);
  }
  else {
    result = b;
    result.next = sortedMerge(a, b.next);
  }
  return result;
}

node mergeSort(node h)
 {
  // Base case : if head is null
  if (h == null || h.next == null) {
    return h;
  }

  // get the middle of the list
  node middle = getMiddle(h);
  node nextofmiddle = middle.next;

  // set the next of middle node to null
  middle.next = null;

  // Apply mergeSort on left list
  node left = mergeSort(h);

  // Apply mergeSort on right list
  node right = mergeSort(nextofmiddle);

  // Merge the left and right lists
  node sortedlist = sortedMerge(left, right);
  return sortedlist;
 }
 public static node getMiddle(node head)
 {
   if (head == null)
     return head;

   node slow = head, fast = head;

   while (fast.next != null && fast.next.next != null) {
     slow = slow.next;
     fast = fast.next.next;
   }
   return slow;
 }

 public int readData(Scanner s,list c)
 {
   int lt=s.nextInt();

   while(s.hasNext())
   {
     if(lt==0)
     {
       if(s.hasNextInt())
       {
         c.add(s.nextInt());
       }
     }
     if(lt==1)
     {
       if(s.hasNext())
       {
         c.add(s.next());
       }
     }

    }

   return lt;
 }
 public static void main(String[] args)
 {
   mS ms=new mS();
   Scanner scan = new Scanner(System.in);

   //Se crea lista vacia que sea de enteros
/*
   list<String> list1 = new list<>();
  //  ms.readDataString(scan,list1);
  list1.add("oso");
  list1.add("perro");
  list1.add("gato");
  list1.add("gallo");
  list1.add("ave");
    list1.head = ms.mergeSort(list1.head);
    System.out.println(list1);
  //  ose perro gato gallo ave
*/
    //Se crea igual lista

    list<Integer> list2 = new list<>();
   listType=ms.readData(scan,list2);
     list2.head = ms.mergeSort(list2.head);
     System.out.println(list2);

 }
}

// El algoritmo MergeSort fue basado de la autor:Rishabh Mahrsee
//https://www.geeksforgeeks.org/merge-sort-for-linked-list/
