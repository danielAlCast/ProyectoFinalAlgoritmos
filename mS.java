
public class mS{

node sortedMerge(node a, node b)
{
  node result = null;
  /* Base cases */
  if (a == null)
    return b;
  if (b == null)
    return a;

  /* Pick either a or b, and recur */

  //se utiliza hashCode para que no haya problema
  //cuando se compara string,int o char
  if (((a.data).hashCode()) <=((b.data).hashCode()) ){
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
 public static void main(String[] args)
 {
   mS ms=new mS();

   //Se crea lista vacia que sea de enteros
   list<String> list1 = new list<>();
   System.out.println(
     "Integer LinkedList created as list1 :");
   // Adding elements to the above List object

    //se le agregan datos
   list1.add("daniel");
   list1.add("sofia");
   list1.add("lola");


   // Imprime lista sin haber sido ordenadas
   System.out.println(list1);
   // Apply merge Sort
    list1.head = ms.mergeSort(list1.head);
   System.out.print("\n Sorted Linked List is: \n");
   System.out.println(list1+"\n"+"\n");

   //Se crea lista vacia que sea de Strings
   list<Integer> list2 = new list<>();
   System.out.println(
     "Integer LinkedList created as list1 :");
   // Adding elements to the above List object

   //se le agregan datos
   list2.add(100);
   list2.add(2000);
   list2.add(3);


   // Imprime lista sin haber sido ordenadas
   System.out.println(list2);
   // Apply merge Sort
    list2.head = ms.mergeSort(list2.head);
   System.out.print("\n Sorted Linked List is: \n");
   System.out.println(list2);
 }
}

// El algoritmo MergeSort fue basado de la autor:Rishabh Mahrsee
//https://www.geeksforgeeks.org/merge-sort-for-linked-list/
