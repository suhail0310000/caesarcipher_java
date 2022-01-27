public class CaesarCipher {
    private String alfa = " ABCDEFGHIJKLMNOPQRSTUVWXYZØÆÅ";

    public String encrypt(String plainTxt, int key) {

        String cipherTxt = "";
        //insensitive algorithm
        plainTxt = plainTxt.toUpperCase();

        for(int i=0;i<plainTxt.length();i++) {
            char character = plainTxt.charAt(i);
            // index of that character in the alphabet
            int charIndex = alfa.indexOf(character);
            // shift of characters according to the key
            int encryptedIndx = Math.floorMod(charIndex+key, alfa.length());
            if(charIndex == 0){
                encryptedIndx = 0;
            }
            cipherTxt += alfa.charAt(encryptedIndx);
        }

        return cipherTxt;
    }

    public String decrypt(String cipherText, int key) {
        String plainTxt = "";
        //same method as above
        for(int i=0;i<cipherText.length();++i) {
            char character = cipherText.charAt(i);
            int charIndex = alfa.indexOf(character);
            int decryptedIndx = Math.floorMod(charIndex-key, alfa.length());
            if(charIndex == 0){
                decryptedIndx = 0;
            }
            plainTxt += alfa.charAt(decryptedIndx);
        }

        return plainTxt;
    }
}
