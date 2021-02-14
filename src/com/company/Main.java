package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Input input = new Input();  //ввод данных
        input.Input();

        Arifmetical arifmetical = new Arifmetical();  //определение арифметического знака и его индекса
        arifmetical.Arifmetical(input.strInput);

        Split split = new Split();  //разделение строки на слагаемые...
        split.Split(input.strInput, arifmetical.indexArifmetical);

        DefineStr1 defineStr1 = new DefineStr1(); //определение первого слагаемоего
        defineStr1.DefineStr1(split.str1);

        DefineStr2 defineStr2 = new DefineStr2(); //определение второго слагаемоего
        defineStr2.DefineStr2(split.str2);

        CalculatorStringInt1 CS1 = new CalculatorStringInt1   //калькулятор строка число
                (defineStr1.defStr1, arifmetical.Arifmetical(input.strInput), defineStr2.defInt2);

        CalculatorString2 CS2 = new CalculatorString2         //калькулятор строка строка
                (defineStr1.defStr1, arifmetical.Arifmetical(input.strInput), defineStr2.defStr2);

    }
}

class Input {    //ввод данных

    String strInput;

    public void Input() {
        Scanner scan = new Scanner(System.in);
        strInput = scan.nextLine();
    }
}

class Arifmetical {        //определение арифметического знака и его индекса
    char plus;
    char minus;
    char multiplay;
    char split;
    int indexArifmetical;

    public Character Arifmetical(String a) {
        if (a.indexOf("+") > 0) {
            plus = '+';
            indexArifmetical = a.indexOf("+");
            return plus;
        } else if (a.indexOf("-") > 0) {
            minus = '-';
            indexArifmetical = a.indexOf("-");
            return minus;
        } else if (a.indexOf("*") > 0) {
            multiplay = '*';
            indexArifmetical = a.indexOf("*");
            return multiplay;
        } else if (a.indexOf("/") > 0) {
            split = '/';
            indexArifmetical = a.indexOf("/");
            return split;
        } else {
            System.out.println("Err123");
            System.exit(0);
        }
        return 0;
    }
}

class Split {       //разделение строки на слагаемые...

    String str1 = "";
    String str2 = "";


    public void Split(String split, int indexSplit) {

        for (int i = 0; i < indexSplit; i++) {
            str1 += split.charAt(i);
        }
        for (int i = indexSplit + 1; i < split.length(); i++) {
            str2 += split.charAt(i);
        }
    }
}

class DefineStr1 {    //определение первого слагаемоего

    String defStr1 = "";

    int firstintIndex;
    int lastIndex;
    Character chr = 0;
    String str = "";

    public void DefineStr1(String def1) {
        if (def1.indexOf("\"") < 0) {          //опредиление наличия кавычек
            System.out.println("Err124");
            System.exit(0);
        }
        if (def1.indexOf("\"") >= 0) {          //определение наличия кавычек в начале и конце
            firstintIndex = def1.indexOf("\"");
            lastIndex = def1.lastIndexOf("\"");
            if (firstintIndex == lastIndex) {
                System.out.println("Err124.1");
                System.exit(0);
            }
        }

        for (int i = 0; i < firstintIndex; i++) { //подсещет строки до первых кавычек(пробел исключение)
            chr = def1.charAt(i);
            str = chr.toString();
            if (str.contentEquals(" ") == false) {
                System.out.println("Err124.2");
                System.exit(0);
            }
        }
        for (int i = lastIndex + 1; i < def1.length(); i++) { //подсещет строки после ласт кавычек(пробел исключение)
            chr = def1.charAt(i);
            str = chr.toString();
            if (str.contentEquals(" ") == false && str.contentEquals("\"") == false) {
                System.out.println("Err124.3");
                System.exit(0);
            }
        }
        for (int i = firstintIndex + 1; i < lastIndex; i++) {  //заполнение основной строки
            defStr1 += def1.charAt(i);
        }
        if (defStr1.length() > 10) {      //длинна строки не больше 10 символов
            System.out.println("Err125.4");
            System.exit(0);
        }

    }
}

class DefineStr2 {
    String defStr2 = "";
    Integer defInt2 = 0;

    int firstintIndex;
    int lastIndex;
    Character chr = 0;
    String str = "";

    public void DefineStr2(String def2) {

        if (def2.indexOf("\"") < 0) {
            str = def2.replace(" ", "");
            defInt2 = Integer.parseInt(str);
            if (defInt2 > 10 || defInt2 < 0) {
                System.out.println("Err126");
                System.exit(0);
            }
            return;
        }
        if (def2.indexOf("\"") < 0) {          //опредиление наличия кавычек
            System.out.println("Err124");
            System.exit(0);
        }
        if (def2.indexOf("\"") >= 0) {          //определение наличия кавычек в начале и конце
            firstintIndex = def2.indexOf("\"");
            lastIndex = def2.lastIndexOf("\"");
            if (firstintIndex == lastIndex) {
                System.out.println("Err124.1");
                System.exit(0);
            }
        }

        for (int i = 0; i < firstintIndex; i++) { //подсещет строки до первых кавычек(пробел исключение)
            chr = def2.charAt(i);
            str = chr.toString();
            if (str.contentEquals(" ") == false) {
                System.out.println("Err124.2");
                System.exit(0);
            }
        }
        for (int i = lastIndex + 1; i < def2.length(); i++) { //подсещет строки после ласт кавычек(пробел исключение)
            chr = def2.charAt(i);
            str = chr.toString();
            if (str.contentEquals(" ") == false && str.contentEquals("\"") == false) {
                System.out.println("Err124.3");
                System.exit(0);
            }
        }
        for (int i = firstintIndex + 1; i < lastIndex; i++) {  //заполнение основной строки
            defStr2 += def2.charAt(i);
        }
        if (defStr2.length() > 20) {      //длинна строки не больше 10 символов
            System.out.println("Err125.4");
            System.exit(0);
        }
    }
}

class CalculatorStringInt1 {

    String result;

    public CalculatorStringInt1(String num1, Character c, int nums2) {
        if (nums2 == 0) {
            //System.out.println("ErrCS1");
            return;
        }
        if (c.equals('+') == true) {
            System.out.println("Err1");
        }
        if (c.equals('-') == true) {
            String minus = "";
            int z = num1.length() - nums2;
            for (int i = 0; i < z; i++) {
                minus += num1.charAt(i);
            }
            result = minus;
        }
        if (c.equals('*') == true) {
            int z = num1.length() * nums2 - num1.length();
            for (int i = 0; i < z; i++) {
                num1 += num1.charAt(i);
            }
            result = num1;
        }
        if (c.equals('/') == true) {
            String split = "";
            int z = num1.length() / nums2;
            for (int i = 0; i < z; i++) {
                split += num1.charAt(i);
            }
            result = split;
        }
        if (result.length() > 41) {
            String s40 = "";
            for (int i = 0; i < 40; i++) {
                s40 += result.charAt(i);
            }
            System.out.println(s40 + "...");
        } else {
            System.out.println(result);
        }
    }
}

class CalculatorString2 {
    public CalculatorString2(String num1, Character c, String num2) {

        if (num2 == "") {
            //System.out.println("ErrCS2");
            return;
        }

        if (c.equals('+') == true) {
            System.out.println(num1 + num2);
        }
        if (c.equals('-') == true) {
            System.out.println(num1.replace(num2, ""));
        }
        if (c.equals('*') == true) {
            System.out.println("ошибка ввода");
        }
        if (c.equals('/') == true) {
            System.out.println("ошибка ввода");
        }
    }
}










