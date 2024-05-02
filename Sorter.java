import java.util.ArrayList;

public class Sorter {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        // for an arraylist of integer, enter the size of the integer list

        int size = 15;
        ArrayList<Integer> arr = randomAdd(size);
        arr = SecondSorter.sort(arr);
        printArr(arr);

        long end = System.currentTimeMillis();

        long time = end - begin;
        System.out.println();
        System.out.println("Elapsed Time: " + time + " milli seconds");
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        if (arr.size() % 2 == 1) {
            sortOdd(arr);
        } else {
            sortEven(arr);
        }
        return arr;
    }

    public static ArrayList<Integer> sortOdd(ArrayList<Integer> arr) {
        // if evenCounter = 0, we start the checking at index 0 and end at size() - 2;
        int evenCounter = 0;
        int num = 1;

        int counter = 0;

        while (!checkSorted(arr)) {
            for (int i = evenCounter; i < (arr.size() - 1 - num); i += 2) {
                if (arr.get(i) > arr.get(i + 1)) {
                    int tempNum = arr.get(i);
                    arr.set(i, (arr.get(i + 1)));
                    arr.set((i + 1), tempNum);
                }
            }
            if (evenCounter == 0) {
                evenCounter = 1;
                num = 0;

            } else {
                evenCounter = 0;
                num = 1;
            }
            counter++;
            printArr(arr, counter);
        }

        // if (counter >= 10)return arr;
        return arr;
    }

    public static ArrayList<Integer> sortEven(ArrayList<Integer> arr) {
        int counter = 0;

        int evenCounter = 0;

        while (!checkSorted(arr)) {
            for (int i = evenCounter; i < (arr.size() - 1 - evenCounter); i += 2) {
                if (arr.get(i) > arr.get(i + 1)) {
                    int tempNum = arr.get(i);
                    arr.set(i, (arr.get(i + 1)));
                    arr.set((i + 1), tempNum);
                }
            }
            if (evenCounter == 0) {
                evenCounter = 1;

            } else {
                evenCounter = 0;
            }
            counter++;
            printArr(arr, counter);
            // if (counter >= 10)return arr;

        }

        return arr;
    }

    public static boolean checkSorted(ArrayList<Integer> arr) {
        for (int i = 0; i < (arr.size() - 1); i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                // System.out.println("hi");
                return false;
            }
        }
        // System.out.println("hello");
        return true;
    }

    public static ArrayList<Integer> randomAdd(int size) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            double tempRandom = Math.random();
            tempRandom = (tempRandom * 100.0);

            arr.add((int) tempRandom);
        }

        return arr;
    }

    public static void printArr(ArrayList<Integer> arr, int counter) {
        System.out.print(counter + " [");
        for (Integer elem : arr) {
            System.out.print(elem + ", ");
        }
        System.out.println("]");
        return;
    }

    public static void printArr(ArrayList<Integer> arr) {
        System.out.print("end" + " [");
        for (Integer elem : arr) {
            System.out.print(elem + ", ");
        }
        System.out.println("]");
        return;
    }
}