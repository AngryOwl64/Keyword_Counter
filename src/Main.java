import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KeywordCounter counter;
        String choose = "xxx";
        System.out.println("For enter Keywords now type 1 | For load keywords out of the txt file type 2");
        while (!choose.equals("1") && !choose.equals("2")) { // 1 = manual input // 2 = load from file
            choose = scan.nextLine();
            if (!choose.equals("1") && !choose.equals("2")) {System.out.println("INPUT WAS NOT 1 OR 2!");
            System.out.println("For enter Keywords now type 1 | For load keywords out of the txt file type 2"); }
        }
        if (choose.equals("1")) {
            System.out.print("Please enter your keywords, separated by spaces: ");
            String input = scan.nextLine().trim().toLowerCase();
            while (input.isEmpty()) {
                System.out.println("INPUT WAS EMPTY OR ONLY WHITESPACES! PLEASE ENTER AT LEAST ONE KEYWORD.");
                input = scan.nextLine().trim().toLowerCase();
            }
            String[] words = input.split("\\s+");
            counter = new KeywordCounter(words);
        } else {
            String[] loaded = loadKeywords();
            if (loaded.length == 0) {
                System.out.print("FILE WAS EMPTY\nPlease enter Keywords manually:");
                String input = scan.nextLine().trim().toLowerCase();
                while (input.isEmpty()) {
                    System.out.println("INPUT WAS EMPTY OR ONLY WHITESPACES! PLEASE ENTER AT LEAST ONE KEYWORD.");
                    input = scan.nextLine().trim().toLowerCase();
                }
                String[] words = input.split("\\s+");
                counter = new KeywordCounter(words);
            } else {
                counter = new KeywordCounter(loaded);
            }
        }
        while (true) {
            System.out.print("Please enter the text: ");
            counter.countKeywords(scan.nextLine());
            counter.printCounts();
            counter.resetCounter();
            System.out.println("\nDo you want to analyse another text? (y/n)");
            String choice = scan.nextLine();
            while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("WRONG INPUT!");
                choice = scan.nextLine();
            }
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }
        scan.close();
    }
    public static String[] loadKeywords() {
        File keywordsFile = new File("keywords.txt");
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(keywordsFile);
        } catch (FileNotFoundException exception) {
            System.out.println("!FILE NOT FOUND!");
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String lowCaseLine = line.trim().toLowerCase();
            if (!lowCaseLine.isEmpty()) {
                list.add(lowCaseLine);
            }
        }
        String[] array = list.toArray(new String[0]);

        fileScanner.close();
        return array;
    }
}