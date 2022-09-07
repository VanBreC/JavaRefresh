import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class codeRefresher {

    public static void main(String[] args) {

        codeStart();

    }

    public static void codeStart() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a range of numbers");

        String inPut = userInput.nextLine();
        System.out.println("You entered: " + inPut);

        List<Integer> inputToIntList = new codeRefresher().convertList(inPut);
        // System.out.println(inputToIntList);
        double average = new codeRefresher().getAverage(inputToIntList);
        System.out.println("Average of list: " + average);
        // System.out.println(new codeRefresher().convertList(inPut));

        try {
            File myFile = new File("RefresherFile.text");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println(myFile.getName() + " already exists");
            }
            FileWriter myWriter = new FileWriter("RefresherFile.text", true);
            myWriter.append("Entered text: " + inPut + "\nAverage of list: " + average + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An Error Occured");
            e.printStackTrace();
        }

    }

    public double getAverage(List<Integer> intList) {

        double x = 0;
        for (int i = 0; i < intList.size(); i++) {
            int y = intList.get(i);
            x = x + y;
        }
        // System.out.println("Sum of the list: " + x);
        x = x / intList.size();
        // System.out.println("Average of List: " + x);

        return x;

    }

    public List<Integer> convertList(String stringInput) {

        // String to List Conversion
        String convertString[] = stringInput.split(" ");
        // List<String> listString = new ArrayList<String>();
        // listString = Arrays.asList(convertString);

        // String list to Int list Conversion
        int[] convertInt = new int[convertString.length];
        for (int i = 0; i < convertString.length; i++) {
            convertInt[i] = Integer.parseInt(convertString[i]);
        }
        List<Integer> listInt = new ArrayList<Integer>();
        listInt = IntStream.of(convertInt).boxed().collect(Collectors.toList());

        // System.out.println(listString);
        return listInt;

    }

}
