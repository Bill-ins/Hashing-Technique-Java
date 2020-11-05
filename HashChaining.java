import java.util.Scanner;

public class HashChaining {

    /** Hash chaining is a method of Hashing, where we use the concept of Linked Lists. In this method if there is a collision,
     *  while adding data to the array after converting the array index to the hashing key index, then we just chain
     *  the new data with the data which filled the array space (which was causing collision) in the same array index,
     *  which forms a chain like structure just like the linked list. */

    /** As I mentioned it involves the same concept as the Link List, and we have to store the Node instead of the raw key;
     *  so, here is the Node class which I made as a inner class */
    class Node {

        int value;
        Node nxtNode;

        public Node(int value) {
            this.value = value;
            this.nxtNode = null;
        }
    }


    Node arr[];
    int size = 0; // This increase by 1 everytime we add a node.

    // Constructor for Array Size
    HashChaining(int arraySize) {
        arr = new Node[arraySize];
    }

    // Adding data to the array
    /** Here we first check that if the hashing index in the array is empty or not. If it is not empty then we go to the last node of
     *  of that hashing index by a loop, and link or chain or add our new node with that last node in that same hashing index */
    public void add(int val) {

        Node node = new Node(val);

        int hashingIndex = val % arr.length;

        /** Here we are checking that if the hashing index is empty or not. If it is empty then we go ahead and just add our new
         *  node to that hashing index of that array. */

        /** Created this if block to make sure that the count node we are adding is not more than the array size. As we are
         *  implementing the linked list concept so some additional node can be inserted. So to restrict the addition of any
         *  further node in the array, we are just manipulating with the size variable. */
        if(size <= arr.length) {

            if (arr[hashingIndex] == null) {
                arr[hashingIndex] = node;
                size++;
                return;
            }
            /** If the that hashing index is not empty then we fetch the last node of that index by loop and chain our new node with it.
             *  Remember, I mentioned about fetching or getting the last node, which means we are not looping till our traverse or
             *  loop variable becomes, we are just looping till it's the second node becomes null */
            else {
                Node currNode = arr[hashingIndex];
                int i = 0;
                while (currNode.nxtNode != null && i < arr.length) {
                    currNode = currNode.nxtNode;
                    size++;
                    i++;
                }
                if (size < arr.length) {
                    currNode.nxtNode = node;
                    size++;
                    return;
                }
            }
        }
        System.out.println("Array is full");
    }
    
    //Print all elements of the array.
    public void printAll() {

        // Here we looping through the array.
        for(Node n : arr) {

            /** Checking that if any hashing index is null, if it is null then we skip to next
             *  node (this because that if we land on a null index we will be facing a null pointer exception). */
           if(n == null) {
                continue;
            }

           /** If the next node is null, which means if there is only one node, we go ahead and print the value of that
            *  node. *We can skip this statement, it's not necessary, I provided this for the clarity of my code */
           else if(n.nxtNode == null) {
                System.out.println(n.value);
            }

           /** If the next node is not null, which means if there are more than one node in that same index chaining with
            *  each other, then we make a loop to traverse though that linked chain and print them one by one */
           else {
               while(n != null) {
                    System.out.println(n.value);
                    n = n.nxtNode;
               }
           }
        }
    }

    // Search the key value in the array.
    /** Here we are checking that if the value is present in the hashing index(which is converted from the normal array index
     *  according to the given value). If the key value is not present in that hashing index, then it can be present among it's next
     *  chained node. So, we loop through that chained nodes of that hashing index and check every single node till the last node,
     *  if the value is not even present in any of the node, then the value is not found */
    public void search(int val) {

        int hashingIndex = val % arr.length;
        Node currNode = arr[hashingIndex];

        while(currNode != null) {

            if(currNode.value == val) {
                System.out.println("Value found - " + currNode.value );
                return;
            }

            else {
                currNode = currNode.nxtNode;
            }
        }

        System.out.println("Value not found");
    }


    public static void main(String[] args) {

        HashChaining hashChaining = new HashChaining(5);

        hashChaining.add(2);
        hashChaining.add(32);
        hashChaining.add(33);
        hashChaining.add(62);
        hashChaining.add(5);

        hashChaining.search(5);

        hashChaining.printAll();

    }
}
