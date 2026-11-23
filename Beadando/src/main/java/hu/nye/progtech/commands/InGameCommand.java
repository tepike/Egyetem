package hu.nye.progtech.commands;

import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.GameObjects;
import hu.nye.progtech.model.ObjectList;
import hu.nye.progtech.model.Position;

import java.util.Scanner;

public class InGameCommand extends MapVO {
    private boolean Runing = true;

    public boolean isRuning() {
        return Runing;
    }

    public void stopRuning() {
        Runing = (!Runing);
    }

    public void CheckCommand() {
        while (isRuning()) {

        }

    }

    public void mozgat() {
        int x1, y1, x2, y2;
        GameObjects found = null;
        GameObjects selectedObject = null;

        while (found == null) {
            System.out.println("\nAdja meg a koordinátát pl: 'C2'");
            String beker = new Scanner(System.in).nextLine().toLowerCase();
            x1 = Integer.parseInt(String.valueOf(beker.charAt(0) - 'a'));
            y1 = Integer.parseInt(String.valueOf(beker.charAt(1) - '0' - 1));

            found = ObjectList.findObjectAt(x1, y1);
            if (found == null) {
                System.out.print("Ott nincs objektum");
            }
        }
        selectedObject = found;
        for (Position p : selectedObject.getOccupiedPositions()) {
            System.out.println("\nX: " + p.getX() + ", Y: " + p.getY());
        }
        System.out.print("\nElso x:" + selectedObject.getOccupiedPositions().getFirst().getX());
        System.out.print("\nUtolso x:" + selectedObject.getOccupiedPositions().getLast().getX());
        System.out.print("\nElso y:" + selectedObject.getOccupiedPositions().getFirst().getY());
        System.out.print("\nUtolso y:" + selectedObject.getOccupiedPositions().getLast().getY());
        System.out.print("\nHossz: " + selectedObject.getLength());
        System.out.print("\nOrientáció: " + selectedObject.getOrientation());


        System.out.println("\nObjektum kiválasztva");
        while (found != null) {
            System.out.println("\nAdja meg a cél koordinátát pl: 'C2'");
            String beker = new Scanner(System.in).nextLine().toLowerCase();
            x2 = Integer.parseInt(String.valueOf(beker.charAt(0) - 'a'));
            y2 = Integer.parseInt(String.valueOf(beker.charAt(1) - '0' - 1));

            found = ObjectList.findObjectAt(x2, y2);
            if (found == null) {
                System.out.print("Ott nincs objektum, lehet oda lépni (nincs teszt előtte utána esetre)");
                System.out.print("Pozicio különbseg x:");
            }

        }

    }
}
