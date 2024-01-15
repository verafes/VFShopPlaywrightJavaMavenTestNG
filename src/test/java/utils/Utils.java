package utils;

public class Utils {

    /**
     * Method to print ASCII values of each character in actual and expected texts
     * for troubleshooting mismatch
     * @param actualText
     * @param expectedText
     */
    public void printText(String actualText, String expectedText) {
        System.out.println("Actual Text ASCII Values:");
        for (int i = 0; i < actualText.length(); i++) {
            char c = actualText.charAt(i);
            System.out.println((int) c + " - " + c);
        }

        System.out.println("Expected Text ASCII Values:");
        for (int i = 0; i < expectedText.length(); i++) {
            char c = expectedText.charAt(i);
            System.out.println((int) c + " - " + c);
        }
    }
}
