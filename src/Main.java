import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    line = "";
                    continue;
                }
                line += ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        AtomicInteger result = new AtomicInteger();
        String line = "do()"+ lines.get(0);
        String[] splitLine = line.split("don't\\(\\)");
        for (String s : splitLine) {
            s = s.substring(line.indexOf("do()"));


            Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String a = matcher.group();
                a = a.substring(4, a.length() - 1);
                String[] b = a.split(",");
                result.addAndGet(Integer.parseInt(b[0]) * Integer.parseInt(b[1]));

            }
        }
        System.out.println(result.get());

    }
}