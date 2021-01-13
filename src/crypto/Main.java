package crypto;

import cryptoapi.*;

public class Main {
    public static void main(String[] args) {
        CryptoFactory cryptoFactory = new CryptoFactory();
        Crypto crypto = cryptoFactory.produceCrypto(args);
        crypto.getOutput(crypto.modify(), args);
    }
}
