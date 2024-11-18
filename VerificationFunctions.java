package Sorting;

import java.io.File;
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

    //функция проверяет существование файла по введённому пути
    public static boolean fileExists(String pathToFile){
        File file = new File(pathToFile);
        return file.exists();
    }

}