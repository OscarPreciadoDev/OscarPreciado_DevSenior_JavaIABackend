/*
Este programa lee la entrada hasta que recibe una q
 */

import java.util.Scanner;

public class N23BreakDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch;

        for (;;) {
            ch = sc.next().charAt(0);
            if (ch == 'q') break;
        }
        System.out.println("Introdujo una q.");
        sc.close();
    }
}
