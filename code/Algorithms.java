public class Algorithms {
    private int comparisons;
    private int qtdAlgorithms = 6;
    private String[] algorithms = {"Bubble Sort:", "Selection Sort:", "Insertion Sort:", "Merge Sort:", "Quick Sort:", "Count Sort:"};


    private int getComparisons() {
        return comparisons;
    }

    public String[] getAlgorithms() {
        return this.algorithms;
    }

    public int getQtdAlgorithms() {
        return qtdAlgorithms;
    }

    private void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }


    private void bubbleSort(int[] array) {
        int size = array.length;
        int temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    setComparisons(getComparisons() + 1);
                }
            }
        }
    }

    private void selectionSort(int[] array) {
        int min, swap;

        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    min = j;
                    setComparisons(getComparisons() + 1);
                }
            }

            swap = array[i];
            array[i] = array[min];
            array[min] = swap;

        }

    }

    private void insertionSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                setComparisons(getComparisons() + 1);
            }
            array[j + 1] = key;
        }
    }

    private void merge(int[] v, int[] esq, int[] dir) {
        int tamanhoEsq = esq.length;
        int tamanhoDir = dir.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < tamanhoEsq && j < tamanhoDir) {
            if (esq[i] <= dir[j]) {
                v[k] = esq[i];
                i++;
            } else {
                v[k] = dir[j];
                j++;
                setComparisons(getComparisons() + 1);
            }
            k++;
        }

        while (i < tamanhoEsq) {
            v[k] = esq[i];
            i++;
            k++;
        }

        while (j < tamanhoDir) {
            v[k] = dir[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] v) {
        int tamanhoV = v.length;

        if (tamanhoV < 2) {
            return;
        }

        int meio = tamanhoV / 2;
        int[] esq = new int[meio];
        int[] dir = new int[tamanhoV - meio];

        for (int i = 0; i < meio; i++) {
            esq[i] = v[i];
        }

        for (int i = meio; i < tamanhoV; i++) {
            dir[i - meio] = v[i];
        }

        mergeSort(esq);
        mergeSort(dir);
        merge(v, esq, dir);
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            } else {
                setComparisons(getComparisons() + 1);
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    private void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int findBig(int[] array) {
        int big = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > big) {
                big = array[i];
            }
        }

        return big;
    }

    private void countSort(int[] array) {
        int big = findBig(array);
        int index;
        int[] arrayAux = new int[big + 1];

        for (int i = 0; i < array.length; i++) {
            arrayAux[array[i]] += 1;
        }
        index = 0;

        for (int i = 0; i < arrayAux.length; i++) {
            while (arrayAux[i] > 0) {
                setComparisons(getComparisons() + 1);
                array[index] = i;
                index++;
                arrayAux[i]--;
            }
        }

    }


    public int makeSort(int n, int[] array) {
        setComparisons(0);

        switch (n) {
            case 0:
                bubbleSort(array);
                break;
            case 1:
                selectionSort(array);
                break;
            case 2:
                insertionSort(array);
                break;
            case 3:
                mergeSort(array);
                break;
            case 4:
                quickSort(array, 0, array.length - 1);
                break;
            case 5:
                countSort(array);
        }

        return getComparisons();
    }

}
