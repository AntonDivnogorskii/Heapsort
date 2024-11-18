package Sorting;

import java.util.ArrayList;

public class MessageFunctions {

    //функция вывода массива
    public void arrayOutput(ArrayList<Integer> array, boolean sortedArray){

        if(sortedArray){
            System.out.print("Отсортированный массив:\n");
        }else{
            System.out.print("\nМассив был заполнен следующими числами:\n");
        }

        System.out.println(array);
    }

    //функция выводящая приветствие
    public void greetingText(){
        System.out.print("""
                *****************************************************************
                * The program was completed by:\t\t\t\t\t\t\t\t\t*
                * \tStudent - Divnogorskii Anton Andreevich\t\t\t\t\t\t*
                * \tGroup - 433\t\t\t\t\t\t\t\t\t\t\t\t\t*
                * \tAbout program - software solution to implement heapsort\t\t*
                *****************************************************************\n""");
    }

    //Функция выводящая меню вариантов заполнения
    public void dataFillingMenu(){
        System.out.print("""
                \n# меню вариантов заполнения массива #
                * manual - заполнить массив с клавиатуры
                * random - заполнить массив рандомными числами
                * file - загрузить данные с файла
                # Выберите способ заполнения массива:\s""");
    }

    //
    public static void inputMessage(){
        System.out.print("""
                
                Чтобы заполнить массив с клавиатуры или загрузить из файла,
                данные должны быть записаны в соответствующем формате!
                *\tНеобходимый формат данных: 1, 2, 3, 4...\t*
                """);
    }

    //
    public static void incorrectData(String number, int index) {
        System.out.print("\nВсе введённые данные должны быть числами!\n" +
                "Элемент \"" + number + "\" под номером: " + (index + 1) + " не был считан!\n");
    }

    public static void messageWithIncorrectData(){
        System.out.print("""
                
                Если вы исправили данные или хотите считать их с другого файла - введите 1
                Если вы хотите воспользоваться другим способом ввода данных - введите любое число отличное от 1
                Выберите пункт меню:\s""");
    }

    public static void dataSaveMessage(){
        System.out.print("""
                
                1 - если хотите сохранить данные в файл
                2 - если хотите сохранить данные в виде графика
                Выберете 1 из пунктов:\s""");
    }

    public static void endMessage(){
        System.out.print("""
                \nВведите:
                # 0 - если хотите завершить работу программы
                # Любое число - если хотите ввести новые данные
                Ваш выбор:\s""");
    }
}
