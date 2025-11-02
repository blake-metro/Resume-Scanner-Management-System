
/*
Class using JUnit to test PDF converter


 */

import groupsix.resume.PDFConverter_PDF_To_TXT;
import groupsix.resume.ResumeProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PDFConverterTest {
    private PDFConverter_PDF_To_TXT pdfToTxt = new PDFConverter_PDF_To_TXT();

    @Test
    void shouldFailIfFileIsNotPDF() {
        assertThrows(ResumeProcessingException.class, () -> {
            pdfToTxt.convertPDF();
        });
    }


}
