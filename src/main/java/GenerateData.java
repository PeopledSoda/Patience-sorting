import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;

public class GenerateData {
    public static void main(String[] args) throws IOException{
        Random rand = new Random();

        int datasets = 70;
        for (int i = 0; i <= datasets;i++){
            int size = 100 + rand.nextInt(9901);

            FileWriter writer = new FileWriter("data/data_" + i + ".txt");

            for (int j = 0; j <size;j++){
                int num = rand.nextInt(100000);

                writer.write(num+" ");
            }
            writer.close();

        }
        System.out.println("Данные сгенерированы");
    }
}
