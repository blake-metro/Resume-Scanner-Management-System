
/*
Class using JUnit to test PDF converter


 */

import groupsix.resume.PDFConverter_PDF_To_TXT;
import groupsix.resume.ResumeProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PDFConverterTest {
    private final PDFConverter_PDF_To_TXT pdfToTxt = new PDFConverter_PDF_To_TXT();

//    @Test //Should only be used if not handling the exception internally, used test 1 to do that
//    void shouldFailIfFileIsNotPDF() {
//        assertThrows(ResumeProcessingException.class, () -> pdfToTxt.convertPDF());
//    }

    @Test   //Test 1
    void shouldHandleInvalidFileGracefully() {
        //Used in conjunction with File folder = new File("src" + File.separator + "main" + File.separator + "ResumeStorage_PDFs_Fails"); //For failing file format tests

        pdfToTxt.convertPDF();
        assertTrue(pdfToTxt.getPDFTextList().isEmpty(), "PDF text list should be empty if only invalid files were present.");
    }

    @Test   //Test 2
    void shouldHandle1PDF() {
        //Used in conjunction with File folder = new File("src" + File.separator + "main" + File.separator + "ResumeStorage_PDFs_Fails"); //For failing file format tests

        pdfToTxt.convertPDF();
        assertTrue(pdfToTxt.getPDFTextList().isEmpty(), "PDF text list should be empty if only invalid files were present.");
    }


}
