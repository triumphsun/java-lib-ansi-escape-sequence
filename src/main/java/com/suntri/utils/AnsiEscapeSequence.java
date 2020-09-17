package com.suntri.utils;

import com.suntri.utils.Ansi.CharAttribute;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 *
 * ref.
 * http://ascii-table.com/ansi-escape-sequences.php
 * http://ascii-table.com/ansi-escape-sequences-vt-100.php
 */

public class AnsiEscapeSequence {

    public static final char ESC = Ansi.KEY_ESC;
    //public static final char ESC = '\u001B';
    //public static final char ESC = '*';   // for debug usage

    public static String clearAllCharAttributes(){
        return String.format("%c[m", ESC);
    }

    public static String addCharAttributes(CharAttribute... attributes){
        if(attributes.length==0){
            return clearAllCharAttributes();
        } else {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<attributes.length; i++){
                sb.append(String.valueOf(attributes[i].getCode())).append(";");
            }
            String atrs = sb.substring(0, sb.length()-1);
            return String.format("%c[%sm", ESC, atrs);
        }
    }


    public static String cursorUp(){
        return AnsiEscapeSequence.cursorUp(1);
    }

    /**
     * Moves the cursor up by the specified number of lines without changing columns. If the cursor is already on the top line, ANSI.SYS ignores this sequence.
     * @param line number of lines to move
     * @return eg. *[1A
     */
    public static String cursorUp(int line){
        return String.format("%s[%dA", ESC, line);
    }

    public static String cursorDown(){
        return AnsiEscapeSequence.cursorDown(1);
    }

    /**
     * Moves the cursor down by the specified number of lines without changing columns. If the cursor is already on the bottom line, ANSI.SYS ignores this sequence.
     * @param line number of line to move
     * @return eg. *[1B
     */
    public static String cursorDown(int line){
        return String.format("%s[%dB", ESC, line);
    }

    public static String cursorForward(){
        return AnsiEscapeSequence.cursorForward(1);
    }

    /**
     * 	Cursor Forward:
     * Moves the cursor forward by the specified number of columns without changing lines. If the cursor is already in the rightmost column, ANSI.SYS ignores this sequence.
     * @param column number of columns to move
     * @return eg. *[1C
     */
    public static String cursorForward(int column){
        return String.format("%s[%dC", ESC, column);
    }

    public static String cursorBackward(){
        return AnsiEscapeSequence.cursorBackward(1);
    }

    /**
     * Moves the cursor back by the specified number of columns without changing lines. If the cursor is already in the leftmost column, ANSI.SYS ignores this sequence.
     * @param column number of columns to move
     * @return eg. *[1D
     */
    public static String cursorBackward(int column){
        return String.format("%s[%dD", ESC, column);
    }

    public static String cursorPosition(){
        return AnsiEscapeSequence.cursorPosition(0, 0);
    }

    /**
     * Moves the cursor to the specified position (coordinates).
     * If you do not specify a position, the cursor moves to the home position at the upper-left corner of the screen (line 0, column 0).
     * @param line
     * @param column
     * @return eg. *[0,0H
     */
    public static String cursorPosition(int line, int column){
        return String.format("%s[%d;%dH", ESC, line, column);
    }

    /**
     * 	Save Cursor Position:
     * Saves the current cursor position. You can move the cursor to the saved cursor position by using the Restore Cursor Position sequence.
     * @return *[s
     */
    public static String saveCursorPosition(){
        return String.format("%s[s", ESC);
    }

    /**
     * Returns the cursor to the position stored by the Save Cursor Position sequence.
     * @return *[u
     */
    public static String restoreCursorPosition(){
        return String.format("%s[u", ESC);
    }

    /**
     * Clears the screen and moves the cursor to the home position (line 0, column 0).
     * @return *[2J
     */
    public static String eraseDisplay(){
        return String.format("%s[2J", ESC);
    }

    /**
     * Clears all characters from the cursor position to the end of the line (including the character at the cursor position).
     * @return *[K
     */
    public static String eraseLine(){
        return String.format("%s[K", ESC);
    }

    public static String wrap(String content, CharAttribute... attributes){
        return String.format(
                "%s%s%s",
                addCharAttributes(attributes),
                content,
                clearAllCharAttributes()
        );
    }

}
