package com.qa.hw2;

import java.util.Arrays;

/**
 * Created by Dmytro on 27.09.2016.
 */
public class Task2_9 {
    public static int getAverageValue(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum / (array.length * array.length);
    }

    public static boolean containsZeroElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void copy(int[][] sourceArray, int[] destArray, int index) {
        for (int i = 0; i < destArray.length; i++) {
            sourceArray[i][index] = destArray[i];
        }
    }

    public static int[] getArrayFromColumn(int[][] array, int index) {
        int[] resultArray = new int[array[index].length];

        for (int i = 0; i < array[index].length; i++) {
            resultArray[i] = array[i][index];
        }
        return resultArray;
    }

    public static int[][] getArrayCopy(int[][] array) {
        int[][] arrayCopy = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, arrayCopy[i], 0, array[i].length);
        }
        return arrayCopy;
    }

    public static void rotate90(int[][] array) {
        int[][] tempArray = new int[array.length][array[0].length];

        int k = 0;
        for (int j = array.length - 1; j >= 0; j--) {
            int t = 0;
            for (int i = 0; i < array[j].length; i++) {
                tempArray[k][t++] = array[i][j];
             }
            k++;
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.arraycopy(tempArray[i], 0 , array[i], 0, tempArray.length);
        }
    }

    public static void rotate180(int[][] array) {
        for (int i = 0; i < 2; i++) {
            Task2_9.rotate90(array);
        }
    }

    public static void rotate270(int[][] array) {
        for (int i = 0; i < 3; i++) {
            Task2_9.rotate90(array);
        }
    }

    /*public static void arr(int[][] array) {
        int[][] tempArray = new int[array.length][array.length];

        int k = 0;
        int rowCount = array.length;
        for (int i = 0; i < array.length; i++) {
            if (!Task2_9.containsZeroElements(array[i])) {
                rowCount--;
                System.arraycopy(array[i], 0, tempArray[k++], 0, array.length);
            }
        }

        int columnCount = array.length;
        for (int i = 0; i < array.length; i++) {
            if (!Task2_9.containsZeroElements(getArrayFromColumn(array, i))) {
                columnCount--;
                continue;
            }
        }
    }*/

    public static void subtractAverageValue(int[][] array) {
        int averageValue = Task2_9.getAverageValue(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] -= averageValue;
            }
        }
    }

    public static void swap(int[] array, int index) {
        for (int j = index + 1; j < array.length; j++) {
            int temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
        }
    }

    public static void moveZeroValueToEnd(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int zeroCount = 0;
            for (int j = 0; j < array[0].length - 1 - zeroCount; j++) {
                if(array[i][j] == 0) {
                    Task2_9.swap(array[i], j);
                    j--;
                    zeroCount++;
                }
            }
        }
    }

    public static void sortArrayRow(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            Arrays.sort(array[i]);
        }
    }

    public static void sortArrayColumn(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] tempArray = Task2_9.getArrayFromColumn(array, i);
            Arrays.sort(tempArray);
            Task2_9.copy(array, tempArray, i);
        }
    }

    public static void cycleShiftUp(int[][] array, int shiftIndex) {
        int realShift = shiftIndex % array.length;
        int[][] tempArray = new int[realShift][array[0].length];

        for (int i = 0; i < realShift; i++) {
            System.arraycopy(array[i], 0, tempArray[i], 0, array[i].length);
        }

        for (int i = 0; i < array.length - realShift; i++) {
            System.arraycopy(array[i + realShift], 0, array[i], 0, array[i].length);
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.arraycopy(tempArray[i], 0, array[array.length - realShift + i], 0, tempArray[i].length);
        }
    }

    public static void cycleShiftDown(int[][] array, int shiftIndex) {
        int realShift = shiftIndex % array.length;
        int[][] tempArray = new int[realShift][array[0].length];

        int j = 0;
        for (int i = array.length - realShift; i < array.length; i++) {
            System.arraycopy(array[i], 0, tempArray[j++], 0, array[i].length);
        }

        j = array.length - 1;
        for (int i = array.length - 1 - realShift; i >= 0; i--) {
            System.arraycopy(array[i], 0, array[j--], 0, array[i].length);
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.arraycopy(tempArray[i], 0, array[i], 0, tempArray[i].length);
        }
    }

    public static void cycleShiftRight(int[][] array, int shiftIndex) {
        int realShift = shiftIndex % array.length;
        int[][] tempArray = new int[array[0].length][realShift];

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(Arrays.copyOfRange(array[i], array[i].length - realShift, array[i].length), 0, tempArray[i], 0, tempArray[i].length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1 - realShift; j >= 0; j--) {
                array[i][j + realShift] = array[i][j];
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.arraycopy(tempArray[i], 0, array[i], 0, tempArray[i].length);
        }
    }

    public static void cycleShiftLeft(int[][] array, int shiftIndex) {
        int realShift = shiftIndex % array.length;
        int[][] tempArray = new int[array[0].length][realShift];

        for (int i = 0; i < array.length; i++) {
            System.arraycopy(Arrays.copyOfRange(array[i], 0, realShift), 0, tempArray[i], 0, tempArray[i].length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = realShift; j < array.length; j++) {
                array[i][j - realShift] = array[i][j];
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.arraycopy(tempArray[i], 0, array[i], array[i].length - realShift, tempArray[i].length);
        }
    }

    public static int[][] compressArray(int[][] array) {
        int[][] tempArray = new int[array.length][array[0].length];

        int newRowCount = 0;
        int newColumnCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (!Task2_9.containsZeroElements(array[i])) {
                System.arraycopy(array[i], 0, tempArray[newRowCount], 0, array[i].length);
                newRowCount++;
            }
        }

        for (int i = 0; i < tempArray[0].length; i++) {
            int[] columnArray = Task2_9.getArrayFromColumn(tempArray, i);
            if (!Task2_9.containsZeroElements(columnArray)) {
                Task2_9.copy(tempArray, columnArray, newColumnCount);
                newColumnCount++;
            }
        }

        int[][] resultArray = new int[newRowCount][newColumnCount];
        for (int i = 0; i < resultArray.length; i++) {
            System.arraycopy(tempArray[i], 0, resultArray[i], 0, resultArray[i].length);
        }
        return resultArray;
    }

    public static int getRangeSum(int[] array, int firstElemIndex, int secondElemIndex) {
        int sum = 0;

        if (secondElemIndex - firstElemIndex == 1) {
            return sum;
        }

        for (int i = firstElemIndex + 1; i < secondElemIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int getSumm(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int firstElemIndex = -1;
            int secondElemIndex = -1;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    if (firstElemIndex == -1) {
                        firstElemIndex = j;
                        continue;
                    }
                    if (secondElemIndex == -1 && firstElemIndex != -1) {
                        secondElemIndex = j;
                    }
                }
            }
            if (firstElemIndex != -1 || secondElemIndex != -1) {
                sum += getRangeSum(array[i], firstElemIndex, secondElemIndex);
            }
        }
        return sum;
    }

    public static int[] getOneDimensionArray(int[][] array) {
        int[] resultArray = new int[array.length * array[0].length];

        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                resultArray[k++] = array[i][j];
            }
        }
        return resultArray;
    }

    public static int getAscendingLineCount(int[][] array) {
        int[] resultArray = Task2_9.getOneDimensionArray(array);

        int currentCount = 1;
        int resultCount = 1;
        for (int i = 1; i < resultArray.length; i++) {
            if (resultArray[i] > resultArray[i - 1]) {
                currentCount++;
            } else {
                if (resultCount < currentCount) {
                    resultCount = currentCount;
                }
                currentCount = 1;
            }
        }

        if (resultCount < currentCount) {
            resultCount = currentCount;
        }
        return resultCount != 1 ? resultCount : 0;
    }

    public static int getDescendingLineCount(int[][] array) {
        int[] resultArray = Task2_9.getOneDimensionArray(array);

        int currentCount = 1;
        int resultCount = 1;
        for (int i = 1; i < resultArray.length; i++) {
            if (resultArray[i] < resultArray[i - 1]) {
                currentCount++;
            } else {
                if (resultCount < currentCount) {
                    resultCount = currentCount;
                }
                currentCount = 1;
            }
        }

        if (resultCount < currentCount) {
            resultCount = currentCount;
        }
        return resultCount != 1 ? resultCount : 0;
    }

    public static int[][] getRandomValues(int n) {
        int minValue = -n;
        int maxValue = n;
        int[][] resultArray = new int[n][n];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                resultArray[i][j] = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        //9.Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n
        // с помощью датчика случайных чисел.
        int[][] array = Task2_9.getRandomValues(4);
        Task2_8.printArray(array);


        //9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.
        int[][] arrayCopy = Task2_9.getArrayCopy(array);

        for (int i = 0; i < arrayCopy.length; i++) {
            Arrays.sort(arrayCopy[i]);
        }

        System.out.println("\nСтроки матрицы в порядке возрастания значений:");
        Task2_8.printArray(arrayCopy);

        arrayCopy = Task2_9.getArrayCopy(array);
        for (int i = 0; i < arrayCopy.length; i++) {
            int[] columnArray = Task2_9.getArrayFromColumn(arrayCopy, i);
            Arrays.sort(columnArray);
            Task2_9.copy(arrayCopy, columnArray, i);
        }

        System.out.println("\nСтолбцы матрицы в порядке возрастания значений:");
        Task2_8.printArray(arrayCopy);

        //9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо(влево, вверх, вниз).
        int k = 1;
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.cycleShiftRight(arrayCopy, k);
        System.out.println("\nРезультат циклического сдвига матрицы на " +  k + " позиций вправое:");
        Task2_8.printArray(arrayCopy);

        k = 2;
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.cycleShiftLeft(arrayCopy, k);
        System.out.println("\nРезультат циклического сдвига матрицы на " + k + " позиций влево:");
        Task2_8.printArray(arrayCopy);

        k = 3;
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.cycleShiftUp(arrayCopy, k);
        System.out.println("\nРезультат циклического сдвига матрицы на " + k + " позиций вверх:");
        Task2_8.printArray(arrayCopy);

        k = 1;
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.cycleShiftDown(arrayCopy, k);
        System.out.println("\nРезультат циклического сдвига матрицы на " + k + " позиций вниз:");
        Task2_8.printArray(arrayCopy);

        //9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
        arrayCopy = Task2_9.getArrayCopy(array);
        System.out.println("\nНаибольшее число возрастающих элементов матрицы, идущих подряд: " + Task2_9.getAscendingLineCount(arrayCopy));

        arrayCopy = Task2_9.getArrayCopy(array);
        System.out.println("\nНаибольшее число убывающих элементов матрицы, идущих подряд: " + Task2_9.getDescendingLineCount(arrayCopy));

        //9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
        arrayCopy = Task2_9.getArrayCopy(array);
        System.out.println("\nСумма элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки: " + Task2_9.getSumm(arrayCopy));

        //9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.rotate90(arrayCopy);
        System.out.println("\nПоворот матрицы на 90 градусов:");
        Task2_8.printArray(arrayCopy);

        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.rotate180(arrayCopy);
        System.out.println("\nПоворот матрицы на 180 градусов:");
        Task2_8.printArray(arrayCopy);

        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.rotate270(arrayCopy);
        System.out.println("\nПоворот матрицы на 270 градусов:");
        Task2_8.printArray(arrayCopy);

        //9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.subtractAverageValue(arrayCopy);
        System.out.println("\nРезультат вычитая из элементов каждой строки матрицы ее среднее арифметическое:");
        Task2_8.printArray(arrayCopy);

        //9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.compressArray(arrayCopy);
        System.out.println("\nУплотнение матрицы:");
        Task2_8.printArray(arrayCopy);

        //9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.
        arrayCopy = Task2_9.getArrayCopy(array);
        Task2_9.moveZeroValueToEnd(arrayCopy);
        System.out.println("\nРезультат преобразования строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных:");
        Task2_8.printArray(arrayCopy);
    }
}
