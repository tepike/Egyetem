package hu.nye.progtech;

import hu.nye.progtech.service.exceptions.MapReaderException;
import hu.nye.progtech.service.map.parser.MapParser;
import hu.nye.progtech.service.map.reader.BufferedReaderMapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReaderMapReader mapReader= new BufferedReaderMapReader(bufferedReader);



        String line;

        try {
            int numberOfRows=9;
            int numberOfColumns=9;

            List<String> rawMap= mapReader.readMap();

            Iterator iterator = rawMap.iterator();

            while (iterator.hasNext()) {

                System.out.println(iterator.next());
            }

            System.out.println("-----------------------------");

            MapParser mapParser= new MapParser(numberOfRows,numberOfColumns);
            int[][] map = mapParser.getMap(rawMap);

            for(int i=0;i< numberOfRows;i++){
                System.out.println(Arrays.stream(map[i]).mapToObj(String::valueOf).collect(Collectors.joining()));
            }
        }catch (MapReaderException e){
            System.out.println(e.getMessage());
        }

    }
}