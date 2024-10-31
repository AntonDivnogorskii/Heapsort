import java.util.ArrayList;

public class HeapSort {

    // Реализация пирамидальной сортировки на Java
    public ArrayList<Integer> sort(ArrayList<Integer> array, int sizeOfArray) {

        // Построение кучи (перегруппируем массив)
        for (int i = sizeOfArray / 2 - 1; i >= 0; i--)
            heapify(array, sizeOfArray, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = sizeOfArray - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
        return array;
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
    // индексом в sortingArray
    void heapify(ArrayList<Integer> sortingArray, int sizeOfArray, int index) {

        int largest = index; // Инициализируем наибольший элемент как корень
        int left = 2 * index + 1; // левый = 2*i + 1
        int right = 2 * index + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (left < sizeOfArray && sortingArray.get(left) > sortingArray.get(largest))
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < sizeOfArray && sortingArray.get(right) > sortingArray.get(largest))
            largest = right;

        // Если самый большой элемент не корень
        if (largest != index) {
            int swap = sortingArray.get(index);
            sortingArray.set(index, sortingArray.get(largest));
            sortingArray.set(largest, swap);

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(sortingArray, sizeOfArray, largest);
        }
    }
}
