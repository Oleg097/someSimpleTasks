import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AlgoritmTest {

    @Test
    public void ostatok() {
        Algoritm algoritm = new Algoritm();
        int expect1 = algoritm.ostatok(21, 7);
        int actual1 = 5;
        assertEquals(expect1, actual1);
    }

    @Test
    public void nod() {
        Algoritm algoritm2 = new Algoritm();
        int expect2 = algoritm2.nod(18, 35);
        int actual2 = 1;
        int expect3 = algoritm2.nod(35, 18);
        int actual3 = 1;
        assertEquals(expect2, actual2);
        assertEquals(expect3, actual3);


    }


    @Test
    public void getPoints() {

        Algoritm algoritm3 = new Algoritm();
        List<String> expect = new LinkedList<String>();
        Scanner scanner = new Scanner("4\n" +
                "2 3\n" +
                "0 4\n" +
                "1 6\n" +
                "0 5");

        List<String> actual = new LinkedList<String>();
        actual.add("1");
        actual.add("3 ");
        expect = algoritm3.getPoints(scanner);
        assertEquals(expect, actual);


        List<String> expect2;
        Scanner scanner2 = new Scanner("5\n" +
                "1 2\n" +
                "2 3\n" +
                "3 4\n" +
                "4 5\n" +
                "5 6");

        List<String> actual2 = new LinkedList<String>();
        actual2.add("3");
        actual2.add("2 4 6 ");
        expect2 = algoritm3.getPoints(scanner2);
        assertEquals(expect2, actual2);

        List<String> expect3 = new LinkedList<String>();
        Scanner scanner3 = new Scanner("5\n" +
                "5 6\n" +
                "4 7\n" +
                "3 8\n" +
                "2 9\n" +
                "1 10");

        List<String> actual3 = new LinkedList<String>();
        actual3.add("1");
        actual3.add("6 ");
        expect3 = algoritm3.getPoints(scanner3);
        assertEquals(expect3, actual3);

        List<String> expect4 = new LinkedList<String>();
        Scanner scanner4 = new Scanner("13\n" +
                "0 0\n" +
                "0 2\n" +
                "0 3\n" +
                "0 4\n" +
                "0 5\n" +
                "1 6\n" +
                "2 6\n" +
                "3 6\n" +
                "4 7\n" +
                "5 7\n" +
                "6 7\n" +
                "8 8\n" +
                "9 9");

        List<String> actual4 = new LinkedList<String>();
        actual4.add("4");
        actual4.add("0 6 8 9 ");
        expect4 = algoritm3.getPoints(scanner4);
        assertEquals(expect4, actual4);

        List<String> expect5 = new LinkedList<String>();
        Scanner scanner5 = new Scanner("13\n" +
                "0 5\n" +
                "1 6\n" +
                "2 7\n" +
                "3 8\n" +
                "4 9\n" +
                "5 10\n" +
                "6 11\n" +
                "7 12\n"
        );

        List<String> actual5 = new LinkedList<String>();
        actual5.add("2");
        actual5.add("5 11 ");
        expect5 = algoritm3.getPoints(scanner5);
        assertEquals(expect5, actual5);

    }
    @Test

    public  void sumInt(){
        Algoritm algoritm=new Algoritm();
        Scanner scanner=new Scanner("6");
        List<String>actual=new LinkedList<>();
        actual.add("3");
        actual.add("1 2 3");
        List<String>expect=new LinkedList<>();
        expect=algoritm.sumInt(scanner);
        assertEquals(expect,actual);
    }


    @Test
    public void coding() {
        Scanner scanner=new Scanner("a").useDelimiter("");

        Algoritm algoritm=new Algoritm();
        List<String>expect=new ArrayList<>();
        List<String>actual=new ArrayList<>();
        expect=algoritm.coding(scanner);
        actual.add("f");




        assertEquals(expect,actual);


    }
}