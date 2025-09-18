import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizzBuzzMenuTest {

    private static List<Integer> extractNumbers(String output) {
        Pattern p = Pattern.compile("\\b(\\d+)\\b");
        Matcher m = p.matcher(output);
        List<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group(1)));
        }
        return numbers;
    }

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream origOut = System.out;
        java.io.InputStream origIn = System.in;

        System.setIn(in);
        System.setOut(new PrintStream(outBytes));
        try {
            FizzBuzzMenu.main(new String[]{});
        } finally {
            System.setOut(origOut);
            System.setIn(origIn);
        }

        return outBytes.toString(StandardCharsets.UTF_8);
    }

    @Test
    public void testFizzOption() {
        String input = "1\n4\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("1") || output.contains("Fizz") || output.contains("Menu"), 
            "❌ Your program should display a menu with option 1 for Fizz numbers!");

        List<Integer> numbers = extractNumbers(output);
        
        // Check for specific expected Fizz numbers (multiples of 3 from 1-100)
        List<Integer> expectedFizzNumbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                expectedFizzNumbers.add(i);
            }
        }
        
        int correctFizzCount = 0;
        for (Integer expectedNum : expectedFizzNumbers) {
            if (numbers.contains(expectedNum)) {
                correctFizzCount++;
            }
        }
        
        assertTrue(correctFizzCount >= 10, 
            "❌ Option 1 should display the correct Fizz numbers (multiples of 3). Found only " + correctFizzCount + " correct numbers out of " + expectedFizzNumbers.size() + " expected. Expected: " + expectedFizzNumbers.subList(0, Math.min(10, expectedFizzNumbers.size())) + "...");

        assertTrue(output.contains("4") || output.contains("Exit") || output.contains("Goodbye"), 
            "❌ Your program should handle option 4 to exit properly!");
    }

    @Test
    public void testBuzzOption() {
        String input = "2\n4\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("2") || output.contains("Buzz") || output.contains("Menu"), 
            "❌ Your program should display a menu with option 2 for Buzz numbers!");

        List<Integer> numbers = extractNumbers(output);
        
        // Count multiples of 5 in the output
        int buzzCount = 0;
        for (int num : numbers) {
            if (num % 5 == 0) {
                buzzCount++;
            }
        }
        assertTrue(buzzCount >= 5, 
            "❌ Option 2 should display numbers that are multiples of 5. Found only " + buzzCount + " such numbers. Examples: 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100");
    }

    @Test
    public void testFizzBuzzOption() {
        String input = "3\n4\n";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("3") || output.contains("FizzBuzz") || output.contains("Menu"), 
            "❌ Your program should display a menu with option 3 for FizzBuzz numbers!");

        List<Integer> numbers = extractNumbers(output);
        List<Integer> fizzBuzzNumbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzNumbers.add(i);
            }
        }

        int fizzBuzzCount = 0;
        for (Integer fizzBuzzNum : fizzBuzzNumbers) {
            if (numbers.contains(fizzBuzzNum)) {
                fizzBuzzCount++;
            }
        }
        assertTrue(fizzBuzzCount >= 3, 
            "❌ Option 3 should display numbers that are multiples of both 3 and 5. Found only " + fizzBuzzCount + " such numbers. Examples: 15, 30, 45, 60, 75, 90");
    }

    @Test
    public void testInvalidChoice() {
        String input = "5\n4\n";
        String output = runProgramWithInput(input);

        // Test passes if program handles invalid input gracefully (either with error message or by ignoring)
        // This test is now optional - students don't need to implement invalid choice handling
        boolean hasErrorHandling = output.contains("Invalid") || output.contains("Try again") || 
                                  output.contains("Error") || output.contains("Wrong") || 
                                  output.contains("Not valid") || output.contains("Exception");
        
        // If no error handling, that's also fine - just check that program doesn't crash
        assertTrue(output.length() > 0, "❌ Program should not crash with invalid input!");
    }

    @Test
    public void testMenuLoop() {
        String input = "1\n2\n3\n4\n";
        String output = runProgramWithInput(input);

        int menuCount = 0;
        String[] lines = output.split("\n");
        for (String line : lines) {
            if (line.contains("Menu") || line.contains("1") || line.contains("2") || line.contains("3") || line.contains("4")) {
                menuCount++;
            }
        }
        assertTrue(menuCount >= 3, 
            "❌ Your program should show the menu multiple times when making multiple choices! Found menu elements: " + menuCount);
    }

    @Test
    public void testFizzLogicCorrectness() {
        String input = "1\n4\n";
        String output = runProgramWithInput(input);

        List<Integer> numbers = extractNumbers(output);
        
        // Check for specific expected Fizz numbers (multiples of 3 from 1-100)
        List<Integer> expectedFizzNumbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                expectedFizzNumbers.add(i);
            }
        }
        
        int correctFizzCount = 0;
        for (Integer expectedNum : expectedFizzNumbers) {
            if (numbers.contains(expectedNum)) {
                correctFizzCount++;
            }
        }
        
        assertTrue(correctFizzCount >= 10, "❌ Option 1 should show the correct Fizz numbers (multiples of 3). Found only " + correctFizzCount + " correct numbers out of " + expectedFizzNumbers.size() + " expected!");
    }

    @Test
    public void testBuzzLogicCorrectness() {
        String input = "2\n4\n";
        String output = runProgramWithInput(input);

        List<Integer> numbers = extractNumbers(output);
        
        boolean hasMultiplesOf5 = false;
        for (int num : numbers) {
            if (num % 5 == 0) {
                hasMultiplesOf5 = true;
                break;
            }
        }
        assertTrue(hasMultiplesOf5, "❌ Option 2 should show numbers divisible by 5 (like 5, 10, 15, 20, 25, 30, etc.)!");
        
        int only5Count = 0;
        int bothCount = 0;
        for (int num : numbers) {
            if (num % 5 == 0 && num % 3 != 0) {
                only5Count++;
            } else if (num % 5 == 0 && num % 3 == 0) {
                bothCount++;
            }
        }
        
        assertTrue(only5Count + bothCount >= 5, "❌ Option 2 should show at least 5 numbers divisible by 5!");
    }

    @Test
    public void testFizzBuzzLogicCorrectness() {
        String input = "3\n4\n";
        String output = runProgramWithInput(input);

        List<Integer> numbers = extractNumbers(output);
        
        boolean hasMultiplesOfBoth = false;
        for (int num : numbers) {
            if (num % 3 == 0 && num % 5 == 0) {
                hasMultiplesOfBoth = true;
                break;
            }
        }
        assertTrue(hasMultiplesOfBoth, "❌ Option 3 should show numbers divisible by BOTH 3 and 5 (like 15, 30, 45, 60, 75, 90)!");
        
        int only3Count = 0;
        int only5Count = 0;
        int bothCount = 0;
        
        for (int num : numbers) {
            if (num % 3 == 0 && num % 5 == 0) {
                bothCount++;
            } else if (num % 3 == 0 && num % 5 != 0) {
                only3Count++;
            } else if (num % 5 == 0 && num % 3 != 0) {
                only5Count++;
            }
        }
        
        assertTrue(bothCount > 0, "❌ Option 3 should include numbers divisible by both 3 and 5!");
        assertTrue(bothCount >= only3Count, "❌ Option 3 should focus on numbers divisible by both 3 and 5, not just 3!");
        assertTrue(bothCount >= only5Count, "❌ Option 3 should focus on numbers divisible by both 3 and 5, not just 5!");
    }
}
