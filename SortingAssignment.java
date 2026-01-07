/*
Main.java
Searching and Sorting culminating Activity
Sudhanya Golla
Created July 12th, 2024
Last Modified July 12th, 2024
*/

// Java setup
import java.util.*;

class SortingAssignment {
	static Scanner in = new Scanner(System.in);
	static Random rand = new Random();

	// Create global variables to be incremented within methods
	// Variables for Quick Sort
	static int recursionCount = 0;
	static int compareSo = 0;
	static int loopSo = 0;
	static int swapSo = 0;
	
	// Variables for Merge Sort
	static int recursionCountMerge = 0;
	static int compareMe = 0;
	static int loopMe = 0;
	static int swapMe = 0;

	// Main program
	public static void main(String[] args) throws InterruptedException {

		int numNumbers = 0;
		boolean validNum = false;

		System.out.println("Welcome to the Sorting Algorithm.\nHow many numbers do you want to display?\n");
		
		// Make sure number inputted is eventually valid
		while (validNum == false)
		{
			// Prompt user for the amount of numbers they want to sort
			System.out.println("(1) for 10, (2) for 100, (3) for 1,000, (4) for 5,000, (5) for 10,000");
			int input = in.nextInt();
		
			// Validate user input
			if (input >= 1 && input <= 5)
			{
				validNum = true;

				// Set amount of numbers to be ordered in array based on user input
				if (input == 1)
				{
					numNumbers = 10;
				}
				else if (input == 2)
				{
					numNumbers = 100;
				}
				else if (input == 3)
				{
					numNumbers = 1000;
				}
				else if (input == 4)
				{
					numNumbers = 5000;
				}
				else if (input == 5)
				{
					numNumbers = 10000;
				}
				
			}
			else
			{
				System.out.println("Input a valid number");
			}
		}

		// Duplicate arrays to avoid any lost actions from other sorting algorithms
		int[]numbers = new int[numNumbers];
		int[]numbersSorted = new int[numNumbers];
		int[]numbersSorted2 = new int[numNumbers];
		int[]numbersSorted3 = new int[numNumbers];
		int[]numbersSorted4 = new int[numNumbers];
		int[]numbersSorted5 = new int[numNumbers];
		boolean validLetter = false;
		
		// Make sure inputted letter is eventually valid
		// Validate letter inputted by user
		while (validLetter == false)
		{
			// Prompt user how to sort numbers
			System.out.println("\nDo you want the numbers to be in (a) ascending or (d) descending manner?");
			in.nextLine();
			String input2 = in.nextLine().toLowerCase();

			// Sort numbers in ascending order
			if (input2.equals("a"))
			{
				validLetter = true;

				// Generate and print out unsorted numbers
				generateRandomNumbers(numbers, numbersSorted, numbersSorted2, numbersSorted3, numbersSorted4, numbersSorted5);
				System.out.println("\nNumbers unsorted: ");
				printNumbers(numbers);
				System.out.println("");
				
				// Sort using each sorting algorithm
				System.out.println("");
				insertionPass(numbersSorted);
				System.out.println("");
				selectionSort(numbersSorted2);
				System.out.println("");
				bubbleSort(numbersSorted3);
				System.out.println("");
				
				long startMerge = 0;
				long finishMerge = 0;
				long elapsedMerge = 0;
	
				// Sort using merge sort
				// Record time it takes
				startMerge = System.nanoTime();
				int count = mergeSort(numbersSorted4, 0, numbersSorted4.length - 1);
			    finishMerge = System.nanoTime();
			    elapsedMerge = finishMerge - startMerge;
	
				// Output how many swaps, comparisons, recusions, and time the sort took
				System.out.println("It took " + swapMe + " swaps, " + loopMe + " loops, and " + compareMe + " comparisons using merge code.");
			    System.out.println("Recursion done " + count + " times.");
				System.out.println("The sort took " + elapsedMerge + " nanoseconds.\n");
	
				// Function call
				long startQuick = 0;
				long finishQuick = 0;
				long elapsedQuick = 0;
	
				// Record time it takes and sort array using quick sort (out-of-school algorithm)
				startQuick = System.nanoTime();
		        int recursion = quickSort(numbersSorted5, 0, numbersSorted5.length - 1);
				finishQuick = System.nanoTime();
				elapsedQuick = finishQuick - startQuick;
	
				// Output how many swaps, comparisons, recusions, and time the sort took
				System.out.println("It took " + swapSo + " swaps, " + loopSo + " loops, and " + compareSo + " comparisons using quick sort.");
				System.out.println("Recursion done " + recursion + " times.");
				System.out.println("The sort took " + elapsedQuick + " nanoseconds.");
	
				// Output numbers sorted in ascending order
				System.out.println("\nNumbers sorted in ascending order: ");
				printNumbers(numbersSorted);
				
			}
	
			// Sort numbers in ascending order
			else if (input2.equals("d"))
			{
				validLetter = true;

				// Generate and print out unsorted numbers
				generateRandomNumbers(numbers, numbersSorted, numbersSorted2, numbersSorted3, numbersSorted4, numbersSorted5);
				System.out.println("\nNumbers unsorted: ");
				printNumbers(numbers);
				
				// Sort using the reverse method of each sorting algorithm
				System.out.println("\n");
				insertionPassReverse(numbersSorted);
				System.out.println("");
				selectionSortReverse(numbersSorted2);
				System.out.println("");
				bubbleSortReverse(numbersSorted3);
				System.out.println("");
	
				long startMerge = 0;
				long finishMerge = 0;
				long elapsedMerge = 0;
	
				// Sort and record time it takes to complete the sort
				startMerge = System.nanoTime();
				int count = mergeSortReverse(numbersSorted4, 0, numbersSorted4.length - 1);
				finishMerge = System.nanoTime();
			    elapsedMerge = finishMerge - startMerge;
	
				// Output how many swaps, comparisons, recusions, and time the sort took
				System.out.println("It took " + swapMe + " swaps, " + loopMe + " loops, and " + compareMe + " comparisons using merge code (reversed).");
			    System.out.println("Recursion done " + count + " times.");
				System.out.println("The sort took " + elapsedMerge + " nanoseconds.\n");
	
				long startQuick = 0;
				long finishQuick = 0;
				long elapsedQuick = 0;
	
				// Track time and sort array using quick sort
				startQuick = System.nanoTime();
		        int recursion = quickSortReversed(numbersSorted5, 0, numbersSorted5.length - 1);
				finishQuick = System.nanoTime();
				elapsedQuick = finishQuick - startQuick;
	
				// Output how many swaps, comparisons, recusions, and time the sort took
				System.out.println("It took " + swapSo + " swaps, " + loopSo + " loops, and " + compareSo + " comparisons using quick sort (reversed)");
				System.out.println("Recursion done " + recursion + " times.");
				System.out.println("The sort took " + elapsedQuick + " nanoseconds.");
	
				// Output all numbers sorted in descending order
				System.out.println("\nNumbers sorted in descending order: ");
				printNumbers(numbersSorted);
			}
			else
			{
				System.out.println("Input a proper letter (have to input letter twice now)");
			}
		}

	}
	
