import java.util.*;

public class Node {
    public int freeq;
    public String letter;
    public Node leftChild;
    public Node rightChild;

    public Node(int freeq, String letter, Node leftChild, Node rightChild) {
        this.freeq = freeq;
        this.letter = letter;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(int freeq, String letter) {
        this.freeq = freeq;
        this.letter = letter;
    }

    public Node() {
    }
    public int getFreeq() {
        return freeq;
    }

    public void addChild(Node newNode) {//добавить потомка
        if (leftChild == null)
            leftChild = newNode;
        else {
            if (leftChild.getFreeq() <= newNode.getFreeq())
                rightChild = newNode;
            else {
                rightChild = leftChild;
                leftChild = newNode;
            }
        }

        freeq += newNode.getFreeq();
    }
    static List<String>code(String str){

        String[] arr = str.split("");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(s ->map.merge(s, 1, (a, b) -> a + b));
        List<String> keylist = new LinkedList<>(map.keySet());
        List<Integer> values = new LinkedList<>(map.values());
        List<String> finalList = new LinkedList<>();
        if (keylist.size()<2) {
            finalList.add((keylist.size()) + " " + (keylist.size()));
            finalList.add(keylist.get(0) + ": 0");
            finalList.add("0");
            for (String item : finalList) {
                System.out.println("FINAL LIST " + item);
            }
            return finalList;
        }else {
            Comparator<BeTree> comparator = new Comparator<BeTree>() {
                @Override
                public int compare(BeTree o1, BeTree o2) {
                    return o1.getFreequance() - o2.getFreequance();
                }
            };
            List<BeTree> trees = new LinkedList<>();

            for (int i = 0; i < keylist.size(); i++) {
                trees.add(new BeTree(new Node(values.get(i), keylist.get(i))));
                trees.sort(comparator);
            }
            while (trees.size() > 1) {
                BeTree beTree1 = trees.get(0);
                System.out.println(beTree1.getFreequance() + " - частота индекса 0");
                BeTree beTree2 = trees.get(1);
                System.out.println(beTree2.getFreequance() + " - частота индекса 1");
                trees.remove(0);
                trees.remove(0);

                Node node = new Node();
                node.addChild(beTree1.getRoot());
                node.addChild(beTree2.getRoot());
                BeTree beTree3 = new BeTree(node);
                beTree3.root.freeq = beTree1.root.freeq + beTree2.root.freeq;
                beTree3.root.letter = beTree1.root.letter + beTree2.root.letter;
                System.out.println(beTree3.getFreequance() + " - частота суммарная ");
                trees.add(beTree3);
                trees.sort(comparator);
            }
            Node node = new Node();
            for (int i = 0; i < keylist.size(); i++) {
                node = trees.get(0).root;
                StringBuilder strb = new StringBuilder();
                while (!node.letter.equals(keylist.get(i))) {
                    if (node.leftChild.letter.contains(keylist.get(i))) {
                        System.out.println(" 3   if: node.letter - " + node.letter);
                        node = node.leftChild;
                        strb.append("0");
                        System.out.println(" 3   if: NEW NODE LETTER - " + node.letter);
                    } else if (node.rightChild.letter.contains(keylist.get(i))) {
                        System.out.println(" 4   if: node.letter - " + node.letter);
                        node = node.rightChild;
                        strb.append("1");
                        System.out.println(" 4   if: NEW NODE LETTER - " + node.letter);
                    }
                }

                map.replace(keylist.get(i), Integer.valueOf(strb.toString()));
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                stringBuilder.append(map.get(arr[j]).toString());
            }
            finalList.add((keylist.size()) + " " + (stringBuilder.toString().length()));
            for (int j = 0; j < keylist.size(); j++) {
                finalList.add(keylist.get(j) + ": " + String.valueOf(map.get(keylist.get(j))));
            }
            finalList.add(stringBuilder.toString());

            for (String item : finalList) {
                System.out.println("FINAL LIST " + item);


            }

            return finalList;
        }

    }

}


