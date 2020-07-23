package encryptdecrypt;

public class Shift {

    public String enc(String data, int key) {
        StringBuilder out = new StringBuilder();
        int newPos;

        for (char c : data.toCharArray()) {

            // Modify char position if alphabetical
            if (Character.isAlphabetic(c)) {
                // Two 'circles' for upper and lower case
                if (Character.isUpperCase(c)) {
                    newPos = (c - 'A' + key) % 26;
                    c = (char) ('A' + newPos);
                } else {
                    newPos = (c - 'a' + key) % 26;
                    c = (char) ('a' + newPos);
                }
            }
            out.append(c);
        }
        return out.toString();
    }

    public String cipher(String data, int key, String mode) {

        if (mode.equals("enc")) {
            return enc(data, key);
        } else {
            return enc(data, 26 - (key % 26));
        }
    }
}
