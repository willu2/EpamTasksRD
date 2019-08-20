package jav.collect;
/*Java. Collections Optional*/

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class TasksCollections {
    String localPath = "data/";

    public void showTaskResult() {

       reverseStringInFile();
       reverceStack(2345679);
       showDirectories();
       sortSong();

       printStringsFromFile();
       System.out.println(isBracketsMatches("(()([])){()}"));
       findDifferenceWords();
    }

    // 1. Load strings into the list from file and write it reverse
    public void reverseStringInFile() {

        String filePath = localPath + "rev.txt";
        LinkedList<String> textReaderList = new LinkedList<>();
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //write to list
        while (sc.hasNextLine()) {
            textReaderList.add(sc.nextLine());
            System.out.println(textReaderList);
        }

        //write new reverse text
        ListIterator li = textReaderList.listIterator(textReaderList.size());


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(localPath + "rev.txt"));
            while (li.hasPrevious()) {
                bw.write((String) li.previous());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
                  e.printStackTrace ();
        }
    }

    // 2. Enter number, load digits in to the stack. Print number with reverse digits
    private void reverceStack(int number) {
        Stack stack = new Stack();

        while (number > 0) {
            stack.push(number % 10);
            number = number / 10;
        }
        int reverse = 0;
        int i = 1;

        while (!stack.isEmpty())
        {
            reverse = reverse + ((int)stack.peek() * i);
            stack.pop();
            i = i * 10;
        }
        System.out.print(reverse);
    }

    //3.   Create list with directories.
    private void showDirectories() {
        String targetDirectory = "C:/Windows/Temp";
        try {
            Files.walk(Paths.get(targetDirectory), FileVisitOption.FOLLOW_LINKS)
                    .map(Path::toFile)
                    .forEach(f -> {
                        if(f.isDirectory())
                            System.out.println(f.getAbsolutePath());
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*private List<File> dir = new ArrayList<File>();
        public List<String> dirListFromFilePath(String path) {
            File myDir = new File(path);
            dir = list(myDir);
            List<String> stringList = new ArrayList<>();
            dir.forEach(file -> {
                stringList.add(file.getPath());
            });
            return stringList;
        }

        private List<File> list(File file) {
            File[] currentDir = file.listFiles();
            for (int i = 0; i < currentDir.length; i++) {
                if (currentDir[i].isDirectory()) {
                    dir.add(currentDir[i]);
                    list(currentDir[i]);
                }
            }
            return dir;
        }*/
    }

    // 4. Sort song lines with list
    public void sortSong() {

          final String SONG =
                "I know that we are young,\n" +
                "And I know that you may love me,\n" +
                "But I just can't be with you like this anymore,\n" +
                "Alejandro,\n" +
                "She's got both hands,\n" +
                "In her pocket,\n" +
                "And she won't look at you,\n" +
                "Won't look at you,\n" +
                "She hides true love,\n" +
                "En su bolsillo,\n" +
                "She's got a halo around her finger,\n" +
                "Around you,\n" +
                "You know that I love you boy,\n" +
                "Hot like Mexico, rejoice,\n" +
                "At this point I've gotta choose,\n" +
                "Nothing to lose,\n" +
                "Don't call my name,\n" +
                "Don't call my name, Alejandro,\n" +
                "I'm not your babe,\n" +
                "I'm not your babe, Fernando,\n" +
                "Don't wanna kiss,\n" +
                "Don't wanna touch.\n";


        List<String> lines = Arrays.asList(SONG.split("\n"));

        Collections.sort(lines, LINE_LENGTH_COMPARATOR);
        for (Iterator it = lines.iterator(); it.hasNext();){
            System.out.println(it.next());
        }
    }

    private static final Comparator<String> LINE_LENGTH_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };

    // 6. Print string from file. Use ArrayList
    public void printStringsFromFile() {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(localPath + "task10.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Collections.sort(list, LINE_LENGTH_COMPARATOR);

        Stream stream = list.stream();
        stream.forEach((element) -> { System.out.println(element); });
    }

    // 7. Check brackets correct position with stack  {,} ; (,) ; [,].
    public static boolean isBracketsMatches(String str) {
        Stack<Character> stack = new Stack<Character>();
        char c;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(' || c == '{')
                stack.push(c);
            else if (stack.empty())
                return false;
            else if (c == ')') {
                if (stack.pop() != '(')
                    return false;
            } else if (c == '}') {
                if (stack.pop() != '{')
                    return false;
            }
        }
        return stack.empty();
    }

    // 8. Print song difference words. Use HashSet
    public void findDifferenceWords() {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(localPath + "task10.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Set<String> set = new HashSet<>();

        list.forEach(line -> {
            String words[] = line.split(" ");

            for (String word : words) {
                set.add(word.toLowerCase());
            }
        });
        Stream stream = set.stream();

        stream.forEach((element) -> { System.out.println(element); });
    }
}
