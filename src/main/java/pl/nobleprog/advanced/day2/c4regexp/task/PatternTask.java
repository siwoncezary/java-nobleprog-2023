package pl.nobleprog.advanced.day2.c4regexp.task;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTask {
    public static void main(String[] args) {
        Test.test();
    }

    /*
        Wyłuskaj za pomocą regex adresy z linków z fragmentu dokumentu HTML.
        Np. dla wejścia:
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
        funkcja powinna zwrócić listę adresów:
        http://abc.de/fg
        https://nobleprog.pl

     */

    public static List<String> extractTable(String html){
        //throw new RuntimeException("Not implemented!");
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a\\s+href=[\"'](?<url>.*?)[\"']>(?<name>.*?)</a>");
        Matcher matcher = pattern.matcher(html);
        while(matcher.find()){
            String url = matcher.group("url");
            result.add(url);
        }
        return result;
    }
}
