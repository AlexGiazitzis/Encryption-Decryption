package cryptoapi;

/**
 * @author AlexGiazitzis at 13-January-2021 : 9:45 PM
 * @project Encryption-Decryption
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;




public abstract class Crypto {

    protected String mode;
    protected int key;
    protected String data;
    protected String outputMethod;

    Crypto(String[] args) {
        this.mode = setMode(args);
        this.key = setKey(args);
        String dataType = setDataType(args);
        this.outputMethod = setOutputMethod(args);
        this.data = setData(dataType, args);
    }

    private String setMode(String[] args) {

        if (Arrays.asList(args).contains("-mode"))
            return args[Arrays.asList(args).indexOf("-mode") + 1];
        else
            return "enc";
    }

    private int setKey(String[] args) {

        if (Arrays.asList(args).contains("-key"))
            return Integer.parseInt(args[Arrays.asList(args).indexOf("-key") + 1]);
        else
            return 0;
    }

    private String setDataType(String[] args) {

        if (Arrays.asList(args).contains("-data"))
            return "-data";
        else if (Arrays.asList(args).contains("-in"))
            return "-in";
        else
            return "-empty";
    }

    private String setOutputMethod(String[] args) {

        if (Arrays.asList(args).contains("-out"))
            return "-out";
        else
            return "";
    }

    private String setData(String dataType, String[] args) {

        if ("-data".equals(dataType))
            return args[Arrays.asList(args).indexOf("-data") + 1];

        else if ("-in".equals(dataType)) {
            String fileData = "";
            File file = new File(args[Arrays.asList(args).indexOf("-in") + 1]);

            try (Scanner scanner = new Scanner(file)) {

                fileData = scanner.nextLine();
            } catch (FileNotFoundException e) {

                System.out.println("Error");
                return null;
            }

            return fileData;
        }

        return "";
    }

    public abstract String modify();

    public final void getOutput(String modifiedData, String[] args) {

        if ("".equals(this.outputMethod))
            System.out.println(modifiedData);
        else {
            try (FileWriter writer = new FileWriter(args[Arrays.asList(args).indexOf("-out") + 1])) {
                writer.write(modifiedData);
            } catch (IOException e) {
                System.out.println("An exception error occurred: " + e.getMessage());
            }
        }
    }
}



