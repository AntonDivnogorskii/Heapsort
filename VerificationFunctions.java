import java.util.Scanner;

public class VerificationFunctions {
    //функция для ввода только чисел
    public int getNumber(){
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        while(true){
            userInput = scan.nextLine();
            try{
                return Integer.parseInt(userInput);
            }catch(NumberFormatException e){
                System.out.print("""
                        
                        Пожалуйста введите одно целое число!
                        Пожалуйста повторите попытку:\s""");
                userInput = "";
            }
        }
    }

    public boolean inputDataBad(String[] userInput){

        for(int i = 0; i < userInput.length; i++){
            try{
                Integer.parseInt(userInput[i]);
            } catch (NumberFormatException _) {
                MessageFunctions.incorrectData(userInput[i], i);
                return true;
            }
        }
        return false;
    }

//    public static void badDataFromConsole(){
//
//    }
//
//    //функция проверяет существование файла по введённому пути
//    public static boolean fileExists(String pathToFile){
//        File file = new File(pathToFile);
//        return file.exists();
//    }
//
//    //функция проверяет корректность данных в файле
//    public static boolean badDataFromFile(String pathToFile) throws FileNotFoundException {
//
//        //открываем файл по введённому пути
//        File file = new File(pathToFile);
//        //создаём поток ввода для файла
//        Scanner scanFile = new Scanner(file);
//        //считываем все данные с файла в строку line
//        String lineOfNumbers = scanFile.nextLine();
//        //парсим данные по ", " и отправляем в массив
//        String[] userData = lineOfNumbers.split(", ");
//        //цикл для проверки данных в файла
//
//        for (int i = 0; i < userData.length; i++) {
//            try{
//                Integer.parseInt(userData[i]);
//            } catch (NumberFormatException e) {
//                OutputFunctions.incorrectDataInTheFile(userData, i);
//                scanFile.close();
//                return true;
//            }
//        }
//
//        return false;
//    }

}