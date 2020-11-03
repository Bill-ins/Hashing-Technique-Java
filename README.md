# Hashing-Technique-Java


Hashing is a type of algorithm as well as structure in which we set our data by providing a specific key number and add that data in an array to the index that matches with the given specific key. It can reduce the searcing time without even sorting, to the constant Big(O) notation
which is O(1).

Example :- Creating an array of size 10 and we have to add values - 6, 8, 9, 2, 4, 3. So we go ahead and those values to our array with the matching index numbers :-

* Adding 6 in the array index of 6
* Adding 8 in the array index of 8
* Adding 9 in the array index of 9
* Adding 2 in the array index of 2
* Adding 4 in the array index of 4
* Adding 3 in the array index of 3
 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
 
But there is a problem we have to face while applying this technique. 

Suppose you have only 2 datas with the key number of 256 and 789. What will you do ? Don't tell me that you going to make one huge sized array with size of 789 (which is the larger of those two number) and add them according to their indices. So, we are wasting a lot of memory for only two datas in sake of less time. 

Does it really make sense ? Then some researchers came up with a some technique with optimized solution :- 

1. Hash Chaining
2. Hashing by linear probing
3. Hashing by quadratic probing

But, I just mentioned only three of those that are common, but there may be a lot of those . 

I have also provided documentation comment in my own words for explaining the concept
