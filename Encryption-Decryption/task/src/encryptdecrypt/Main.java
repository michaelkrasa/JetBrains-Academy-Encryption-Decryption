package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String mode = "enc";
        int key = 0;
        String data = null;
        String out = null;
        String in = null;
        String alg = "shift"; // default algorithm

        // Reading args
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode": mode = args[++i]; break;
                case "-key": key = Integer.parseInt(args[++i]); break;
                case "-data": data = args[++i]; break;
                case "-out": out = args[++i]; break;
                case "-in": in = args[++i]; break;
                case "-alg": alg = args[++i]; break;
            }
        }

        // Reading data from file if 'in' is set
        if (in != null) {
            File file = new File(in);
            Scanner sc = new Scanner(file);
            data = sc.nextLine();
            sc.close();
        }

        // Encryption / decryption using the chosen algorithm
        String output;
        if (alg.equals("unicode")) {
            Unicode u = new Unicode();
            output = u.cipher(data, key, mode);
        } else {
            Shift s = new Shift();
            output = s.cipher(data, key, mode);
        }

        // Write to file if 'out' is set
        if (out != null) {
            File file = new File(out);
            FileWriter fw = new FileWriter(file);
            fw.write(output);
            fw.close();
        } else {
            System.out.println(output);
        }
    }
}