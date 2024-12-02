import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        try (FileReader fr = new FileReader("input.txt");) {
            int num;
            char ch;
            String line = "";
            while ((num = fr.read()) != -1) {
                ch = (char) num;
                if (ch == '\n') {
                    lines.add(line);
                    line ="";
                    continue;
                }
                line += ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] list1 = new int[lines.size()];
        int[] list2 = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i).split("   ");
            list1[i] = Integer.parseInt(line[0]);
            list2[i] = Integer.parseInt(line[1]);
        }

        int distance = 0;

        list1 = Arrays.stream(list1).sorted().toArray();
        list2 = Arrays.stream(list2).sorted().toArray();

        for (int i = 0; i < list1.length; i++) {
            distance += Math.abs(list1[i] - list2[i]);
        }

        System.out.println(distance);

    }
}