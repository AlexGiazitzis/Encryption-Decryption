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
        this.key = "enc".equals(this.mode) ? this.key : 26 - this.key;

        for (int i = 0; i < this.data.length(); i++) {

            if (this.data.charAt(i) >= 'a' && this.data.charAt(i) <= 'z') {
                str.append((char) ('a' + ((this.data.charAt(i) + this.key) % 'a') % 26));
                continue;
            }

            if (this.data.charAt(i) >= 'A' && this.data.charAt(i) <= 'Z') {
                str.append((char) ('A' + ((this.data.charAt(i) + this.key) % 'A') % 26));
                continue;
            }

            str.append(data.charAt(i));
        }

        return str.toString();
    }
}
