package proj01;

import java.util.ArrayList;

public class ArrayHandler {

    public static class Sorter {
        /**
         * sorting function that implements quicksort*
         *
         * @param unsorted unsorted array
         */
        public static <String extends Comparable<String>> void sort(ArrayList<Actor> unsorted) {
            quickSort(unsorted, 0, unsorted.size() - 1);
        }

        /**
         * Recursively quick sorting the array by randomPartitioning*
         *
         * @param unsorted unsorted array
         * @param left     left boundary
         * @param right    right boundary
         */
        private static <String extends Comparable<String>> void quickSort(ArrayList<Actor> unsorted, int left, int right) {
            if (left < right) {
                int piv = randomPartition(unsorted, left, right);
                quickSort(unsorted, left, piv - 1);
                quickSort(unsorted, piv, right);
            }
        }

        /**
         * random partitioning with Math.random() function to generate a random index *
         * *
         *
         * @param unsorted unsorted array
         * @param left     left pointer
         * @param right    right pointer
         * @return perform sorting and return the index of pivot
         */
        private static <String extends Comparable<String>> int randomPartition(ArrayList<Actor> unsorted, int left, int right) {
            int randomIndex = left + (int) (Math.random() * (right - left + 1));
            swap(unsorted, randomIndex, right);
            return partition(unsorted, left, right);
        }

        /**
         * Helper function to swap the elements in the array *
         *
         * @param arr given array
         * @param i   index i
         * @param j   index j
         * @param <Actor> data type T
         */
        private static <Actor> void swap(ArrayList<Actor> arr, int i, int j) {
            Actor temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        /**
         * partition function for quick sort *
         *
         * @param arr   array to be sorted
         * @param left  left boundary
         * @param right right boundary
         * @return pivot index
         */
        private static <String extends Comparable<String>> int partition(ArrayList<Actor> arr, int left, int right) {
            Actor pivot = arr.get(left + right >> 1); // -> the element in the middle, not the pivot index

            //When comparing generic data from the array, use the compareTo() function instead of equality operators
            //compareTo return a boolean value, and boolean can also represent by -1, 0, 1

            while (left <= right) {
                //1. keep checking left element in the array if is less than pivot, update the left boundary
                while (pivot.get_name().compareTo(arr.get(left).get_name()) < 0) {
                    left++;
                }
                //2. keep checking pivot if is less than the right element in the array, update the right boundary
                while (pivot.get_name().compareTo(arr.get(right).get_name()) > 0) {
                    right--;
                }
                //3. check left with right -> what should be the if-condition?
                //then swap elements and update both boundary
                if (left <= right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }
            return left;
        }
    }

    public class Searcher {

        public static int actor(ArrayList<Actor> actors, String target) {
            //TODO: Implement
            // create left and right indices
            target = target.toLowerCase();
            int left = 0;
            int right = actors.size() - 1;
            // while left and right are on their respective sides or overlapped:
            while (left <= right) {
                // this is pretty self-explanatory.
                // do the binary dance, check one side, check the other, enter, rinse, repeat.
                int midpoint = (right + left) / 2;
                String curr_actor = actors.get(midpoint).get_name().toLowerCase();
                //System.out.println(curr_actor + " " + target);

                if (curr_actor.equals(target)) {
                    return midpoint;
                }
                else if (curr_actor.compareTo(target) < 0) {
                    right = midpoint - 1;
                }
                else if (curr_actor.compareTo(target) > 0) {
                    left = midpoint + 1;
                }
            }
            // if target is not present, display its prospective index
            return left;

        }
    }
}
