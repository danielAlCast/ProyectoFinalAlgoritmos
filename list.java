import java.io.*;

// Class 2
// Helper class ( Generic LinkedList class)
class list<T> {

    // Generic node instance
    node<T> head;
    // Data member to store length of list
    private int length = 0;

    // Default constructor
    list() { this.head = null; }
    // Method
    // To add node at the end of List
    void add(T data)
    {

        // Creating new node with given value
        node<T> temp = new node<>(data);

        // Checking if list is empty
        // and assigning new value to head node
        if (this.head == null) {
            head = temp;
        }

        // If list already exists
        else {

            // Temporary node for traversal
            node<T> X = head;

            // Iterating till end of the List
            while (X.next != null) {
                X = X.next;
            }

            // Adding new valued node at the end of the list
            X.next = temp;
        }

        // Increasing length after adding new node
        length++;
    }

    // Method
    // To add new node at any given position
    void add(int position, T data)
    {

        // Checking if position is valid
        if (position > length + 1) {

            // Display message only
            System.out.println(
                "Position Unavailable in LikedList");
            return;
        }

        // If new position is head then replace head node
        if (position == 1) {

            // Temporary node that stores previous head
            // value
            node<T> temp = head;

            // New valued node stored in head
            head = new node<T>(data);

            // New head node pointing to old head node
            head.next = temp;

            return;
        }

        // Temporary node for traversal
        node<T> temp = head;

        // Dummy node with null value that stores previous
        // node
        node<T> prev = new node<T>(null);
        // interating to the given position
        while (position - 1 > 0) {
            // assigning previous node
            prev = temp;
            // incrementing next node
            temp = temp.next;
            // decreasing position counter
            position--;
        }
        // previous node now points to new value
        prev.next = new node<T>(data);
        // new value now points to former current node
        prev.next.next = temp;
    }

    // Method
    // Returns whether List is empty or not
    boolean empty()
    {

        // Checking if head node points to null
        if (head == null) {
            return true;
        }
        return false;
    }
    // Method
    // Returning the length of LinkedList
    int length() { return this.length; }

    // Method
    // To display the LinkedList
    // @Override
    public String toString()
    {

        String S = "{ ";

        node<T> X = head;

        if (X == null)
            return S + " }";

        while (X.next != null) {
            S += String.valueOf(X.data) + " -> ";
            X = X.next;
        }

        S += String.valueOf(X.data);
        return S + " }";
    }
}
//This code is contributed by varunkedia
//Reference:https://www.geeksforgeeks.org/how-to-implement-generic-linkedlist-in-java/
