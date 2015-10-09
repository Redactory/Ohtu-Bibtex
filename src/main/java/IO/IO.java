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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Lutikka
 */
public class IO {

    public IO() {
    }
    //TODO
    public char[] readBibTexFile(File file){       
//        try {
//           FileReader reader = new FileReader(file);
//        } catch (Exception e) {
//            System.err.print("Io error reading file" +file.getPath());
//        }
        return null;
    }
    
    public static boolean exportToBibTex(File file, List<Reference> refs){
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
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
