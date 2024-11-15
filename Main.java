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
        int fileOrRandom = 0;
        int saveData = 0, howToSaveData = 0;
        int sizeOfArray = 0;

        //основные объекты
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sortArray = new ArrayList<>();
        InputFunctions howToFill = new InputFunctions();
        VerificationFunctions check = new VerificationFunctions();
        HeapSort newSort = new HeapSort();
        MessageFunctions message = new MessageFunctions();
        //InputOption input;

        //вывод приветствия
        message.greetingText();

        do{
            //вывод меню с вариантами заполнения массива
            message.dataFillingMenu();

            //выбор варианта заполнения массива
            fileOrRandom = check.getNumber();

//            input = InputOption.valueOf(String.valueOf(fileOrRandom));


            switch(fileOrRandom) {
                //кейс с заполнением данных с клавиатуры
                case 1:

                    //получение размера массива и заполнение его числами введёнными с клавиатуры
                    sizeOfArray = howToFill.manualInput(array, sizeOfArray);
                    break;

                //Кейс с заполнением рандомными числами
                case 2:

                    //получение размера массива и заполнение его рандомными числами
                    sizeOfArray = howToFill.fillingArrayRandomValues(array, sizeOfArray);
                    break;

                //кейс с заполнением данных с файла
                case 3:

                    //получение размера массива и заполнение его данными с файла
                    //sizeOfArray = howToFill.inputFromFile(array);

                    if(sizeOfArray == -1){
                        //здесь код чтобы прога не выводила размер массива и его данные
                    }

                    break;

                default:
                    System.out.printf("\nПункта %d нет в меню!\n", fileOrRandom);
                    break;
            }

            //вывод массивов
            if(sizeOfArray > 0) {
                //вывод не отсортированного массива
                message.arrayOutput(array, false);
                //сортировка массива и его вывод
                sortArray = newSort.sort(array, sizeOfArray);
                message.arrayOutput(sortArray, true);
            }else{
                System.out.println("""
                        На стадии заполнения произошли ошибки.
                        Пожалуйста, повторите попытку ввода.
                        """);
                endOrNew = 1;
            }

            //выбор сохранять данные или нет
            System.out.print("""
                    \nЖелаете сохранить полученный результат?
                    (1 - да, любое другое число - нет)
                    Ваш выбор:\s""");
            saveData = check.getNumber();

            //сохранение данных
            if(saveData == 1){
                message.dataSaveMessage();
                howToSaveData = check.getNumber();

                switch(howToSaveData){
                    case 1:

                        break;

                    case 2:
                        break;

                    default:
                        break;
                }
            }

        }while(endOrNew != 0);

    }

}