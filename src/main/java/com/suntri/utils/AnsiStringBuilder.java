package com.suntri.utils;

/**
 * Author: Chia-Yang, Sun
 * Email: triumph.sun@gmail.com
 */

public class AnsiStringBuilder {

    private StringBuffer sb = new StringBuffer();

    public AnsiStringBuilder reset(){
        this.sb = new StringBuffer();
        return this;
    }

    public AnsiStringBuilder text(String text){
        this.sb.append(text);
        return this;
    }

    public AnsiStringBuilder styles(Ansi.CharAttribute ... attributes){
        this.sb.append(AnsiEscapeSequence.addCharAttributes(attributes));
        return this;
    }

    public AnsiStringBuilder clearAllStyles(){
        this.sb.append(AnsiEscapeSequence.clearAllCharAttributes());
        return this;
    }

    public AnsiStringBuilder eraseToLineEnd(){
        this.sb.append(AnsiEscapeSequence.eraseLine());
        return this;
    }

    public AnsiStringBuilder eraseDisplay(){
        this.sb.append(AnsiEscapeSequence.eraseDisplay());
        return this;
    }

    public AnsiStringBuilder cursorUp(){
        return this.cursorUp(1);
    }

    public AnsiStringBuilder cursorUp(int line){
        this.sb.append(AnsiEscapeSequence.cursorUp(line));
        return this;
    }

    public AnsiStringBuilder cursorDown(){
        return this.cursorDown(1);
    }

    public AnsiStringBuilder cursorDown(int line){
        this.sb.append(AnsiEscapeSequence.cursorDown(line));
        return this;
    }

    public AnsiStringBuilder cursorForward(){
        return this.cursorForward(1);
    }

    public AnsiStringBuilder cursorForward(int column){
        this.sb.append(AnsiEscapeSequence.cursorForward(column));
        return this;
    }

    public AnsiStringBuilder cursorBackward(){
        return this.cursorBackward(1);
    }

    public AnsiStringBuilder cursorBackward(int column){
        this.sb.append(AnsiEscapeSequence.cursorBackward(column));
        return this;
    }

    public AnsiStringBuilder cursorToTopLeft(){
        return this.cursorTo(0, 0);
    }

    public AnsiStringBuilder cursorTo(int line, int column){
        this.sb.append(AnsiEscapeSequence.cursorPosition(line, column));
        return this;
    }

    public AnsiStringBuilder saveCursorPosition(){
        this.sb.append(AnsiEscapeSequence.saveCursorPosition());
        return this;
    }

    public AnsiStringBuilder restoreCursorPosition(){
        this.sb.append(AnsiEscapeSequence.restoreCursorPosition());
        return this;
    }

    @Override
    public String toString(){
        return this.sb.toString();
    }

}
