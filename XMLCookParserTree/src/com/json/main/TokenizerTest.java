package com.json.main;

import com.json.lexer.ParserException;
import com.json.lexer.Token;
import com.json.lexer.Tokenizer;
import com.json.parser.Parser;
import com.json.tree.HTMLNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TokenizerTest {

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("{", Token.JSON_OPEN_BRACE_BRACKETS);
        tokenizer.add("}", Token.JSON_CLOSE_BRACE_BRACKETS);  
        tokenizer.add("[", Token.JSON_OPEN_BOX_BRACKETS);
        tokenizer.add("]", Token.JSON_CLOSE_BOX_BRACKETS);  
        tokenizer.add("money_name", Token.JSON_MONEYNAME);
        tokenizer.add("creator", Token.JSON_CREATORNAME);
        tokenizer.add("countries_availability", Token.JSON_COUNTRIESLIST);
        tokenizer.add("coins_denominations", Token.JSON_COINSLIST);
        tokenizer.add("bills_denominations", Token.JSON_BILLSLIST);
        tokenizer.add(":", Token.EQUALS);
        tokenizer.add("\"", Token.COMILLA);
        tokenizer.add(",", Token.COMA);
        tokenizer.add("[a-zA-Z0-9\\s+]+", Token.FREE_TEXT);

        String line, xmldoc = "";
        FileReader fr;
        try {
            fr = new FileReader("money_maker.json");
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                xmldoc += line + "\n";
            }
            br.close();
            fr.close();
        } catch (Exception ex) {

        }

        try {
            tokenizer.tokenize(xmldoc);

            for (Token tok : tokenizer.getTokens()) {
                System.out.println("" + tok.token + " " + tok.sequence);
            }
        } catch (ParserException e) {
            System.out.println(e.getMessage());
        }
        
        Parser p = new Parser();
        HTMLNode html = p.parse(tokenizer.getTokens());
        
        try {
            FileWriter fw = new FileWriter("Receta.html");
            fw.write(html.toString());
            fw.close();
        } catch (Exception ex) {
           
        }
    }
}
