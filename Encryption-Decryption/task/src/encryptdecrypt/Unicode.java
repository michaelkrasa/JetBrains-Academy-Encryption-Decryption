package encryptdecrypt;

public class Unicode {

    public String cipher(String data, int key, String mode) {

        StringBuilder output = new StringBuilder();

        // Add / subtract key to each char
        for (char c : data.toCharArray()) {
            c = mode.equals("enc") ? (char) (c + key) : (char) (c - key);
            output.append(c);
        }
        return output.toString();
    }


}
