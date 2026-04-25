import java.io.*;
import java.util.*;

public class ReadData {
    public static int[] readArray(String filename) throws IOException{
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = reader.readLine();
        String[] parts = line.split(" ");

        for (String p : parts){
            if (p.isEmpty()){
                list.add(Integer.parseInt(p));
            }
        }
        reader.close();

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
