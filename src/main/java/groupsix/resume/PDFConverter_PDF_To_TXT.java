package groupsix.resume;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;



/*
Class dedicated to taking in a PDF and creating a String list to be used elsewhere
 */



public class PDFConverter_PDF_To_TXT {
    private final ArrayList<String> pdfTextList;


    public PDFConverter_PDF_To_TXT(){
        pdfTextList = new ArrayList<>(); //Don't
        System.out.println("PDFConverter_PDF_To_TXT");
    }


    public void convertPDF(){ //will convert all files that are in the src/ResumeStorage_PDFs directory
        try{
            System.out.println("Inside convertPDF");
            //File.separator makes it so it can work on any OS, path is: src/main/ResumeStorage_PDFs
//            File folder = new File("src" + File.separator + "main" + File.separator + "ResumeStorage_PDFs"); //Main one for production
            File folder = new File("src" + File.separator + "main" + File.separator + "ResumeStorage_PDFs_Passes"); //For passing file format tests
//            File folder = new File("src" + File.separator + "main" + File.separator + "ResumeStorage_PDFs_Fails"); //For failing file format tests

            System.out.println("Found folder: " + folder.getName());

            PDDocument currentPDF = null; //Instantiate for multiple uses
            String currentPDFText = null; //Instantiate for multiple uses
            PDFTextStripper pdfStripper = new PDFTextStripper(); //Used to parse the pdf and convert contents to text


            if(folder.isDirectory() && folder.listFiles()!= null) { //folder.listFiles() can be null if doesn't exist or isn't a directory
                for (File pdfFile : Objects.requireNonNull(folder.listFiles())) {
                    if (pdfFile.isFile()) {
                        System.out.println("Accessing file: " + pdfFile.getName());
                        if (pdfFile.getName().endsWith(".pdf")) {
                            currentPDF = PDDocument.load(pdfFile);
                            currentPDFText = pdfStripper.getText(currentPDF);
                            pdfTextList.add(currentPDFText);
                            currentPDF.close();
                        } else {
                            throw new ResumeProcessingException("Unsupported file format: " + pdfFile.getName());
                        }
                    }

                }
            }

        } catch (IOException e){
            e.printStackTrace();
            System.err.println("IO error: " + e.getMessage());
        } catch (ResumeProcessingException e){
            e.printStackTrace();
            System.err.println("Unsupported file format: " + e.getMessage());
        }
    }

    public ArrayList<String> getPDFTextList() {
        return pdfTextList;
    }
}



