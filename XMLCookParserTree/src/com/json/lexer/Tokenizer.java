package com.json.lexer;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    public Tokenizer() {
        super();
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
    }

    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^(" + regex + ")"), token));
    }

    public void tokenize(String str) {
        String s = normalizeString(str);
        int totalLength = s.length();
        tokens.clear();
        while (!s.equals("")) {            
            int remaining = s.length();
            boolean match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    System.out.println(tok);
                    s = m.replaceFirst("").trim();
                    tokens.add(new Token(info.token, tok, totalLength - remaining));
                    break;
                }
            }
            if (!match) {
                throw new ParserException("Unexpected character in input: " + s);
            }
        }
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }
    
    private String normalizeString(String str){
        String text = str;
        text = text.replaceAll("\\s+"," ");
        text = text.replaceAll("\\t+"," ");
        text = text.trim(); 
        return text;
    }
    

}
