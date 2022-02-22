package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.example.demo.models.CicloModel;
import com.example.demo.models.OfertaModel;
import com.lowagie.text.DocumentException;

@Service
public class PdfService {

	@Autowired
	private TemplateEngine templateEngine;

	public void createPdf(CicloModel ciclo, List<OfertaModel> ofertas) throws IOException, DocumentException {


		Context context = new Context();
		context.setVariable("nombre", ciclo.getNombre());
		context.setVariable("tipo", ciclo.getTipo());
		context.setVariable("ofertas", ofertas);
		String processHtml = templateEngine.process("helloworld", context);

		OutputStream outputStream = new FileOutputStream("ofertas.pdf");
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(processHtml);
		renderer.layout();
		renderer.createPDF(outputStream, false);
		renderer.finishPDF();
		outputStream.close();
		
		try {
			Runtime.getRuntime()
					.exec("rundll32 url.dll,FileProtocolHandler " + new File("ofertas.pdf").getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}