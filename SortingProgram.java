import java.util.Scanner;

public class SortingProgram {

    private int[] inputNumbers;
    private int arraySize = 0;
    private String selectedSortingAlgorithm;
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
        System.out.println("2. Sort numbers in ascending order");
        System.out.println("3. Quit");
    }

    public void runProgramWithSelectedMenu(int menu) {
        switch(menu) {
            case 1:
                selectSortingAlgorithm();
                break;
            case 2:
                sortNumbersInAscendingOrder();
                break;
            case 3:
                break;
        }       
    }

    public void selectSortingAlgorithm() {
        printSortingAlgorithmMenu();

        Scanner scan = new Scanner(System.in);
        int menu = scan.nextInt();

        if(menu == 1) {
            selectedSortingAlgorithm = "bubbleSort";
        }
        else if(menu == 2) {
            selectedSortingAlgorithm = "quickSort";
        }
    }

    public void printSortingAlgorithmMenu() {
        System.out.println("\nSelect a sorting algorithm");
        System.out.println("1. Bubble sort");
        System.out.println("2. Quicksort");
    }

    public void sortNumbersInAscendingOrder() {
        inputArraySize();
        inputArray();

        switch(selectedSortingAlgorithm) {
            case "bubbleSort":
                sortWithBubbleSort();
            case "quickSort":
                sortWithQuickSort(0, arraySize - 1);
        }
        
        printArray(arraySize);
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

    public void sortWithBubbleSort() {
        int n = inputNumbers.length;

        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(inputNumbers[j] > inputNumbers[j+1]) {
                    swap(j, j+1);
                }
            }
        }
    }

    public void swap(int i, int j) {
        int temp = inputNumbers[i];
        inputNumbers[i] = inputNumbers[j];
        inputNumbers[j] = temp;
    }

    public void sortWithQuickSort(int low, int high) {
        if(low < high) {
            int newBoundary = makePartition(low, high);
    
            sortWithQuickSort(low, newBoundary - 1);
            sortWithQuickSort(newBoundary + 1, high);
        }
    }

    public int makePartition(int low, int high) {
        int pivot = inputNumbers[high]; 
        int i = (low - 1); 
    
        for(int j = low; j <= high - 1; j++) {
            if(inputNumbers[j] < pivot) {
                i++; 
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return (i + 1);
    }

    public void printArray(int arraySize) {
        System.out.print("Result: ");

        for(int i = 0; i < arraySize; i++) {
            System.out.print(inputNumbers[i] + " ");
        }

        System.out.println();
    }
}