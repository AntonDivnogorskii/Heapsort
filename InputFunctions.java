import java.util.ArrayList;
import java.util.Scanner;

public class InputFunctions {

    //функция заполняет массив введёнными значениями
    public void manualInput(ArrayList<Integer> array, int sizeOfArray){

        Scanner scan = new Scanner(System.in);
        String userInput = "";
        String userNumbers = "";

        userInput = scan.nextLine();

        for(int i = 0; i < sizeOfArray; i++){
            if(userInput.charAt(i) != ' ' || userInput.charAt(i) != ',') {
                userNumbers += userInput.charAt(i);
            }else{
                array += Integer.parseInt(userNumbers.trim());
            }

        }
    }


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

}
