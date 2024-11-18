package Sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFunctions {

    //функция заполняет массив введёнными значениями
    public int manualInput(ArrayList<Integer> array, int sizeOfArray) {

        String userLine = "";
        String[] userNumbers;
        Scanner scan = new Scanner(System.in);
        VerificationFunctions checkInput = new VerificationFunctions();

        //вывод инструкции
        MessageFunctions.inputMessage();

        //пока пользователь не введёт корректные данные
        do {
            //считывание введённых данных
            System.out.print("Введите данные для сортировки: ");
            userLine = scan.nextLine();
            userNumbers = userLine.split(", ");
        }while(checkInput.inputDataBad(userNumbers));

        //заполняем массив считанными данными
        for(int i = 0; i < userNumbers.length; i++){
            array.add(i, Integer.parseInt(userNumbers[i]));
        }

        sizeOfArray = userNumbers.length;

        return sizeOfArray;
    }

    //функция заполняет массив рандомными значениями
    public int fillingArrayRandomValues(ArrayList<Integer> array, int sizeOfArray) {

        VerificationFunctions checkNumber = new VerificationFunctions();

        System.out.print("\nВведите размер массива: ");
        //ввод и проверка размера массива
        do {
            sizeOfArray = checkNumber.getNumber();

            if (sizeOfArray > 0)
                break;

            System.out.print("""
                    
                    Размер массива обязательно должен быть больше 0!
                    Повторите попытку:\s""");
        }while(true);

        //заполнение массива рандомными числами
        for(int i = 0; i < sizeOfArray; i++){
            array.add((int)(Math.random() * 100));
        }

        return sizeOfArray;
    }

    //функция заполняет массив данными из файла
    public int inputFromFile(ArrayList<Integer> array, int sizeOfArray) throws FileNotFoundException {

        //основные объекты
        Scanner scan = new Scanner(System.in);
        Sorting.MessageFunctions warning = new Sorting.MessageFunctions();
        Sorting.VerificationFunctions checkInput = new Sorting.VerificationFunctions();

        //основные переменные
        String pathToFile = "";
        String[] userData;
        int userChoice = -1;

        //вывод инструкции
        warning.inputMessage();

        //цикл позволяет вводить новые файлы сколько угодно
        do {
            //ввод пути до файла
            do {
                System.out.print("\nВведите путь до существующего файла: ");
                pathToFile = scan.nextLine();

                if (checkInput.fileExists(pathToFile))
                    break;

                System.out.printf("Файла с путём: \"" + pathToFile + "\" не найдено!\n");
            } while (true);

            //открываем файл по введённому пути
            File file = new File(pathToFile);
            //создаём поток ввода для файла
            Scanner scanFile = new Scanner(file);
            //считываем все данные с файла в строку line
            String lineOfNumbers = scanFile.nextLine();
            //парсим данные по ", " и отправляем в массив
            userData = lineOfNumbers.split(", ");

            //проверка данных в файле
            if (checkInput.inputDataBad(userData)) {
                //вывод меню и выбор пользователя
                warning.messageWithIncorrectData();
                userChoice = checkInput.getNumber();
            }else{
                userChoice = -1;
                //заполняем массив считанными данными
                for(int i = 0; i < userData.length; i++){
                    array.add(i, Integer.parseInt(userData[i]));
                }
                //обновляем размер массива
                sizeOfArray = userData.length;
            }

            //закрытие потоков ввода
            scanFile.close();

        }while(userChoice == 1);

        return sizeOfArray;
    }
}