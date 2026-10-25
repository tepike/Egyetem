package hu.nye.progtech.map.reader;

import hu.nye.progtech.service.MapReaderException;

import java.util.List;

public interface MapReaderInterface {
    List<String> readMap() throws MapReaderException;
}
