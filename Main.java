
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String calc(String input) throws IOException {
        String [] array1 = {"1", "2","3","4","5","6","7","8","9","10"};
        String [] arraySymb = {"+","-","*","/"};
        String [] array2 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String [] array3 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String finalResult=null;
        String firstDigit=null;
        String secondDigit=null;
        int a=0;
        int b=0;
        int result=0;

        OUTER:
        for (int i=0; i< arraySymb.length; i++){
            int index= input.indexOf(arraySymb[i]);
            if (index != -1){
                firstDigit = input.substring(0,index);
                secondDigit = input.substring(index+1);
                INNER:
                for (int j=0; j< array1.length; j++){
                    if (firstDigit.equals(array1[j])) {a=j+1;}
                    if (secondDigit.equals(array1[j])) {b=j+1;}
                    if (a!=0 && b!=0){
                        switch (i){
                            case 0: result=a+b;
                                break;
                            case 1: result=a-b;
                                break;
                            case 2: result=a*b;
                                break;
                            case 3: result=a/b;
                                break;
                        }
                        finalResult = String.valueOf(result);
                        break OUTER;
                    }
                    else if (j+1 == array1.length && a==0 && b==0){
                        for(int k=0; k< array2.length; k++){
                            if (firstDigit.equals(array2[k])) {a=k+1;}
                            if (secondDigit.equals(array2[k])) {b=k+1;}
                            if (a!=0 && b!=0){
                                switch (i){
                                    case 0: result=a+b;
                                        break;
                                    case 1: result=a-b;
                                        break;
                                    case 2: result=a*b;
                                        break;
                                    case 3: result=a/b;
                                        break;
                                }
                                if (result>0){
                                    finalResult=array3[result-1];
                                    break OUTER;
                                }
                                else {throw new IOException();}
                            }
                            else if (k+1 == array2.length && (a==0 || b==0)) {throw new IOException();}
                        }
                    }
                    else if (j+1 == array1.length && (a==0 || b==0)){throw new IOException();}

                }
            }
            else if (i+1 == arraySymb.length) {throw new IOException();}
        }
            return finalResult;
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите арифметическое выражение арабскими или римскими числами от 1 до 10 (I - X) формата a+b (со знаками +,-,*,/)");
        String input=scanner.nextLine();
        System.out.println(calc(input));
    }
}







