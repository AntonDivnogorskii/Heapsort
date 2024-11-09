import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerificationFunctions {
    //функция для ввода только чисел
    public static int getNumber(){
        Scanner scan = new Scanner(System.in);

        while(true) {
            if(scan.hasNextInt()){
                return scan.nextInt();
            }else{
                System.out.println("\nВведённое значение не является числом!\n" +
                        "Пожалуйста повторите попытку: ");
                scan.next();
            }
        }
    }

    public static boolean fileExists(String pathToFile){
        File file = new File(pathToFile);
        return file.exists();
    }

    public static boolean badData(String pathToFile, int[] userData) throws FileNotFoundException {

        //открываем файл по введённому пути
        File file = new File(pathToFile);
        //создаём поток ввода для файла
        Scanner scanFile = new Scanner(file);
        //считываем все данные с файла в строку line
        String lineOfNumbers = scanFile.nextLine();
        //парсим данные по ", " и отправляем в массив
        String[] numbers = lineOfNumbers.split(", ");
        //цикл для проверки данных в файла

        for (int i = 0; i < numbers.length; i++) {
            try {
                userData[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e) {
                OutputFunctions.incorrectDataInTheFile(numbers, i);
                return true;
            }
        }

        return false;
    }

}