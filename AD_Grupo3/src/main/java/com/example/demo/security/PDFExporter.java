package com.example.demo.security;

import java.util.List;

import com.example.demo.models.OfertaModel;
import com.lowagie.text.pdf.PdfTable;

public class PDFExporter {

	private List<OfertaModel> listOfertas;
	
	public PDFExporter(List<OfertaModel> listOfertas)
	{
		this.listOfertas = listOfertas;
	}
	
	private void writeTableHeader(PdfTable table)
	{
		
	}
	
}
