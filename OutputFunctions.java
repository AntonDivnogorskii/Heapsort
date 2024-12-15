package Sorting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputFunctions {

    public static void saveDataOnFile(ArrayList<Integer> array) {

        //основные переменные и объекты
        String pathToFile = "";
        Scanner scan = new Scanner(System.in);

        //ввод пути до файла
        do {
            System.out.print("\nВведите путь до существующего файла: ");
            pathToFile = scan.nextLine();

            if (VerificationFunctions.fileExists(pathToFile))
                break;

            System.out.printf("Файла с путём: \"" + pathToFile + "\" не найдено!\n");
        } while (true);

        //
        String textOut = array.stream()
                .map(x -> String.valueOf(x))
                .collect(Collectors.joining(", "));

        //конвертация пути в тип Path
        Path pathOut = Paths.get(pathToFile);

        try {
            Files.writeString(pathOut, textOut);
            System.out.print("Данные успешно записаны в файл \"" + pathToFile + "\"!\n");
        } catch (IOException ex) {
            System.out.println("""
                    Произошла ошибка при записи данных в файл!
                    Попробуйте повторить попытку!
                    """);
        }
    }

//    public static void saveDataInChart(ArrayList<Integer> array) {
//
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        // Добавляем данные из ArrayList в датасет
//        for (int i = 0; i < list.size(); i++) {
//            dataset.addValue(list.get(i), "Series1", "Point " + (i + 1));
//        }
//
//        // Создаем график с использованием JFreeChart
//        JFreeChart chart = ChartFactory.createLineChart(
//                "График данных",      // Заголовок графика
//                "Индекс",             // Ось X
//                "Значение",           // Ось Y
//                dataset,              // Датасет
//                PlotOrientation.VERTICAL, // Направление графика
//                true,                 // Легенда
//                true,                 // Подсказки
//                false                 // URL-обработчики
//        );
//
//        // Сохраняем график в файл
//        try {
//            File outputFile = new File(filename);
//            ImageIO.write(chart.createBufferedImage(800, 600), "PNG", outputFile);
//            System.out.println("График успешно сохранен в файл: " + filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
