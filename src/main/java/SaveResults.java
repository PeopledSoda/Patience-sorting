import java.io.FileWriter;

public class SaveResults {

    public static void main(String[] args) throws Exception {

        FileWriter writer = new FileWriter("results.csv");

        writer.write("size,time_ns,operations\n");

        for (int i = 1; i <= 70; i++) {

            int[] arr = ReadData.readArray("data/data_" + i + ".txt");
            int size = arr.length;

            SortStats stats = PatienceSortMeasured.patienceSort(arr);

            writer.write(size + "," + stats.time + "," + stats.operations + "\n");
        }

        writer.close();

        System.out.println("Готово! results.csv создан");
    }
}