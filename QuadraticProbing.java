import java.util.Scanner;

public class QuadraticProbing {

    /** Quadratic probing is almost similar to the linear probing . But referring to name it will traverse through the next
     * indices of the given hashing index in a quadratic way, which means we were using 'i' for checking the next empty
     * index of the current hashing index by incrementing the 'i' by 1 in linear probing, in here we are going to increment
     * the 'i' in quadratic manner which is i*i or i's square. */

    Scanner sc = new Scanner(System.in);
    int arr[];

    // Constructor for Array Size
    QuadraticProbing(int size) {
        arr = new int[size];
    }

    // Adding element to the hashing index of the given value
    public void add(int val) {

        int hashingIndx = val % arr.length; // Creating hashing index

        for(int i = 0; i < arr.length ; i++) {

            if(arr[(hashingIndx + i*i) % arr.length] == 0) {

                arr[(hashingIndx + i*i) % arr.length] = val;
                return; // After adding the value we return from the loop
            }
        }

        /** If the loop traversing is done and still didn't find any empty index then it means the loop is full */
        System.out.println("Array is full");

    }

    // Searching the element from hashing index of the given value
    public void search(int val) {

        int hashingIndx = val % arr.length;
        int i = 0;

        /** Here we are checking (arr[(hashingIndx + i) % arr.length] != 0) because if our value is not available in
         * that group of quadratic sequence which is the next quadratic sequence of indices of the hashing index, then it is not in that list, i.e; if somehow
         * we found an empty index while searching to the group of next quadratic sequence of indices of hashing index then that item is not found
         * and we immediately stop our loop */

        while(i < arr.length && (arr[(hashingIndx + i*i) % arr.length] != 0)) {

            if(arr[(hashingIndx + i*i) % arr.length] == val) {

                System.out.println("Value Found ..... " + val);
                return;

            } else {
                i++;
            }
        }

        System.out.println("Value Not Found !");

    }

    // Printing all elements in the array
    public void printAll() {

        for (int n: arr) {
            System.out.println(n);
        }

    }


    public static void main(String[] args) {

        QuadraticProbing hashing = new QuadraticProbing(5);

        hashing.add(2);
        hashing.add(22);
        hashing.add(32);

        hashing.search(67);

    }
}
