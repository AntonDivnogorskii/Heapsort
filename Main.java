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

package Sorting;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // функция с которой программа начинает работу
    public static void main(String []args) throws FileNotFoundException {

        //общие переменные
        int endOrNew = -1;
        int sizeOfArray = 0;

        //основные объекты
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> sortArray;
        InputFunctions howToFill = new InputFunctions();
        VerificationFunctions check = new VerificationFunctions();
        HeapSort newSort = new HeapSort();
        MessageFunctions message = new MessageFunctions();
        InputOption option = null;

        //вывод приветствия
        message.greetingText();

        do{
            //основные объекты
            String fileRandomManual = "";

            //вывод меню с вариантами заполнения массива
            message.dataFillingMenu();

            while(true) {
            //выбор варианта заполнения массива
            fileRandomManual = scan.nextLine().toUpperCase();

                //перевод ввода пользователя в enum
                try {
                    option = InputOption.valueOf(fileRandomManual);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.printf("\nПункта %s нет в меню!\nПовторите попытку ввода: ", fileRandomManual);
                }
            }

            switch(option) {
                //кейс с заполнением данных с клавиатуры
                case MANUAL:
                    //получение размера массива и заполнение его числами введёнными с клавиатуры
                    sizeOfArray = howToFill.manualInput(array, sizeOfArray);
                    break;

                //Кейс с заполнением рандомными числами
                case RANDOM:
                    //получение размера массива и заполнение его рандомными числами
                    sizeOfArray = howToFill.fillingArrayRandomValues(array, sizeOfArray);
                    break;

                //кейс с заполнением данных с файла
                case FILE:
                    //получение размера массива и заполнение его данными с файла
                    sizeOfArray = howToFill.inputFromFile(array, sizeOfArray);

                    if(sizeOfArray == 0) {
                        System.out.print("\nДанные не были считаны!\n");
                        continue;
                    }

                    break;

                default:
                    System.out.printf("\nПункта %s нет в меню!\n", fileRandomManual);
                    break;
            }

            //вывод массивов
            if(sizeOfArray > 0) {
                //вывод неотсортированного массива
                message.arrayOutput(array, false);
                //сортировка массива и его вывод
                sortArray = newSort.sort(array, sizeOfArray);
                message.arrayOutput(sortArray, true);
            }else{
                System.out.println("""
                        
                        На стадии заполнения произошли ошибки.
                        Пожалуйста, повторите попытку ввода.""");
                continue;
            }

            int saveData = 0;
            //выбор сохранять данные или нет
            System.out.print("""
                    \nЖелаете сохранить полученный результат?
                    (1 - да, любое другое число - нет)
                    Ваш выбор:\s""");
            saveData = check.getNumber();

            //сохранение данных
            if(saveData == 1){
                message.dataSaveMessage();

                int howToSaveData = 0;
                //цикл позволяет обрабатывать ввод пунктов которых нет
                do {
                    howToSaveData = check.getNumber();
                    switch (howToSaveData) {
                        case 1:
                            //сохраняем результат в файл
                            OutputFunctions.saveDataOnFile(sortArray);

                            break;

                        case 2:
                            break;

                        default:
                            System.out.printf("\nПункта %d нет в меню!\nВыберите пункт 1 или 2: ", howToSaveData);
                            break;
                    }
                }while(howToSaveData != 1 && howToSaveData != 2);
            }

            //выбор завершать работу или нет
            message.endMessage();
            endOrNew = check.getNumber();

            //чистка и закрытие основных элементов
            if(endOrNew != 0){
                sortArray.clear();
                array.clear();
                sizeOfArray = 0;
            }

        }while(endOrNew != 0);
    }
}