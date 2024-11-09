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

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    // функция с которой программа начинает работу
    public static void main(String []args) throws FileNotFoundException {

        //общие переменные
        int endOrNew = -1;
        int fileOrRandom;
        int sizeOfArray = 0;
        boolean arrayIsSorted = false;

        //основные объекты
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sortArray = new ArrayList<>();
        InputFunctions howToFill = new InputFunctions();
        VerificationFunctions checkNumber = new VerificationFunctions();
        HeapSort newSort = new HeapSort();
        OutputFunctions output = new OutputFunctions();

        //вывод приветсвия
        output.greetingText();

        do{
            //вывод меню с вариантами заполнения массива
            output.dataFillingMenu();

            //выбор варианта заполнения массива
            fileOrRandom = checkNumber.getNumber();




            switch(fileOrRandom) {

                //кейс с запполнением данных с клавиатуры
                case 1:


                    break;

                //Кейс с заполнением рандомными числами
                case 2:

                    //получение размера массива и заполнение его рандомными чисами
                    sizeOfArray = howToFill.fillingArrayRandomValues(array, sizeOfArray);

                    break;

                //кейс с заполнением данных с файла
                case 3:

                    //получение размера массива и заполнение его данными с файла
                    sizeOfArray = howToFill.inputFromFile(array);

                    if(sizeOfArray == -1){
                        //здесь код чтобы прога не выводила размер массива и его данные
                    }

                    output.arrayOutput(array, false);
                    break;

                default:
                    System.out.printf("\nПункта %d нет в меню!\n", fileOrRandom);
                    break;
            }

            //вывод отсортированного массива
            //sortArray = newSort.sort(array, sizeOfArray);

        }while(endOrNew != 0);

    }

}