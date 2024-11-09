import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFunctions {

    //функция заполняет массив введёнными значениями
//    public void manualInput(ArrayList<Integer> array, int sizeOfArray){
//
//        Scanner scan = new Scanner(System.in);
//        String userInput = "";
//        String temporaryNumber = "";
//        Integer userNumber = 0;
//
//        userInput = scan.nextLine();
//
//        for(int i = 0; i < sizeOfArray; i++){
//            if(userInput.charAt(i) != ' ' || userInput.charAt(i) != ',') {
//                temporaryNumber += userInput.charAt(i);
//            }else{
//                try {
//                    userNumber = parseInt(temporaryNumber);
//                }
//            }
//
//        }
//    }


    //функция заполняет массив рандомными значениями
    public int fillingArrayRandomValues(ArrayList<Integer> array, int sizeOfArray) {

        VerificationFunctions checkNumber = new VerificationFunctions();

        System.out.printf("\nВведите размер массива: ");
        //ввод и проверка размера массива
        do {
            sizeOfArray = checkNumber.getNumber();

            if (sizeOfArray > 0)
                break;

            System.out.printf("\nРазмер массива обязательно должен быть больше 0!\n" +
                    "Повторите попытку: ");
        }while(true);

        //заполнение массива рандомными числами
        for(int i = 0; i < sizeOfArray; i++){
            array.add((int)(Math.random() * 100));
        }

        return sizeOfArray;
    }

    //функция заполняет массив данными из файла
    public int inputFromFile(ArrayList<Integer> array) throws FileNotFoundException {
        //блок в зависимости от ОС выбирает разделитель
        //String separator = File.separator;

        //основные объекты
        Scanner scan = new Scanner(System.in);
        int[] userData = new int[0];
        OutputFunctions warning = new OutputFunctions();
        VerificationFunctions check = new VerificationFunctions();

        //основные переменные
        int sizeOfArray = 0;
        boolean dataIsBad = true;
        int userChoice = -1;
        String pathToFile = "";

        //вывод инструкции
        warning.messageInputFromFile();

        //цикл позволяющий вводить новый путь для файла
        do {
            System.out.printf("Введите путь до файла: ");

            //ввод пути до файла и попытка его открыть
            while (true) {
                pathToFile = scan.nextLine();

                if (VerificationFunctions.fileExists(pathToFile)) {
                    break;
                }

                System.out.printf("Файла с путём: \"" + pathToFile + "\" не найдено!\n" +
                        "Пожалуйста введите новый путь: ");
            }

            //цикл позволяющий несколько раз проверять данные одного файла
            do {
                //проверка данных в файле
                if (VerificationFunctions.badData(pathToFile, userData)) {
                    //очистка массива
                    for (int i = 0; i < userData.length; i++) {
                        userData[i] = 0;
                    }

                    //вывод меню и выбор пользователя
                    warning.selectionWithIncorrectData();
                    do {
                        userChoice = scan.nextInt();
                    } while (userChoice != 1 && userChoice != 2 && userChoice != 3);

                    //если пользователь захотел воспользоваться другим способом ввода данных
                    if(userChoice == 3)
                        return -1;

                    //чистим путь до файла и отправляем на провторный ввод
                    if(userChoice == 2)
                        pathToFile = "";
                }else {
                    //если данные в порядке -> пропускаем
                    userChoice = 4;
                }
            }while(userChoice == 1);
        }while(userChoice == 2);

        //циклом заполняем наш массив считанным данными
        for (int i = 0; i < userData.length; i++) {
            array.add(i, userData[i]);
        }

        sizeOfArray = userData.length;

        scan.close();

        return sizeOfArray;
    }

}
