import java.util.ArrayList;

public class OutputFunctions {

    //функция вывода массива
    public void arrayOutput(ArrayList<Integer> array, boolean sortedArray){

        if(sortedArray){
            System.out.printf("Отсортированный массив:\n");
        }else{
            System.out.printf("\nМассив был заполнен следующими числами:\n");
        }

        System.out.println(array);
        System.out.printf("\n");
    }

    //функция выводящая приветствие
    public void greetingText(){
        System.out.printf("*****************************************************************\n" +
                "* The program was completed by:\t\t\t\t\t\t\t\t\t*\n" +
                "* \tStudent - Divnogorskii Anton Andreevich\t\t\t\t\t\t*\n" +
                "* \tGroup - 433\t\t\t\t\t\t\t\t\t\t\t\t\t*\n" +
                "* \tAbout program - software solution to implement heap sort\t*\n" +
                "*****************************************************************\n\n");
    }

    //Функция выводяща яменю вариантов заполнения
    public void dataFillingMenu(){
        System.out.printf("# меню вариантов заполнения массива #\n" +
                "* 1 - заполнить массив с клавиатуры\n" +
                "* 2 - заполнить массив рандомными числами\n" +
                "* 3 - загрузить данные с файла\n" +
                "# Выбирете способ заполнения массива: ");
    }

    //функция выводящая предупреждающее сообщение
    public void keyboardInputMessage(){
        System.out.printf("\nВнимание, чтобы заполнить массив с клавиатуры\n" +
                "введите числа друг за другом через запятую!\n" +
                "\t\tПРИМЕР: 1, 2, 3, 4...\n");
    }

    public void messageInputFromFile(){
        System.out.println("\nВнимание, чтобы программа считала данные с файла, \n" +
                "они должны быть записаны в соответствующем формате!\n" +
                "\t\tФормат данных: 1, 2, 3, 4...\n");
    }

    public static void incorrectDataInTheFile(String[] numbers, int index) {
        System.out.println("\nВ файле могут лежать только числа!\n" +
                "Элемент \"" + numbers[index] + "\" под номером: " + (index + 1) + " не был считан!\n");
    }

    public static void selectionWithIncorrectData(){
        System.out.println("\nЕсли вы исправили данные в файле и хотите считать их повторно - введите 1\n" +
                "Если вы хотите считать данные с другого файла - введите 2\n" +
                "Если вы хотите воспользоваться другим способом ввода данных - введите 3");
    }
}
