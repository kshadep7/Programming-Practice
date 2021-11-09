// Java Program to rearrange numbers in an Array
// such that no two numbers are adjacent

import java.util.*;

// Comparator class to sort in descending order
class KeyComparator implements Comparator<Key>
{

	// Overriding compare()method of Comparator
	public int compare(Key k1, Key k2)
	{
		if (k1.freq < k2.freq)
			return 1;
		else if (k1.freq > k2.freq)
			return -1;
		return 0;
	}
}

// Object of num and its freq
class Key
{
	int freq; // store frequency of character
	int num;
	Key(int freq, int num)
	{
		this.freq = freq;
		this.num = num;
	}
}

public class Amazon
{

	// Function to rearrange numbers in array such
	// that no two adjacent numbers are same
	static boolean rearrangeArray(int[] arr)
	{
		int n = arr.length;

		// Store frequencies of all elements
		// of the array
		// jsut in case we nneed more sapce
		//track visited
	//	asuuming thre are 10000 unique values in aarr
		// we can usee arraylist which is dyna
//		List<Integer> count = new ArrayList<>();
//		List<Integer> visited  = new ArrayList<>();
		// but that  can be considered as contant space as it is fixed size of arr
		// ask is three is any contraint regarding
		//gice me  a momennt
		//so instaed of using array  list we will stick to array of size Integeer.MAX_Valuee
		// // saay i had an idea of using count as array of that that might ssolve the probleem
		// even if it using extra space but it will constatn sapce as it is fixed sixe
		// do you mind if go by the approach
		int[] count = new int[Integer.MAX_VALUE];
		int visited[] = new int[Integer.MAX_VALUE];
	// counting freq
		// ok we know we are dealing with integers and the max value is Integeer.MAX_Value as size of count arr
		//thos wonnt work say it
		// ok for
		// the idea was to incrament teh count of number  in arr and count will be incraemned at  number's index in count arr
//		we can use a hashmap to count freq
		//

		// but again m thiking how use the freq in max heap

		// lets use hashmmap for now

//		HashMap<Integer, Integer> count  = new HashMap<>();
		for (int i = 0; i < n; i++) {
//			count.get(i)
			count[arr[i]]++;
//			if(count.containsKey(arr[i])){
//				// incramnt the count here
//				// so idea is if we find key already in map we will ncraatme count
//				// ok wait its simple
//				// if present in map we will inc count
//				// if not then juts add to map
//				count.put(arr[i], count.get(arr[i])+1);
//				// say i was confused if sued getorDefault
//			}else {
//				count.put(arr[i], 1);
//			}
			//so now we have freqs in a map

		}

		// Insert all characters with their frequencies
		// into a priority_queue
		// we need a pri que
		// wee need a camparator
		// so we will sorting based on each entry of map wheere values of campared
		// nnot sorting map
		// let me think of lambda eexpression
		PriorityQueue<Key> pq
				= new PriorityQueue<>((a,b) -> b.freq - a.freq);
		// htining of crating a class Key which have atrritbues
		// so this will heap as max heap meaning  nnumbeer with hightst freq will be at the top
		// we will key object with  high feq

		// say this
		// there is one issue here
		// how do we keep track of if curr num is visited or not
		// Adding high freq elements in descending order
		// ok we can do by getting keyseet of map as those are unuque values in arr
		// so we can create an array visited of that size

//		int[] visited = new int[count.size()];
		// so u r saying this is not needed?
		// ok sso let consider eg 1
		// how our map look
		//1: 3
		//2: 3
		// i think we will need visisted as we want to know if

		// the next step would be
		// so lets say we used nummber in resutl arr so we dont have to use that again for the adj num
		// []
		for (int i = 0; i < n; i++)
		{
			int val = arr[i];
			// explain this is why we neede visited
			if (count[val] > 0 && visited[val] != 1)
				pq.add(new Key(count[val], val));
			visited[val] = 1;
		}

		// 'result[]' that will store resultant value
		int result[] = new int[n];

		// work as the previous visited element
		// initial previous element will be ( '-1' and
		// it's frequency will also be '-1' )
		// this is just for checking if our number has freq is greater than zero
		Key prev = new Key(-1, -1);

		// Traverse queue
		int l = 0;
		while (pq.size() != 0)
		{
			// pop top element from queue and add it
			// to result
			// just read comment and write
			Key k = pq.peek();
			pq.poll();
			result[l] = k.num;

			// so basically
			// If frequency of previous element is less
			// than zero that means it is useless, we
			// need not to push it
			if (prev.freq > 0)
				pq.add(prev);

			// make current element as the previous
			// decrease frequency by 'one'
			(k.freq)--;
			prev = k;
			l++;
		}

		// If length of the resultant array and original
		// array is not same then the array is not valid
		// here we know if we need to retuen true of false
		// we need to chane retuen typr pf method to boolean
		if (l != result.length)
		{
			System.out.println(" Not valid Array ");
			return false;
		}
		// Otherwise Print the result array
		else
		{
			System.out.println(Arrays.toString(result));
			return true;
//			for (int i : result)
//			{
//				System.out.print(i + " ");
//			}
		}
	}

	// sapce can be 0(1)
	//log n -> heap
	// as inserting in heap it take logn camparisons
	//team how many people ?
	// curretnly challenges wokring on
	// so we are checking if vaid rray frist
	// Driver Code
	public static void main(String args[])
	{
		int arr[] = new int[] { 1, 1, 1, 1, 2, 2, 3, 3 };

		rearrangeArray(arr);
	}
}

