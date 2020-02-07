
import java.lang.reflect.Array;
        import java.text.DecimalFormat;
        import java.util.*;

public class Algoritm {

    public int ostatok(int n, int m) {

        double prepre = 0;
        double pre = 1;
        double res = 0;

        for (int i = 1; i <= n; i++) {
            prepre = pre;
            pre = res;
            res = prepre + pre;
        }
        double res2 = res / m;
        int res3 = (int) res2;
        res = (res2 - res3) * m;

        return (int) res;
    }

    public int nod(int a, int b) {
        if (a == b) {
            return a;
        } else {
            while ((a != 0) && (b != 0)) {
                a = a > b ? a % b : a;
                b = (a != 0) && (b > a) ? b % a : b;
            }
            return Math.max(a, b);

        }

    }

    public List<String> getPoints(Scanner scanner) {
        scanner.useDelimiter("\n");
        List<String> strings = new LinkedList<String>();
        scanner.forEachRemaining(strings::add);


        LinkedList<Integer[]> listInt = new LinkedList<Integer[]>();
        LinkedList<String> finalList = new LinkedList<String>();
        LinkedList<Integer> points = new LinkedList<>();

        for (int i = 1; i < strings.size(); i++) {

            String[] stringArr = strings.get(i).split(" ");
            Integer[] intArr = new Integer[2];


            intArr[0] = Integer.parseInt(stringArr[0]);
            intArr[1] = Integer.parseInt(stringArr[1]);
            listInt.add(intArr);
        }


        Collections.sort(listInt, new Comparator<Integer[]>() {
            public int compare(Integer[] o1, Integer[] o2) {
                //o1[1] = o1[1] == 0 ? Integer.MIN_VALUE : o1[1];
                //o2[1] = o2[1] == 0 ? Integer.MIN_VALUE : o2[1];

                return o1[1].compareTo(o2[1]);
            }
        });

        StringBuilder strb = new StringBuilder();
        int count = 0;
        for (int i = 0, j = 1; j < listInt.size(); j++) {
            if ((j < listInt.size() - 1) && (listInt.get(i)[1] < listInt.get(j)[0])) {
                points.add(listInt.get(i)[1]);
                count++;

                i = j;
            }
            if ((j == listInt.size() - 1) && listInt.get(j)[0] > listInt.get(i)[1]) {
                points.add(listInt.get(i)[1]);
                count++;
                points.add(listInt.get(j)[1]);
                count++;
            }
            if ((j == listInt.size() - 1) && listInt.get(j)[0] <= listInt.get(i)[1]) {
                points.add(listInt.get(i)[1]);
                count++;
            }
        }

        points.forEach(s -> strb.append(s + " "));


        finalList.add(strb.toString());
        finalList.addFirst(String.valueOf(count));
        return finalList;

    }

    public List<String> sumInt(Scanner scanner) {

        int x = scanner.nextInt();
        int count = 0;
        int count2 = 1;
        List<String> list = new LinkedList<>();
        List<String> result = new LinkedList<>();
        if (x < 3) {
            result.add(String.valueOf(x));
        }
        while (count < x) {
            count = count + count2;

            list.add(String.valueOf(count2));
            count2++;

        }
        if (count > x) {
            int x2 = count - x;
            list.remove(String.valueOf(x2));
            //list.add(String.valueOf(count2));

        }
        String str = String.join(" ", list);
        result.add(String.valueOf(list.size()));
        result.add(str);


        return result;


    }


    public List<String> coding(Scanner scanner) {
        String str = scanner.nextLine();
        List<String>list;
        list=Node.code(str);
        return list;


    }
}




