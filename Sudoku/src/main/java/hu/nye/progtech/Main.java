package hu.nye.progtech;

import hu.nye.progtech.service.exceptions.MapReaderException;
import hu.nye.progtech.service.map.reader.BufferedReaderMapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReaderMapReader mapReader= new BufferedReaderMapReader(bufferedReader);



        String line;

        try {

            List<String> rawMap= mapReader.readMap();
            Iterator iterator = rawMap.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }catch (MapReaderException e){
            System.out.println(e.getMessage());
        }

    }
}