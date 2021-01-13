package cryptoapi;

/**
 * @author AlexGiazitzis at 13-January-2021 : 9:45 PM
 * @project Encryption-Decryption
 */

import java.util.Arrays;



public class CryptoFactory {
    public Crypto produceCrypto(String[] args) {

        String alg = "shift";
        if (Arrays.asList(args).contains("-alg")) {
            alg = args[Arrays.asList(args).indexOf("-alg") + 1];
        }

        switch (alg) {
            case "shift":
                return new CaesarCipher(args);
            case "unicode":
                return new UnicodeCipher(args);
            default:
                return null;
        }
    }
}