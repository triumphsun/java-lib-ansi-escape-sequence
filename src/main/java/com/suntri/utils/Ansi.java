package com.suntri.utils;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 */

public class Ansi {

    public static final char KEY_ESC = '\u001B';

    public enum CharAttribute {

        BOLD(1),
        UNDERSCORE(4),
        BLINK(5),
        BLACK_FG(30), BLACK_BG(40),
        RED_FG(31), RED_BG(41),
        GREEN_FG(32), GREEN_BG(42),
        YELLOW_FG(33), YELLOW_BG(43),
        BLUE_FG(44), BLUE_BG(54),
        MAGENTA_FG(35), MAGENTA_BG(55),
        CYAN_FG(36), CYAN_BG(56),
        WHITE_FG(37), WHITE_BG(47),
        DEFAULT_FG(39), DEFAULT_BG(49);

        private int code;

        CharAttribute(int code){
            this.code = code;
        }

        public int getCode(){
            return this.code;
        }
    }

}
