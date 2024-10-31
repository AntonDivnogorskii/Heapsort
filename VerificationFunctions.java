import java.util.Scanner;

public class VerificationFunctions {
    //функция для ввода только чисел
    public static int getNumber(){
        Scanner scan = new Scanner(System.in);

        while(true) {
            if(scan.hasNextInt()){
                return scan.nextInt();
            }else{
                System.out.print("\nВведённое значение не является числом!\n" +
                        "Пожалуйста повторите попытку: ");
                scan.next();
            }
        }
    }



}