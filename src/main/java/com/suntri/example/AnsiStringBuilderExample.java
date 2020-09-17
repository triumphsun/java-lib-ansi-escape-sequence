package com.suntri.example;

import com.suntri.utils.Ansi;
import com.suntri.utils.AnsiStringBuilder;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 */

public class AnsiStringBuilderExample {

    public static void main(String [] args){
        AnsiStringBuilder builder = new AnsiStringBuilder();

        Ansi.CharAttribute [] red = {Ansi.CharAttribute.RED_FG, Ansi.CharAttribute.BOLD};
        Ansi.CharAttribute [] green = {Ansi.CharAttribute.GREEN_FG};

        builder.styles(red).text("Hello World.").clearAllStyles().eraseToLineEnd();
        System.out.println(builder);

        builder.reset().text("Hello World.").eraseToLineEnd();
        System.out.println(builder);

        builder.reset().cursorDown(3).cursorForward(30).styles(green).text("Hello World").clearAllStyles();
        System.out.println(builder);
    }

}
