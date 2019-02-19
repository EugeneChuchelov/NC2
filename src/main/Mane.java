package main;

import xml.Xml;

public class Mane {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Invalid args");
            return;
        }
        Xml xml = new Xml(args[0], args[1]);
        xml.correct();
    }
}
