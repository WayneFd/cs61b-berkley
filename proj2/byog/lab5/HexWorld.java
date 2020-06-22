package byog.lab5;
//import org.junit.Test;
//import static org.junit.Assert.*;
import java.awt.*;
import java.util.Scanner;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static int WIDTH = 50;
    private static int HEIGHT = 50;
    private static final long SEED = 28899;
    private static final Random RANDOM = new Random(SEED);
    private static int size;

    private static class Cordinate {
        public int x;
        public int y;
        public Cordinate() {
            x = 0;
            y = 0;
        }
        public Cordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static TETile randomtile() {
        int tilemNum = RANDOM.nextInt(4);
        switch (tilemNum) {
            case 0: return Tileset.FLOWER;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.SAND;
            default: return Tileset.FLOWER;
        }
    }
    private static void drawupper(TETile[][] world, TETile target, Cordinate p) {
        int length = size;
        int x = p.x;
        for (int j = p.y; j >= p.y - size + 1; j--) {
            for (int i = x; i < x + length; i++) {
                world[i][j] = target;
            }
            x -= 1;
            length += 2;
        }
    }
    private static void drawlower(TETile[][] world, TETile target, Cordinate p) {
        int x = p.x - size + 1;
        int y= p.y - size;
        int length  = size * 3 - 2;
        for (int j = y; j >= y - size + 1; j--) {
            for (int i = x; i < x + length; i++) {
                world[i][j] = target;
            }
            length -= 2;
            x += 1;
        }
    }
    public static void addHexagon(TETile[][] world, Cordinate p) {
        TETile target = randomtile();
        drawupper(world, target, p);
        drawlower(world, target, p);
    }

    public static void addColumn (TETile[][] world, Cordinate p, int num) {
        Cordinate temp = new Cordinate(p.x,p.y);
        for (int i = 0; i < num; i++) {
            addHexagon(world,temp);
            temp.y -= 2 * size;
        }

    }
    private static void lowleft(Cordinate p) {
        p.x = p.x + 1 - 2 * size;
        p.y = p.y - size ;

    }
    private static void lowright(Cordinate p) {
        p.x = p.x - 1 + 2 * size;
        p.y = p.y - size ;

    }
    private static void uppleft (Cordinate p) {
        p.x = p.x + 1 - 2 * size;
        p.y = p.y - size ;

    }
    private static void uppright (Cordinate p) {
        p.x = p.x - 1 + 2 * size;
        p.y = p.y + size ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the size of the Hexworld:");
        size = sc.nextInt();
        HEIGHT = size * 10;
        WIDTH  = size * 11 - 6;
        Cordinate p = new Cordinate();
        p.x = WIDTH/2 - 1;
        p.y = HEIGHT -1;
        lowleft(p);
        lowleft(p);
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] hexTiles = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                hexTiles[x][y] = Tileset.NOTHING;
            }
        }
        //addHexagon(hexTiles, p,3);
        addColumn(hexTiles, p, 3);
        uppright(p);
        addColumn(hexTiles, p, 4);
        uppright(p);
        addColumn(hexTiles, p, 5);
        lowright(p);
        addColumn(hexTiles, p, 4);
        lowright(p);
        addColumn(hexTiles, p, 3);

        ter.renderFrame(hexTiles);

    }

}
