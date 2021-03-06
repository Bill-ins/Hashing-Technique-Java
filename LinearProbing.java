import java.util.Scanner;
public class LinearProbing {

    /** It is a type of hashing technique in which we create the hashing index of the key (key % size of the array) then,
     * we go ahead and add our data to that hashing index if it is empty. But if there is a collision or that index is not
     * empty, then we check it's next available empty index (key % size of the array + i; where the 'i' will be increment by 1)
     * and add our data to that index; if that next index is also not empty then we check it's second next index and so on
     * by going through loop until we find an empty available index, and as well as until it's the last index of the array
     * which means the array is already full
     *
     * For example - suppose we have values {56, 23, 54, 7, 22, 42, 32, 9, 19} to add to an array of size 10. First we
     * convert every key values to hashing index according to the array size. [key % size of the array] then we add them to the array :-
     *
     * Adding 56 to array index of '6'
     *
     * Adding 23 to array index of '3'
     *
     * Adding 54 to array index of '4'
     *
     * Adding 7 to array index of '7'
     *
     * Adding 22 to array index of '2'
     *
     * Adding 42 to array index of '3' *As the hashing index of 42 (which is 2) is already occupied so search for it's next
     *                                  available index by a loop then we add the data into that available index which '3'
     *
     * Adding 32 to array index of '4' *As the hashing index of 32 (which is 2) is already occupied so search for it's next
     *                                  available index by a loop then we add the data into that available index which '4'
     *
     * Adding 9 to array index of '9'
     *
     * Adding 19 to array index of '0' *Here comes a little twist. We can see that the key value 19, should be added to
     *                                  index number '9', after getting the hashing index number, and the index '9' is not
     *                                  empty, so as per the linear probing rule it should be added to it's next available
     *                                  index (which can be done by running loop). But, the thing is that there is no more indices
     *                                  after '9' as it the last and maximum index of the array (size 10), and there are some
     *                                  spaces left in the array to be used. So to utilize those empty indices in the array we use
     *                                  the concept of circular queue here, where we can circulate the array. In simple words
     *                                  we can traverse through the array in circular way (in which after landing on last array index
     *                                  we can revolve or return to the first index, and that makes the whole array circular in
     *                                  nature). So, coming to our problem, as we stuck on last index and there is no further indices after,
     *                                  now what we will do is that, we have to return to the first index again and check empty index from there.
     *
     * */

    Scanner sc = new Scanner(System.in);
    int arr[];

    // Constructor for Array Size
    LinearProbing(int size) {
         arr = new int[size];
    }

    // Adding element to the hashing index of the given value
    public void add(int val) {

        int hashingIndx = val % arr.length; // Creating hashing index

        /** By the formula :- arr[(hashingIndx + i) % arr.length], we can return back to first index of the array and start checking the
         *  empty index from there. If the given initial hashing index is greater than or equal to 1 then the loop will run in circular way
         *  from given initial hashing index to it's previous index; else if it is 0 (first index) it will normally run from first to last index;
         *  which means the loop will usually traverse till array length-1 in both cases and the formula will also work in both cases */

        /** Here we are using the 'i' variable to get the next empty index from the current hashing index by loop */

        for(int i = 0; i < arr.length; i++) {

            if(arr[(hashingIndx + i) % arr.length] == 0) {

                arr[(hashingIndx + i) % arr.length] = val;
                return; // After adding the value we return from the loop
            }
        }

        /** If the loop traversing is done and still didn't find any empty index then it means the loop is full */
        System.out.println("Array is full");

    }

    // Searching the element from hashing index of the given value
    /** Here we first generating a hashing index number according to the passed value. Then, we are checking if that key value
     * is available in that index or not; if it is not available in that index then it should be in it's next indies */
    public void search(int val) {

        int hashingIndx = val % arr.length;
        int i = 0;

        /** Here we are also checking (arr[(hashingIndx + i) % arr.length] != 0) because if our value is not available in
         * that group or cluster which is the next indices of the hashing index then it is not in that list, i.e; if somehow
         * we found an empty index while searching to the group of next indices of hashing index then that item is not found
         * and we immediately terminate our loop */

        while(i < arr.length && (arr[(hashingIndx + i) % arr.length] != 0)) {

            if(arr[(hashingIndx + i) % arr.length] == val) {

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

        LinearProbing hashing = new LinearProbing(5);

        hashing.add(89);
        hashing.add(98);
        hashing.add(57);

        hashing.search(89);

        hashing.printAll();

    }
}