	// All subprograms
	// Print numbers in an array
	public static void printNumbers(int[]list)
	{
		for (int numbers = 0; numbers < list.length; numbers++)
		{
			System.out.print(list[numbers] + " ");
		}
	}

	// Generate randomized numbers as per user request
	// Copy values to each array such that no actions done by each sort will not be lost by a previous algorithm
	public static void generateRandomNumbers(int[] numbers, int[] numbersSorted, int[] numbersSorted2, int[] numbersSorted3, int[] numbersSorted4, int[] numbersSorted5)
	{
		// Randomize values for each element in array
		for (int index = 0; index < numbers.length; index++)
		{
			int randNum = rand.nextInt(10001);
			numbers[index] = randNum;
			numbersSorted[index] = randNum;
			numbersSorted2[index] = randNum;
			numbersSorted3[index] = randNum;
			numbersSorted4[index] = randNum;
			numbersSorted5[index] = randNum;
		}
	}
	
	// Sort integers using insertion sort in ascending order
	public static void insertionPass(int[]numbersSorted)
	{
		int compareIn = 0;
		int loopIn = 0;
		int swapIn = 0;
		long startIn = 0;
		long finishIn = 0;
		long elapsedIn = 0;
		startIn = System.nanoTime();
		
		// Store temporary item
		// Keep track of all actions done
		for (int top = 1; top < numbersSorted.length; top++)
		{ 
			int item = numbersSorted[top]; 
			int i = top; 
			loopIn++;
			
			// Shift larger items to the right by one
			// Prepare to check the next item to the left
			while (i > 0 && item < numbersSorted[i-1])
			{ 
				numbersSorted[i] = numbersSorted[i-1];
				i--;
				compareIn++;
				loopIn++;
			}

			// Put sorted item in open location
			numbersSorted[i] = item;
			swapIn++;
		}

		// Record time
		finishIn = System.nanoTime();
		elapsedIn = finishIn - startIn;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using insertion sort, there are " + loopIn + " loops, " + compareIn + " comparisons, and " + swapIn + " swaps.");
		System.out.println("The entire sort took " + elapsedIn + " nanoseconds.");
		
	}

