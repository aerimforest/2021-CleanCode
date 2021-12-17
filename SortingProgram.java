import java.util.Scanner;

public class SortingProgram {
    private int[] inputNumbers;
    private int arraySize = 0;
    private String selectedSortingAlgorithm = "";
    public static void main(String[] args) {
        SortingProgram sortingProgram = new SortingProgram();
        int menu = 0;

        while(menu != 3) {
            menu = sortingProgram.inputMenu();
            sortingProgram.runProgramWithSelectedMenu(menu);
        }
    }
    
    public int inputMenu() {
        Scanner scan = new Scanner(System.in);
        printMenu();
        return scan.nextInt();
    }

    public void printMenu() {
        System.out.println("\n[ ID: 1810448 ]");
        System.out.println("[ Name: 김예림 ]\n");
        System.out.println("1. Select a sorting algorithm");
        System.out.println("2. Sort numbers");
        System.out.println("3. Quit");
    }

    public void runProgramWithSelectedMenu(int menu) { 
        if(menu == 1) {
            selectedSortingAlgorithm = selectSortingAlgorithm();
        }   
        else if(menu == 2) {
            sortAndPrintNumbers(selectedSortingAlgorithm);
        }  
        else {
            return;
        }
    }

    public String selectSortingAlgorithm() {
        printSortingAlgorithmMenu();

        Scanner scan = new Scanner(System.in);
        int sortingAlgorithmMenu = scan.nextInt();

        if(sortingAlgorithmMenu == 1) {
            return "bubbleSort";
        }
        else if(sortingAlgorithmMenu == 2) {
            return "quickSort";
        }
        else {
            return "insertionSort";
        }
    }

    public void printSortingAlgorithmMenu() {
        System.out.println("\nSelect a sorting algorithm");
        System.out.println("1. Bubble sort");
        System.out.println("2. Quicksort");
        System.out.println("3. Insertion sort");
    }

    public void sortAndPrintNumbers(String selectedSortingAlgorithm) {
        int[] sortedNumbers = new int[arraySize];
        char selectedSortingType;
        Sort sort = new Sort();

        inputArraySize();
        inputArray();
        selectedSortingType = inputSortingType();

        if(selectedSortingType == 'a') {
            sort.asc = 1;
        }
        else if(selectedSortingType == 'd') {
            sort.asc = -1;
        }
       
        if(selectedSortingAlgorithm == "bubbleSort") {
            sortedNumbers = sort.sortWithBubbleSort(inputNumbers);
        }
        else if(selectedSortingAlgorithm == "quickSort") {
            sortedNumbers = sort.sortWithQuickSort(inputNumbers, 0, arraySize - 1);
        }
        else if(selectedSortingAlgorithm == "insertionSort") {
            sortedNumbers = sort.sortWithInsertionSort(inputNumbers);
        }
        
        printArray(sortedNumbers);
    }

    public void inputArraySize() {
        System.out.print("\nThe number of numbers: ");
        Scanner scan = new Scanner(System.in);
        arraySize = scan.nextInt();
    }

    public void inputArray() {
        Scanner scan = new Scanner(System.in);
        inputNumbers = new int[arraySize];
        System.out.print("Numbers: ");

        for(int i = 0; i < arraySize; i++) {
            inputNumbers[i] = scan.nextInt();
        }
    }

    public char inputSortingType() {
        char selectedSortingType;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Ascending or descending (a or d): ");
        selectedSortingType = scan.next().charAt(0);

        return selectedSortingType;
    }

    public void printArray(int[] sortedNumbers) {
        System.out.print("Result: ");

        for(int i = 0; i < sortedNumbers.length; i++) {
            System.out.print(sortedNumbers[i] + " ");
        }

        System.out.println();
    }
}

class Sort {
    public int asc = 1;

    public void swap(int[] inputNumbers, int i, int j) {
        int temp = inputNumbers[i];
        inputNumbers[i] = inputNumbers[j];
        inputNumbers[j] = temp;
    }
    
    public int[] sortWithBubbleSort(int[] inputNumbers) {
        int n = inputNumbers.length;

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(asc * (Integer.compare(inputNumbers[j], inputNumbers[j+1])) > 0) {
                    swap(inputNumbers, j, j+1);
                }
            }
        }

        return inputNumbers;
    }

    public int[] sortWithQuickSort(int[] inputNumbers, int low, int high) {
        if(low < high) {
            int newBoundary = makePartition(inputNumbers, low, high);
            
            sortWithQuickSort(inputNumbers, low, newBoundary - 1);
            sortWithQuickSort(inputNumbers, newBoundary + 1, high);
        }

        return inputNumbers;
    }

    public int makePartition(int[] inputNumbers, int low, int high) {
        int left = low;
		int right = high;
		int pivot = inputNumbers[right];		
		
		while(left < right) {
			while(asc * (Integer.compare(inputNumbers[left], pivot)) < 0 && left < right) {
				left++;
			}
			
			while(asc * (Integer.compare(inputNumbers[right], pivot)) >= 0 && left < right) {
				right--;
			}

			swap(inputNumbers, left, right);
		}
		swap(inputNumbers, high, right);
		
		return right;
    }

    public int[] sortWithInsertionSort(int[] inputNumbers) {
        for(int index = 1; index < inputNumbers.length; index++) {
            int temp = inputNumbers[index];
            int aux = index - 1;
      
            while((aux >= 0) && asc * (Integer.compare(inputNumbers[aux], temp)) > 0) {
                inputNumbers[aux+1] = inputNumbers[aux];
                aux--;
            }
            inputNumbers[aux + 1] = temp;
        }

        return inputNumbers;
    }
}