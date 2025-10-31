package groupsix.resume;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



/*
Class dedicated to taking in a PDF and creating a String list to be used elsewhere
 */



public class PDFConverter_PDF_To_TXT {
    private ArrayList<String> pdfTextList;


    public PDFConverter_PDF_To_TXT(){
        pdfTextList = new ArrayList<String>();

    }


    public void convertPDF(){ //will convert all files that are in the
        try{

            File folder = new File("src" + File.separator + "ResumeStorage_PDFs"); //File.separator makes it so it can work on any OS

            PDDocument currentPDF = null; //Instantiate for multiple uses
            PDFTextStripper pdfStripper = new PDFTextStripper(); //Used to parse the pdf and convert contents to text
            String currentPDFText = null; //Instantiate for multiple uses

            if(folder.isDirectory()) {
                for (File pdfFile : folder.listFiles()) {
                    if (pdfFile.isFile()) {
                        if (pdfFile.getName().endsWith(".pdf")) {
                            currentPDF = PDDocument.load(pdfFile);
                            currentPDFText = pdfStripper.getText(currentPDF);
                            pdfTextList.add(currentPDFText);
                            currentPDF.close();
                        } else {
                            throw new IllegalArgumentException("One or more files in folder are not PDFs");
                        }
                    }

                }
            }

        } catch (IOException e){
            e.printStackTrace();
            System.err.println("IO error: " + e.getMessage());
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            System.err.println("Illegal argument, files must be a .pdf: " + e.getMessage());
        } catch (NullPointerException e){
            e.printStackTrace();
            System.err.println("Null pointer exception, folder should not be empty: " + e.getMessage());
        }
    }

    public ArrayList<String> getPDFTextList() {
        return pdfTextList;
    }
}