	// Sort integers using insertion sort in descending order
	public static void insertionPassReverse(int[]numbersSorted)
	{
		int compareIn = 0;
		int loopIn = 0;
		int swapIn = 0;
		long startIn = 0;
		long finishIn = 0;
		long elapsedIn = 0;
		startIn = System.nanoTime();
		
		// Store temporary item
		// Keep track of all actions done
		for (int top = 1; top < numbersSorted.length; top++)
		{ 
			int item = numbersSorted[top]; 
			int i = top; 
			loopIn++;
			
			// Shift smaller items to the right by one
			// Prepare to check the next item to the left
			while (i > 0 && item > numbersSorted[i-1])
			{ 
				numbersSorted[i] = numbersSorted[i-1];
				i--;
				compareIn++;
				loopIn++;
			}

			// Put sorted item in open location
			numbersSorted[i] = item;
			swapIn++;
		}

		// Record time taken for the algorithm to execute
		finishIn = System.nanoTime();
		elapsedIn = finishIn - startIn;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using insertion sort (reversed), there are " + loopIn + " loops, " + compareIn + " comparisons, and " + swapIn + " swaps.");
		System.out.println("The entire sort took " + elapsedIn + " nanoseconds.");
		
	}
	
	// Sort array using selection sort in ascending order
	public static void selectionSort(int[]numbersSorted)
	{
		int compareSe = 0;
		int loopSe = 0;
		int swapSe = 0;
		long startSe = 0;
		long finishSe = 0;
		long elapsedSe = 0;
	    startSe = System.nanoTime();
		
		// Assume largest element is names[0]
		// Keep track of all actions done
		for (int top = numbersSorted.length - 1; top > 0; top--)
		{ 
			int largeLoc = 0;
			loopSe++;
			
			// Make sure all elements are compared to
			for (int i = 0; i <= top; i++)
			{
				// Determine whether adjacent element is larger
				if (numbersSorted[i] > numbersSorted[largeLoc])
				{ 
					largeLoc = i;
					compareSe++;
				}

				loopSe++;
			} 

			//temporary storage for the item last looked at
			int temp = numbersSorted[top]; 
			numbersSorted[top] = numbersSorted[largeLoc]; 
			numbersSorted[largeLoc] = temp;
			swapSe++;
		}

		// Record time taken for the algorithm to execute
		finishSe = System.nanoTime();
	    elapsedSe = finishSe-startSe;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using selection sort, there are " + loopSe + " loops, " + compareSe + " comparisons, and " + swapSe + " swaps.");
		System.out.println("The sort took " + elapsedSe + " nanoseconds.");
	}

	// Sort array using selection sort in descending order
	public static void selectionSortReverse(int[]numbersSorted)
	{
		int compareSe = 0;
		int loopSe = 0;
		int swapSe = 0;
		long startSe = 0;
		long finishSe = 0;
		long elapsedSe = 0;
	    startSe = System.nanoTime();
		
		// Assume largest element is names[0]
		// Keep track of all actions done
		for (int top = numbersSorted.length - 1; top > 0; top--)
		{ 
			int largeLoc = 0;
			loopSe++;
			
			// Make sure all elements are compared to
			for (int i = 0; i <= top; i++)
			{
				// Determine whether adjacent element is smaller
				if (numbersSorted[i] < numbersSorted[largeLoc])
				{ 
					largeLoc = i;
					compareSe++;
				}

				loopSe++;
			} 

			// Temporary storage for the item last looked at
			int temp = numbersSorted[top]; 
			numbersSorted[top] = numbersSorted[largeLoc]; 
			numbersSorted[largeLoc] = temp;
			swapSe++;
		}

		// Record time taken for algorithm to execute
		finishSe = System.nanoTime();
	    elapsedSe = finishSe-startSe;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using selection sort (reversed), there are " + loopSe + " loops, " + compareSe + " comparisons, and " + swapSe + " swaps.");
		System.out.println("The sort took " + elapsedSe + " nanoseconds.");
		
	}
	
