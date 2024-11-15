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

        } while (checkInput.inputDataBad(userNumbers));

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

    public int inputFromFile(ArrayList<Integer> array, int sizeOfArray){


        return sizeOfArray;
    }

//    //на доработке!!!!!!!!!
//    //функция заполняет массив данными из файла
//    public int inputFromFile(ArrayList<Integer> array) throws FileNotFoundException {
//        //блок в зависимости от ОС выбирает разделитель
//        //String separator = File.separator;
//
//        //основные объекты
//        Scanner scan = new Scanner(System.in);
//        OutputFunctions warning = new OutputFunctions();
//        VerificationFunctions check = new VerificationFunctions();
//
//        //основные переменные
//        int sizeOfArray = 0;
//        boolean dataIsBad = true;
//        int userChoice = -1;
//        String pathToFile = "";
//
//        //вывод инструкции
//        warning.messageInputFromFile();
//
//        //цикл позволяющий вводить новый путь для файла
//        do {
//            System.out.printf("Введите путь до файла: ");
//
//            //ввод пути до файла и попытка его открыть
//            while (true) {
//                pathToFile = scan.nextLine();
//                //если путь правильный -> пропускаем
//                if (VerificationFunctions.fileExists(pathToFile)) {
//                    break;
//                }
//                System.out.printf("Файла с путём: \"" + pathToFile + "\" не найдено!\n" +
//                        "Пожалуйста введите новый путь: ");
//            }
//
//            //цикл позволяющий несколько раз проверять данные одного файла
//            do {
//                //проверка данных в файле
//                if (VerificationFunctions.badDataFromFile(pathToFile)) {
//                    //вывод меню и выбор пользователя
//                    warning.selectionWithIncorrectData();
//                    do {
//                        System.out.print("Вы можете выбрать только существующий пункт (1, 2 или 3): ");
//                        userChoice = scan.nextInt();
//                    } while (userChoice != 1 && userChoice != 2 && userChoice != 3);
//
//                    //если пользователь захотел воспользоваться другим способом ввода данных
//                    if(userChoice == 3)
//                        return -1;
//
//                    //чистим путь до файла и отправляем на повторный ввод
//                    if(userChoice == 2)
//                        pathToFile = null;
//                }else {
//                    //если данные в порядке -> пропускаем
//                    userChoice = 4;
//                }
//            }while(userChoice == 1);
//        }while(userChoice == 2);
//
//        //циклом заполняем наш массив считанным данными
//
//        InputFunctions.inputDataFromFile(pathToFile, array);
//
//        sizeOfArray = array.size();
//
//        scan.close();
//
//        return sizeOfArray;
//    }

}