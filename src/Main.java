import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path =
                args.length > 0 && args[0].length() > 0
                ? args[0]
                : "input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String line = reader.readLine();
            while (line != null){

                line = line.replaceAll("[0-9]", "");

                line = line.replaceAll("^noun", "");
                line = line.replaceAll("^adj.", "");
                line = line.replaceAll("^p. v.", "");
                line = line.replaceAll("^phr.", "");
                line = line.replaceAll("^adv.", "");
                line = line.replaceAll("^verb", "");

                line = line.replaceAll("нет перевода", "");

                line = line.replaceAll(" — ", "\t");

                if(!line.isEmpty()) {
                    //System.out.println(line);
                    writer.write(line + "\r\n");
                }
                line = reader.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
