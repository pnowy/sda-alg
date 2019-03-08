package pl.sda.programming.day2to5.sorting;

public class Solutions_Sorting implements Tasks_Sorting {

    @Override
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    @Override
    public void selectionSort(int[] array) {
        int sortedIndex = 0;
        for (int j = 0; j < array.length; j++) {
            int minIndex = sortedIndex;
            for (int i = sortedIndex + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(sortedIndex, minIndex, array);
            sortedIndex++;
        }
    }

    @Override
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int movedValue = array[i];
            int destination = i;
            for (int j = i-1; j >= 0; j--) {
                if(movedValue < array[j]) {
                    moveRight(array, j);
                    destination = j;
                } else {
                    break;
                }
            }
            array[destination] = movedValue;
        }
    }

    @Override
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length);
    }

    private void quickSort(int[] array, int lo, int hi) {
        if(hi - lo < 1) {
            return;
        }
        int pivotIndex = lo;
        int storeIndex = pivotIndex + 1;
        for (int i = pivotIndex + 1; i < hi; i++) {
            int pivotValue = array[pivotIndex];
            int currentCheckValue = array[i];
            if(currentCheckValue < pivotValue) {
                swap(i, storeIndex, array);
                storeIndex++;
            }
        }
        swap(pivotIndex, storeIndex - 1, array);
        quickSort(array, lo, storeIndex - 1);
        quickSort(array, storeIndex, hi);
    }

    private void moveRight(int[] array, int j) {
        array[j+1] = array[j];
    }


    public void bubbleSort_optimized(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    private void swap(int j, int i, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private void mergeSort(int[] array, int lo, int count) {
        if(count <= 1) {
            return;
        }
        int countLeft = count / 2;
        int countRight = count % 2 == 1 ? countLeft + 1 : countLeft;
        mergeSort(array, lo, countLeft);
        mergeSort(array, lo + count / 2, countRight);
        merge(array, lo, countLeft, lo + count / 2, countRight);
    }

    private static void merge(int[] array, int left, int countLeft, int right, int countRight) {
        int[] arrayClone = array.clone();
        int leftIndex = left;
        int rightIndex = right;
        int takenFromLeft = 0;
        int takenFromRight = 0;
        for (int i = left; i < left + countLeft + countRight; i++) {
            if(takenFromLeft < countLeft && takenFromRight < countRight) {
                if(arrayClone[leftIndex] <= arrayClone[rightIndex]) {
                    array[i] = arrayClone[leftIndex];
                    leftIndex++;
                    takenFromLeft++;
                } else {
                    array[i] = arrayClone[rightIndex];
                    rightIndex++;
                    takenFromRight++;
                }
            } else if (takenFromLeft < countLeft) {
                array[i] = arrayClone[leftIndex];
                leftIndex++;
                takenFromLeft++;
            } else {
                array[i] = arrayClone[rightIndex];
                rightIndex++;
                takenFromRight++;
            }
        }
    }

}
