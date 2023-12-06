import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     *
     *
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int lines = countLinesInFile(fileName);
        int[] str = new int[lines];
        int in = 0;
        int increase = 0;
        while (scanner.hasNextLine()) {
            str[in++] = scanner.nextInt();
        }
        for (int i = 1; i < str.length; i++) {
            if (str[i] > str[i - 1]) {
                increase++;
            }
        }
        return increase;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int[] array = new int[countLinesInFile(fileName)];
        int in = 0;
        while (scanner.hasNextLine()) {
            array[in++] = scanner.nextInt();
        }
        int last = array[0] + array[1] + array[2];
        int now;
        int result = 0;
        for (int i = 1; i < array.length - 3; i++) {
            now = array[i] + array[i + 1] + array[i + 2];
            if (now > last) {
                result++;
            }
            last = now;

        }
        return result;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String[] array = new String[countLinesInFile(fileName)];
        int in = 0;
        while (scanner.hasNextLine()) {
            array[in++] = scanner.nextLine();
        }
        char c;
        int i;
        int horizontal = 0;
        int depth = 0;
        for (String a : array) {
            c = a.charAt(a.length() - 1);
            i = Character.getNumericValue(c);
            if (a.contains("up"))
                depth -= i;
            else if (a.contains("down")) {
                depth += i;
            } else {
                horizontal += i;
            }
        }
        return horizontal * depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[] array = new String[countLinesInFile(filename)];
        int in = 0;
        while (scanner.hasNextLine()) {
            array[in++] = scanner.nextLine();
        }
        char c;
        int i;
        int aim = 0;
        int depth = 0;
        int horizontal = 0;
        for (String a : array) {
            c = a.charAt(a.length() - 1);
            i = Character.getNumericValue(c);
            if (a.contains("up"))
                aim -= i;
            else if (a.contains("down")) {
                aim += i;
            } else {
                horizontal += i;
                depth += i * aim;
            }
        }
        return horizontal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}