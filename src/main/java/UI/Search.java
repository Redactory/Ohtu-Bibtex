/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import IO.IO;
import Models.Reference;
import Models.ReferenceConverter;
import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author teemu
 */
public class Search {

    private Scanner scanner;
    
    public Search() {
        scanner = new Scanner(System.in, "ISO-8859-1");
    }

    // Method for finding wanted reference.
    public Reference findReference() {
        String string = "";
        Integer ref_id = -1;
        Reference reference = new Reference();

        string = IO.readBibTexFile(new File("bib_data.bib"));
        List<Reference> references = ReferenceConverter.bibTexToReference(string);

        for (Reference r : references) {
            if (r.getReference_id() == ref_id) {
                reference = r;
            }
        }

        return reference;
    }

    // Method for deleting reference from system.
    public void deleteReference() {
        String string = "";
        String answer = "";
        Integer ref_id = -1;
        boolean ok = false;

        string = IO.readBibTexFile(new File("bib_data.bib"));
        List<Reference> references = ReferenceConverter.bibTexToReference(string);

        // finding out needed reference-id for deleting reference.
        while (ok == false) {
            System.out.println("Do you want to see list of references? Press 'Y' for yes, "
                    + "and any key is not.");
            answer = scanner.nextLine();
            
            // List references if needed.
            if (answer.equals("Y")) {
                for(Reference r : references){
                    System.out.println(r);
                }
            } else {
                System.out.println("Give Id of the to-be-deleted reference.\n ");
                ref_id = scanner.nextInt();
            }
        }

        for (Reference r : references) {
            if (r.getReference_id() == ref_id) {
                references.remove(r);
            }
        }

    }
}
