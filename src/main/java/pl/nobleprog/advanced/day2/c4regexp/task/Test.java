package pl.nobleprog.advanced.day2.c4regexp.task;

import java.util.List;

public class Test {
    public static void test() {
        String html = """
                <table>
                   <tr>
                     <td><a href="http://abc.de/fg">link1</a></td>
                     <td>as@nobleprog.pl</td>
                     <td>123</td>
                   </tr>
                <table>
                   <p>
                      <a href='https://nobleprog.pl'>link2</a>
                   </p>
                """;

        List<String> strings = PatternTask.extractTable(html);

        if (strings.size() == 2 && strings.get(0).equals("http://abc.de/fg") && strings.get(1).equals("https://nobleprog.pl")) {

            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed!");
        }
    }
}
