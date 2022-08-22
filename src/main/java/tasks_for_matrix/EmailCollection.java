package tasks_for_matrix;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCollection {

    private static final String pattern1 = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]{2,}";
    private static final String pattern2 = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]{2,6}";

    private static final String s = "apple-touch-icon@2.png, test@gmail.m, test2@gmail.com,apple-touch-icon@2.png, test@gmail.com, test2@gmail.coqweqewwqm,apple-touch-icon@2.pngqweqweqwe, test@gmail.com, test2@gmail.12345678";
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

    private List<String> getEmailList(String stringForSearch, String pattern) {
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        List<String> emailList = new ArrayList<>();
        Matcher matcher = p.matcher(stringForSearch);
        while (matcher.find()) {
            emailList.add(matcher.group());
        }
        return emailList;
    }

    private void printEmails(String stringForTheParse,String pattern1,String pattern2) {
        List<String>list1 = getEmailList(stringForTheParse,pattern1);
        List<String>list2 = getEmailList(stringForTheParse,pattern2);
        for (int i = 0; i <= list1.size() - 1; i++) {
            if (list1.get(i).equals(list2.get(i))) {
                System.out.println(list1.get(i));
            }
        }
    }

    public static void main(String[] args) {
        EmailCollection emailCollection = new EmailCollection();
        emailCollection.printEmails(getHTMLPage(url),pattern1,pattern2);
        emailCollection.printEmails(s,pattern1,pattern2);

    }
}
