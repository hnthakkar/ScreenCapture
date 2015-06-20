package com.screenshot;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
	 
public class CreatePDF {
 
	public static void main(String[] args){
		try{
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.dir") + "/result.pdf"));
			document.open();
			File d = new File(System.getProperty("user.dir"));  
			File[] files = d.listFiles();
			Image img;
			for(File file:files){
				if(file.getName().startsWith("screen") && file.getName().endsWith("PNG")){
					img = Image.getInstance(System.getProperty("user.dir") + "/"+ file.getName());
					img.scalePercent(42);
					Paragraph p = new Paragraph("*******New Image******* ");
					document.add(p);
					document.add(img);
				}
			}
			document.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error creating pdf");
		}
	}
    
}
	 

