package tasks_for_matrix;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCollection {
    private static final Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
            , Pattern.CASE_INSENSITIVE);
    private static final Pattern pattern2 = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+"
            , Pattern.CASE_INSENSITIVE);

    static String url = "https://stackoverflow.com/questions/15703704/find-emails-in-a-string";

    private static String getHTMLPage(String url) {
        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        String s = getHTMLPage(url);
        Matcher m = pattern2.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
//        System.out.println(getHTMLPage(url));
    }
}
