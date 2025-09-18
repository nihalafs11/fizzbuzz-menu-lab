# While Loop & Switch Statement Lab - FizzBuzz Menu

## **Objective**
Create a Java program that implements a FizzBuzz menu system using **while loops** and **switch statements**.

## **Requirements**

### **Core Functionality**
Your program must implement a menu-driven FizzBuzz application with the following features:

1. **While Loop**: The program should continue running until the user chooses to exit
2. **Switch Statement**: Handle menu choices using a switch statement
3. **Menu Options**:
   - Option 1: Display Fizz numbers (multiples of 3)
   - Option 2: Display Buzz numbers (multiples of 5)
   - Option 3: Display FizzBuzz numbers (multiples of both 3 and 5)
   - Option 4: Exit the program

### **FizzBuzz Logic**
- **Fizz**: Numbers divisible by 3 (e.g., 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99)
- **Buzz**: Numbers divisible by 5 (e.g., 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100)
- **FizzBuzz**: Numbers divisible by both 3 and 5 (e.g., 15, 30, 45, 60, 75, 90)

### **Program Structure**
```java
import java.util.Scanner;

// DO NOT CHANGE THE CLASS NAME, IT WILL BREAK THE AUTO GRADER
public class FizzBuzzMenu {
    public static void main(String[] args) {
        // Your implementation here
    }
}
```

**⚠️ Important**: Do not change the class name `FizzBuzzMenu` as it will break the autograder!

**Getting Started**

### **Menu Display**
- Display a clear menu with options 1-4
- Show the menu repeatedly until the user exits
- You can format the menu however you like!

### **Input Handling**
- Use `Scanner` to read user input
- Use `scanner.nextInt()` to read menu choices
- Handle the input in a switch statement

### **Number Display**
- Print numbers on the same line with spaces
- Add a newline after each option's output

### **Example Output**
```
--- FizzBuzz Menu ---
1. Fizz (Multiples of 3)
2. Buzz (Multiples of 5)
3. FizzBuzz (Multiples of 3 and 5)
4. Exit
Enter your choice: 1
3 6 9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60 63 66 69 72 75 78 81 84 87 90 93 96 99

--- FizzBuzz Menu ---
1. Fizz (Multiples of 3)
2. Buzz (Multiples of 5)
3. FizzBuzz (Multiples of 3 and 5)
4. Exit
Enter your choice: 4
Goodbye!
```

### **Try using IntelliJ or Bluejay to Complete This Lab**

### **What Must Stay the Same**
- **Class name**: `FizzBuzzMenu`
- **Method signature**: `public static void main(String[] args)`
- **Core logic**: FizzBuzz mathematical rules
- **Menu options**: 1, 2, 3, 4 with the specified functionality

### **Compilation Errors**
- Make sure your class name is `FizzBuzzMenu`
- Check that you have proper Java syntax
- Make all braces `{}` are properly matched

### **Runtime Errors**
- Make sure you're using `scanner.nextInt()` for menu choices
- Check that your while loop has a proper exit condition
- Verify that your switch statement handles all cases

## **Learning Objectives**

By completing this lab, you will demonstrate understanding of:
- **While loops**: Creating repeating program flow
- **Switch statements**: Handling multiple conditional branches
- **Scanner input**: Reading user input from the console
- **Modulo operator**: Using `%` to check divisibility
- **Control flow**: Combining loops and conditionals
- **Problem solving**: Breaking down complex requirements into manageable parts
