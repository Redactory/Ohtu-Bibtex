/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.IO;

import main.java.Models.Reference;
import main.java.Models.ReferenceConverter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lutikka
 */
public class IO {

    private IO() {
    }
    public static String readBibTexFile(File file){       
        try {
           //FileReader reader = new FileReader(file); 
            Scanner scan = new Scanner(file).useDelimiter("\\A");
            String string = scan.next();
            scan.close();
            return string;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.print("Io error reading file" +file.getPath());
        }
        return null;
    }
    
    public static boolean exportToBibTex(File file, List<Reference> refs){
        try {
            //FileWriter fw = new FileWriter(file.getAbsoluteFile());
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()),"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Reference ref : refs) {
                bw.write(ReferenceConverter.toBibTex(ref));
            }
            bw.close();
            return true;
        } catch (IOException e) {
            System.out.println("IOError while trying to export into file");
            return false;
        }
    }
}
