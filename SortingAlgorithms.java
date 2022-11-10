/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author khaznahalhajri
 */
// Analysis and Comparison of Sorting Algorithms (Insertion, Merge, and Heap) Using Java.
// Students Names:  Khaznah Alhajri, Wala Alsinan, Sahar Almuhaishi, Fatimah Al-hmood, Narjis Al-Jumaia
// Supervised by: Dr. Azza Ahmed Ali

import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("********** Enter # of Array Sizes to be Tested: **********");
        int size = sc.nextInt();

        int[] inputSizes = new int[size];
        System.out.println("******************** Enter the Sizes: ******************** ");
        for(int i=0; i<size; i++)
        {
// reading array elements from the user
            inputSizes[i]=sc.nextInt();
        }
        System.out.println("****** All Sorting Algorithms Will be Printed at Once *****");
        System.out.println("*************** Wait for the Results Please ***************");
        System.out.println("  ");
//      int[] inputSizes = {1000, 2000, 10000, 20000, 50000, 100000, 150000, 200000};

            String insertionResult = Insertion(inputSizes);
            String mergeResult = Merge(inputSizes);
            String HeapResult = Heap(inputSizes);

            System.out.println(insertionResult + "\n\n");
            System.out.println(mergeResult + "\n\n");
            System.out.println(HeapResult + "\n\n");

    }

    static int[] randomNum(int dataSize) {
        int[] numbers = new int[dataSize];
        Random rand = new Random();

        for (int i = 0; i < dataSize; i++) {
            numbers[i] = (rand.nextInt(dataSize * 10) + 1);
        }

        return numbers;
    }

    private static void reverseArray(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static String Insertion(int[] inputSizes) {

        String insertionWorst = "********** Worst Insertion ********** \n";


        String insertionAvr = "********** Average Insertion ********** \n";


        String insertionBest = "**********  Best Insertion  ********** \n";

        InsertionSort.sort(inputSizes);

        for (int inputSize : inputSizes) {
            int count = 8;
            long execTimeWorst = 0;
            long execTimeAvg = 0;
            long execTimeBest = 0;
            int[] randNumbers;

            randNumbers = randomNum(inputSize);

            int[] randNumbersAvg = randNumbers.clone();
            reverseArray(randNumbers);

            while (count > 0) {
                // W
                long startTimeWorst = System.nanoTime();
                InsertionSort.sort(randNumbers);
                long endTimeWorst = System.nanoTime();
                execTimeWorst += (endTimeWorst - startTimeWorst);

                // A
                long startTimeAvg = System.nanoTime();
                InsertionSort.sort(randNumbersAvg);
                long endTimeAvg = System.nanoTime();

                execTimeAvg += (endTimeAvg - startTimeAvg);

                // B
                long startTimeBest = System.nanoTime();
                InsertionSort.sort(randNumbers);
                long endTimeBest = System.nanoTime();

                execTimeBest += (endTimeBest - startTimeBest);

                count--;
            }

            insertionWorst = insertionWorst.concat(execTimeWorst + "\n");
            insertionAvr = insertionAvr.concat(execTimeAvg + "\n");
            insertionBest = insertionBest.concat(execTimeBest + "\n");

        }

        return insertionWorst + "\n\n" + insertionAvr + "\n\n" + insertionBest;
    }

    public static String Merge(int[] inputSizes) {

        String mergeWorst = "********** Worst Merge ********** \n";


        String mergeAvr = "********** Average Merge ********** \n";


        String mergeBest = "********** Best Merge ********** \n";

        MergeSort.sort(inputSizes, 0, inputSizes.length - 1);

        for (int inputSize : inputSizes) {
            int count = 8;

            long execTimeWorst = 0;
            long execTimeAvg = 0;
            long execTimeBest = 0;

            int[] randNumbers = randomNum(inputSize);
            int[] randNumbersAvg = randNumbers.clone();

            while (count > 0) {
                //W
                long startTimeWorst = System.nanoTime();
                MergeSort.sort(randNumbers, 0, randNumbers.length - 1);
                long endTimeWorst = System.nanoTime();

                execTimeWorst += (endTimeWorst - startTimeWorst);

                //A
                long startTimeAvg = System.nanoTime();
                MergeSort.sort(randNumbersAvg, 0, randNumbersAvg.length - 1);
                long endTimeAvg = System.nanoTime();

                execTimeAvg += (endTimeAvg - startTimeAvg);

                //B
                long startTimeBest = System.nanoTime();
                MergeSort.sort(randNumbers, 0, randNumbers.length - 1);
                long endTimeBest = System.nanoTime();

                execTimeBest += (endTimeBest - startTimeBest);

                count--;
            }

            mergeWorst = mergeWorst.concat(execTimeWorst + "\n");
            mergeAvr = mergeAvr.concat(execTimeAvg + "\n");
            mergeBest = mergeBest.concat(execTimeBest + "\n");
        }

        return mergeWorst + "\n\n" + mergeAvr + "\n\n" + mergeBest;
    }

    public static String Heap(int[] inputSizes) {
        String HeapWorst = "********** Worst Heap ********** \n";


        String HeapAvr = "********** Average Heap ********** \n";


        String HeapBest = "********** Best Heap ********** \n";


        HeapSort.sort(inputSizes, inputSizes.length - 1);

        for (int inputSize : inputSizes) {

            int count = 8;

            long execTimeWorst = 0;
            long execTimeAvg = 0;
            long execTimeBest = 0;


            int[] randNumbers = randomNum(inputSize);
            int[] randNumbersAvg = randNumbers.clone();


            while (count > 0) {

                //W
                long startTimeWorst = System.nanoTime();
                HeapSort.sort(randNumbers, randNumbers.length - 1);
                long endTimeWorst = System.nanoTime();

                execTimeWorst += (endTimeWorst - startTimeWorst);

                //A
                long startTimeAvg = System.nanoTime();
                HeapSort.sort(randNumbersAvg, randNumbersAvg.length - 1);
                long endTimeAvg = System.nanoTime();

                execTimeAvg += (endTimeAvg - startTimeAvg);

                //B
                long startTimeBest = System.nanoTime();
                HeapSort.sort(randNumbers, randNumbers.length - 1);
                long endTimeBest = System.nanoTime();

                execTimeBest += (endTimeBest - startTimeBest);

                count--;

            }


            HeapWorst = HeapWorst.concat(execTimeWorst + "\n");
            HeapAvr = HeapAvr.concat(execTimeAvg + "\n");
            HeapBest = HeapBest.concat(execTimeBest + "\n");

        }
        return HeapWorst + "\n\n" + HeapAvr + "\n\n" + HeapBest;
    }


// Sorting Algorithms Classes


// Insertion
    public class InsertionSort {
    	public static void sort(int arr[]) {
    		int arrLen = arr.length;

    		for (int i = 1; i < arrLen; ++i) {
    			int key = arr[i];
    			int j = i - 1;

    			while(j >= 0 && arr[j] > key) {
    				arr[j + 1] = arr[j];
    				j -= 1;
    			}
    			arr[j + 1] = key;
    		}
    	}
    }



// Merge

public class MergeSort {
	public static void merge(int arr[], int l, int m, int r) {
		int leftSize = m - l + 1;
		int rightSize = r - m;

		int leftArray[] = new int[leftSize];
		int rightArray[] = new int[rightSize];

		for (int i = 0; i < leftSize; ++i) {
			leftArray[i] = arr[l + i];
		}
		for (int j = 0; j < rightSize; ++j) {
			rightArray[j] = arr[m + 1 + j];
		}

		int firstIndex = 0, secondIndex = 0;

		int k = l;

		while (firstIndex < leftSize && secondIndex < rightSize) {
			if (leftArray[firstIndex] <= rightArray[secondIndex]) {
				arr[k] = leftArray[firstIndex];
				firstIndex++;
			} else {
				arr[k] = rightArray[secondIndex];
				secondIndex++;
			}

			k++;
		}

		while (firstIndex < leftSize) {
			arr[k] = leftArray[firstIndex];
			firstIndex++;
			k++;
		}

		while (secondIndex < rightSize) {
			arr[k] = rightArray[secondIndex];
			secondIndex++;
			k++;
		}
	}

// Recursion in Merge

	public static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}
}


// Heap Sort

public class HeapSort {

    public static void sort(int[] A, int n) {
        int i;
        for(i = n / 2 - 1; i >= 0; --i) {
            HeapSort.heapify(A, n, i);
        }

        for(i = n - 1; i >= 0; --i) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            HeapSort.heapify(A, i, 0);
        }

    }

   public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[i]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            HeapSort.heapify(arr, n, largest);
        }
    }
}
}
