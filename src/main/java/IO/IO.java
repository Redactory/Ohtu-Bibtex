/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import Models.Reference;
import Models.ReferenceConverter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.NotDirectoryException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lutikka
 */
public class IO {

    private IO() {
    }

    /**
     * back and into test directory
     *
     * @param dir
     * @return
     */
    public static List<String> listFilesInDirectory(String dir) {
        File f = new File(dir);
        if (!f.isDirectory()) {
            return null;
        }
        String[] l = f.list();
        LinkedList<String> list = new LinkedList();
        for (String l1 : l) {
            //greedy anything + .bib
            if (l1.matches(".+\\.bib")) {
                list.add(l1);
            }
        }
        return list;
    }

    public static String readBibTexFile(File file) {
        try {
            //FileReader reader = new FileReader(file); 
            Scanner scan = new Scanner(file).useDelimiter("\\A");
            if (!scan.hasNext()) {
                return "";
            }
            String string = scan.next();
            scan.close();
            return string;
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            System.err.print("Io error reading file: " + file.getPath() + ". ");
        }
        return null;
    }

    /**
     * Folder of this file has to exist<<
     *
     * @param file
     * @param refs
     * @return
     */
    public static boolean exportToBibTex(File file, List<Reference> refs) {
        try {
            //FileWriter fw = new FileWriter(file.getAbsoluteFile());
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file.getAbsoluteFile()));
            BufferedWriter bw = new BufferedWriter(osw);
            for (Reference ref : refs) {
                bw.write(ReferenceConverter.toBibTex(ref));
            }
            bw.flush();
            bw.close();
            return true;
        } catch (IOException e) {
            System.out.println("IOError while trying to export into file");
            return false;
        }
    }
}
