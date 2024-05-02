import java.util.ArrayList;

public class SecondSorter {
    public static ArrayList<Integer> sort(ArrayList<Integer> arr) {
        ArrayList<Integer> tempArr = new ArrayList<Integer>();

        for (int j = 0; j < arr.size(); j++) {
            int min = arr.get(0);
            int index = 0;

            // find min of array
            for (int i = 0; i < arr.size(); i++) {
                if (min > arr.get(i)) {
                    min = arr.get(i);
                    index = i;
                }
            }
            arr.remove(index);
            tempArr.add(min);
        }
        return tempArr;
    }

    public static boolean checkSorted(ArrayList<Integer> arr) {
        for (int i = 0; i < (arr.size() - 1); i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
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