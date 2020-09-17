# ANSI Escape Sequence

This java library helps you easily generate ANSI Escape Sequences that may apply in either CLI or TCP Socket environment. 


## Fluent API example

See also in example com.suntri.example.AnsiStringBuilderExample

```java
Ansi.CharAttribute [] emphasis = {
    Ansi.CharAttribute.BOLD, 
    Ansi.CharAttribute.RED_FG 
};

AnsiStringBuilder builder = new AnsiStringBuilder();
builder.styles(emphasis)
       .text("Hello World!")
       .clearAllStyles();

System.out.println(builder.toString());

```