package proj01;

import java.util.ArrayList;

public class ArrayHandler {

    public class Sorter {
        /**
         * helper function converts a string to a Character[] array *
         *
         * @param str string to convert
         * @return a Character array
         */
        private static Character[] stringToCharacterArray(String str) {
            return str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        }

        /**
         * sorting function that implements quicksort*
         *
         * @param unsorted unsorted array
         * @param <T>      Generic data type (Integer, String, Character)...
         */
        public static <T extends Comparable<T>> void sort(T[] unsorted) {
            quickSort(unsorted, 0, unsorted.length - 1);
        }

        /**
         * Recursively quick sorting the array by randomPartitioning*
         *
         * @param unsorted unsorted array
         * @param left     left boundary
         * @param right    right boundary
         * @param <T>      data type T
         */
        private static <T extends Comparable<T>> void quickSort(T[] unsorted, int left, int right) {
            if (left < right) {
                int piv = randomPartition(unsorted, left, right);
                quickSort(unsorted, left, piv - 1);
                quickSort(unsorted, piv + 1, right);
            }
        }

        /**
         * random partitioning with Math.random() function to generate a random index *
         * *
         *
         * @param unsorted unsorted array
         * @param left     left pointer
         * @param right    right pointer
         * @param <T>      data type T
         * @return perform sorting and return the index of pivot
         */
        private static <T extends Comparable<T>> int randomPartition(T[] unsorted, int left, int right) {
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
         * @param <T> data type T
         */
        private static <T> void swap(T[] arr, int i, int j) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        /**
         * partition function for quick sort *
         *
         * @param arr   array to be sorted
         * @param left  left boundary
         * @param right right boundary
         * @param <T>   generic data type T
         * @return pivot index
         */
        private static <T extends Comparable<T>> int partition(T[] arr, int left, int right) {
            T pivot = arr[left + right >> 1]; // -> the element in the middle, not the pivot index

            //When comparing generic data from the array, use the compareTo() function instead of equality operators
            //compareTo return a boolean value, and boolean can also represent by -1, 0, 1

            while (left <= right) {
                //1. keep checking left element in the array if is less than pivot, update the left boundary
                while (pivot.compareTo(arr[left]) > 0) {
                    left++;
                }
                //2. keep checking pivot if is less than the right element in the array, update the right boundary
                while (pivot.compareTo(arr[right]) < 0) {
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
        public Movie movie (ArrayList<Movie> movies) {
            //TODO: Implement
            return null;

        }

        public Actor actor (ArrayList<Actor> actors) {
            //TODO: Implement
            return null;

        }
    }
}
