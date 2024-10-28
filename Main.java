/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // функция с которой программа начинает работу
    public static void main(String []args){

        System.out.printf("*****************************************************************\n" +
                "* The program was completed by:\t\t\t\t\t\t\t\t\t*\n" +
                "* \tStudent - Divnogorskii Anton Andreevich\t\t\t\t\t\t*\n" +
                "* \tGroup - 433\t\t\t\t\t\t\t\t\t\t\t\t\t*\n" +
                "* \tAbout program - software solution to implement heap sort\t*\n" +
                "*****************************************************************\n\n");

        //общие переменные
        int endOrNew = -1;
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sortArray = new ArrayList<>();
        VerificationFunctions checkNumber = new VerificationFunctions();
        HeapSort newSort = new HeapSort();
        int fileOrRandom = 0;
        int sizeOfArray = 0;

        do{
            //выбор заполнения массива
            System.out.printf("# меню вариантов заполнения массива #\n" +
                    "* 1 - заполнить массив рандомными числами\n" +
                    "* 2 - загрузить данные с файла\n" +
                    "# Выбирете способ заполнения массива: ");
            fileOrRandom = checkNumber.getNumber();

            switch(fileOrRandom) {

                //Кейс с заполнением рандомными числами
                case 1:
                    System.out.printf("\nВведите размер массива: ");

                    do {
                        sizeOfArray = checkNumber.getNumber();

                        if (sizeOfArray > 0)
                            break;

                        System.out.printf("\nРазмер массива обязательно должен быть больше 0!\n" +
                                "Повторите попытку: ");
                    }while (true);

                    //заполнение массива рандомными числами
                    for(int i = 0; i < sizeOfArray; i++){
                        array.add((int)(Math.random() * 100));
                    }

                    System.out.printf("\nМассив был заполнен следующими числами:\n");
                    System.out.println(array);
                    System.out.printf("\n");

                    break;

                //кейс с заполнением данных с файла
                case 2:
                    String pathToFile = "";
                    Scanner scan = new Scanner(System.in);

                    System.out.printf("Введите путь до файла: ");
                    pathToFile = scan.nextLine();

                    break;

                default:
                    System.out.printf("\nПункта %d нет в меню!\n", fileOrRandom);
                    break;
            }

            //вывод отсортированного массива
            sortArray = newSort.sort(array, sizeOfArray);
            System.out.printf("Отсортированный массив:\n");
            System.out.println(sortArray);
            System.out.printf("\n");


        }while(endOrNew != 0);

    }

}