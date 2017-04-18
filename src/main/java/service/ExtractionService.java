package service;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.ejb.Stateless;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Stateless
public class ExtractionService {

    public String extraireDonnees(File pdf) throws IOException {

        PDDocument doc = PDDocument.load(pdf);
        return new PDFTextStripper().getText(doc);

    }
}
