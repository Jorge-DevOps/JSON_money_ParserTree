package com.json.tree;

import java.util.ArrayList;

public class HTMLNode {
     
    private final String tag, text;
    private final ArrayList<TagAttribute> attributes;
    private final ArrayList<HTMLNode> childNodes;

    public HTMLNode(String tag, String text, ArrayList<TagAttribute> attributes) {
        this.tag = tag;
        this.text = text;
        if(attributes != null){
            this.attributes = attributes;
        }else{
            this.attributes = new ArrayList<>();
        }
        this.childNodes = new ArrayList<>();
    }
    
    public void addAttribute(TagAttribute att){
        this.attributes.add(att);
    }
    
    public void addChild(HTMLNode node){
        if(node != null){
            this.childNodes.add(node);
        }
    }
    
  
    @Override
    public String toString(){
        String html = "<" + this.tag;
        html = attributes.stream().map((ta) -> " " + ta.toString()).reduce(html, String::concat);
        html += ">";
        html += text;
        html = childNodes.stream().map((node) -> "\n" + node.toString()).reduce(html, String::concat);
        html += "\n" + "</" + this.tag + ">";
        return html;        
    }  
}
   
    
    

