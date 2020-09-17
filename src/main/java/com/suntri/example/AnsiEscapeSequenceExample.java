package com.suntri.example;

import com.suntri.utils.Ansi;
import com.suntri.utils.AnsiEscapeSequence;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 */

public class AnsiEscapeSequenceExample {

    public static void main(String [] args){
        Ansi.CharAttribute[] BOLD_GREEN = {Ansi.CharAttribute.BOLD, Ansi.CharAttribute.GREEN_FG};
        Ansi.CharAttribute[] RED = {Ansi.CharAttribute.RED_FG, Ansi.CharAttribute.BLINK};

        System.out.println(AnsiEscapeSequence.wrap("Hello World!", BOLD_GREEN));
        System.out.println(AnsiEscapeSequence.wrap("Hello World!", RED));

        //System.out.print(AnsiEscapeSequence.eraseDisplay());
    }

}
