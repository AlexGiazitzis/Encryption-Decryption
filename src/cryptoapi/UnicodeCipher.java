package cryptoapi;

/**
 * @author AlexGiazitzis at 13-January-2021 : 9:45 PM
 * @project Encryption-Decryption
 */

class UnicodeCipher extends Crypto {

    UnicodeCipher(String[] args) {
        super(args);
    }

    @Override
    public String modify() {
        StringBuilder str = new StringBuilder();
        int sign = "enc".equals(mode) ? 1 : -1;

        for (int i = 0; i < data.length(); i++) {
            str.append((char) (data.charAt(i) + sign * key));
        }

        return str.toString();
    }
}
