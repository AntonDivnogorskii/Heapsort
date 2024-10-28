import java.util.Scanner;

public class VerificationFunctions {
    //функция для ввода только чисел
    public static int getNumber(){
        Scanner scan = new Scanner(System.in);

        for(;;) {
            if(scan.hasNextInt()){
                return scan.nextInt();
            }else{
                System.out.printf("\nВведённое значение не является числом!\n" +
                        "Пожалуйста повторите попытку: ");
                scan.next();
            }
        }
    }



}