	// Sort an array using bubble sort in ascending order
	public static void bubbleSort(int[]numbersSorted)
	{
		int compareBu = 0;
		int loopBu = 0;
		int swapBu = 0;
		boolean sorted = false;
		long startBu = 0;
		long finishBu = 0;
		long elapsedBu = 0;
	    startBu = System.nanoTime();

		// Keep on reducing size of array being examined after each pass
		// Keep track of all actions done
		for (int top = numbersSorted.length - 1; top > 0 && sorted == false; top--)
		{
			sorted = true;
			loopBu++;

			// Check every single adjacent item
			for (int i = 0; i < top; i++)
			{ 
				loopBu++;
				
				// Check if previous item is greater in comparison to next item
				// If so, swap both items
				if (numbersSorted[i] > numbersSorted[i+1])
				{ 
					compareBu++;
					sorted = false; 
					int temp = numbersSorted[i]; 
					numbersSorted[i] = numbersSorted[i+1]; 
					numbersSorted[i+1] = temp;
					swapBu++;
				}
			} 
		}

		// Record time taken
		finishBu = System.nanoTime();
	    elapsedBu = finishBu-startBu;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using bubble sort, there are " + loopBu + " loops, " + compareBu + " comparisons, and " + swapBu + " swaps.");
		System.out.println("The sort took " + elapsedBu + " nanoseconds.");
		
	}

	// Sort an array using bubble sort in descending order
	public static void bubbleSortReverse(int[]numbersSorted)
	{
		int compareBu = 0;
		int loopBu = 0;
		int swapBu = 0;
		boolean sorted = false;
		long startBu = 0;
		long finishBu = 0;
		long elapsedBu = 0;
	    startBu = System.nanoTime();

		// Keep on reducing size of array being examined after each pass
		// Keep track of all actions done
		for (int top = numbersSorted.length - 1; top > 0 && sorted == false; top--)
		{
			sorted = true;
			loopBu++;

			// Check every single adjacent item
			for (int i = 0; i < top; i++)
			{ 
				loopBu++;
				
				// Check if previous item is smaller in comparison to next item
				// If so, swap both items
				if (numbersSorted[i] < numbersSorted[i+1])
				{ 
					compareBu++;
					sorted = false; 
					int temp = numbersSorted[i]; 
					numbersSorted[i] = numbersSorted[i+1]; 
					numbersSorted[i+1] = temp;
					swapBu++;
				}
			} 
		}

		// Record time
		finishBu = System.nanoTime();
	    elapsedBu = finishBu-startBu;

		// Output number of actions taken and time taken by the algorithm
		System.out.println("Using bubble sort, there are " + loopBu + " loops, " + compareBu + " comparisons, and " + swapBu + " swaps (reversed).");
		System.out.println("The sort took " + elapsedBu + " nanoseconds.");
		
	}
	
	// Sort array using merge sort in ascending order
	public static void merge(int [] numbersSorted, int start, int mid, int end)
	{		
		// Split array into left and right parts
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2]; 
	
		/*Copy data to temp arrays*/
		// Keep track of all actions done
		for (int i=0; i<n1; ++i)
		{
			L[i] = numbersSorted[start + i];
			loopMe++;
		}
		
		for (int j=0; j<n2; ++j) 
		{
			R[j] = numbersSorted[mid + 1+ j];
			loopMe++;
		}
		
		/* Merge and compare values the temp arrays */
		int i = 0, j = 0;   
		int k = start;
		
