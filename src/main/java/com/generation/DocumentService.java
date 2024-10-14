package com.generation;

import com.generation.model.Album;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocumentService {

    public void creatDocument(List<Album> albums){
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun paragRun = paragraph.createRun();
        paragRun.setText("Tarmoqdagi albomlar");
        paragRun.setBold(true);
        paragRun.setFontSize(25);
        paragRun.addBreak();

        for (Album album : albums) {
            XWPFParagraph albumParag = document.createParagraph();
            XWPFRun albumParagRun = albumParag.createRun();
            albumParagRun.setBold(true);
            albumParagRun.setText("ALBUM NOMER: " + album.getId());
            albumParagRun.addBreak();
            albumParagRun.setText("USER ID: " + album.getUserId());
            albumParagRun.addBreak();
            albumParagRun.setText("TITLE : " + album.getTitle());
            albumParagRun.addBreak();
        }


        try {
            FileOutputStream outputStream = new FileOutputStream("album.docx");
            document.write(outputStream);
            document.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
