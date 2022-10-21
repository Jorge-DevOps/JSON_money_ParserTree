package com.json.lexer;

public class Token {

    public static final int JSON_OPEN_BRACE_BRACKETS = 0;
    public static final int JSON_CLOSE_BRACE_BRACKETS = 1;
    public static final int JSON_OPEN_BOX_BRACKETS = 2;
    public static final int JSON_CLOSE_BOX_BRACKETS = 3;
    public static final int JSON_MONEYNAME = 4;
    public static final int JSON_CREATORNAME = 5;
    public static final int JSON_CURRENCYSYMBOL = 6;
    public static final int JSON_COUNTRIESLIST = 7;
    public static final int JSON_COINSLIST = 8;
    public static final int JSON_BILLSLIST = 9;
    public static final int FREE_TEXT = 10;
    public static final int EQUALS = 11;
    public static final int COMA = 12;
    public static final int COMILLA = 13;
    public static final int EPSILON = 14;


    
    public final int token;
    public final String sequence;
    public final int pos;

    public Token(int token, String sequence, int pos) {
        super();
        this.token = token;
        this.sequence = sequence;
        this.pos = pos;
    }
    
    public Token clone(){
        return new Token(this.token, this.sequence, this.pos);
    }

    @Override
    public String toString() {
        return this.sequence;                
    }

}