		while (i < n1 && j < n2)
		{ 
			if (L[i] <= R[j])
			{ 
				numbersSorted[k] = L[i]; 
				i++;
				k++;
				compareMe++;
				swapMe++;
			} 
			else
			{ 
				numbersSorted[k] = R[j]; 
				j++;
				k++;
				compareMe++;
				swapMe++;
			}
			
			loopMe++;
		}
		
		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{ 
			numbersSorted[k] = L[i]; 
			i++; 
			k++;
			swapMe++;
			loopMe++;
		}
		
		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{ 
			numbersSorted[k] = R[j]; 
			j++; 
			k++; 
			swapMe++;
			loopMe++;
		}	
	}
	
	// Sort using a recursive merge sort in ascending order
	public static int mergeSort(int [] numbersSorted, int start, int end)
	{
		
		if (start < end)
		{
			int mid = (start + end) / 2;

			// Sort using merge sort
			// Keep track of all recursions done
			mergeSort(numbersSorted, start, mid);
			mergeSort(numbersSorted, mid+1, end);
			merge(numbersSorted, start, mid, end);
			recursionCountMerge += 2;
			
		}
		
		return recursionCountMerge;
	}
	
	// Sort using a recursive merge sort in descending order
	public static int mergeSortReverse(int [] numbersSorted, int start, int end)
	{		
		if (start < end)
		{
			int mid = (start + end) / 2;

			// Sort using merge sort
			// Keep track of all recursions done
			mergeSortReverse(numbersSorted, start, mid);
			mergeSortReverse(numbersSorted, mid+1, end);
			mergeReverse(numbersSorted, start, mid, end);
			recursionCountMerge += 2;
			
		}
		
		return recursionCountMerge;
	}
	
	// Sort array using merge sort in descending order
	public static void mergeReverse(int [] numbersSorted, int start, int mid, int end)
	{		
		// Split array into left and right parts
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2]; 
	
		/*Copy data to temp arrays*/
		// Keep track of all actions done
		for (int i=0; i<n1; ++i)
		{
			L[i] = numbersSorted[start + i];
			loopMe++;
		}
		
		for (int j=0; j<n2; ++j) 
		{
			R[j] = numbersSorted[mid + 1+ j];
			loopMe++;
		}
		
		/* Merge and compare values the temp arrays */
		int i = 0, j = 0;   
		int k = start;
		
		while (i < n1 && j < n2)
		{ 
			if (L[i] >= R[j])
			{ 
				numbersSorted[k] = L[i]; 
				i++;
				k++;
				compareMe++;
				swapMe++;
			} 
			else
			{ 
				numbersSorted[k] = R[j]; 
				j++;
				k++;
				compareMe++;
				swapMe++;
			}
			
			loopMe++;
		}
		
		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{ 
			numbersSorted[k] = L[i]; 
			i++; 
			k++;
			swapMe++;
			loopMe++;
		}
		
		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{ 
			numbersSorted[k] = R[j]; 
			j++; 
			k++; 
			swapMe++;
			loopMe++;
		}		
	}

	// Quicksort algorithm
	// A utility function to swap two elements
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	// Takes pivotal element and places elements with respect to it
    public static int partition(int[] arr, int low, int high)
    {		
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
		// Keep track of all actions done
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
			
			loopSo++;
			
            // If current element is smaller than the pivot, place to its left
            if (arr[j] < pivot) {
				compareSo++;
				
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
				swapSo++;
            }
        }
		
        swap(arr, i + 1, high);
		swapSo++;
		
        return (i + 1);
    }
	
	// The main function that implements QuickSort
    public static int quickSort(int[] arr, int low, int high)
    {	
		
        if (low < high) {
            int pi = partition(arr, low, high);

            // Separately sort elements before partition and after partition
			// Keep track of all recursions done
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
			recursionCount += 2;
        }
		return recursionCount;
    }

	// The main function that implements QuickSort
    public static int quickSortReversed(int[] arr, int low, int high)
    {	
		
        if (low < high) {

            // pi is partitioning index, arr[p]
            int pi = partitionReverse(arr, low, high);

            // Separately sort elements before partition and after partition
            quickSortReversed(arr, low, pi - 1);
            quickSortReversed(arr, pi + 1, high);
			recursionCount += 2;
        }
		return recursionCount;
    }

	// Quicksort algorithm
	// A utility function to swap two elements
    public static void swapReverse(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	// Takes pivotal element and places elements with respect to it
    public static int partitionReverse(int[] arr, int low, int high)
    {		
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
			loopSo++;
			
            // If current element is larger than the pivot, place on its left
            if (arr[j] > pivot) {
				compareSo++;
				
                // Increment index of larger element
                i++;
                swapReverse(arr, i, j);
				swapSo++;
            }
        }

		// Swap elements
        swapReverse(arr, i + 1, high);
		swapSo++;
		
        return (i + 1);
    }
	
}
