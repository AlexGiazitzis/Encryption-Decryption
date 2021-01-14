package cryptoapi;

/**
 * @author AlexGiazitzis at 13-January-2021 : 9:45 PM
 * @project Encryption-Decryption
 */

class CaesarCipher extends Crypto {

    CaesarCipher(String[] args) {
        super(args);
    }

    @Override
    public String modify() {

        StringBuilder str = new StringBuilder();
        key = "enc".equals(mode) ? key : 26 - key;

        for (int i = 0; i < data.length(); i++) {

            if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z') {
                str.append((char) ('a' + ((data.charAt(i) + key) % 'a') % 26));
                continue;
            }

            if (data.charAt(i) >= 'A' && data.charAt(i) <= 'Z') {
                str.append((char) ('A' + ((data.charAt(i) + key) % 'A') % 26));
                continue;
            }

            str.append(data.charAt(i));
        }

        return str.toString();
    }
}
