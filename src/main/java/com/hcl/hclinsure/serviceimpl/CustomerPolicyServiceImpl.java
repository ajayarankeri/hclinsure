package com.hcl.hclinsure.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.hclinsure.dto.CustomerPolicyDto;
import com.hcl.hclinsure.repository.CustomerPolicyRepository;
import com.hcl.hclinsure.service.CustomerPolicyService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class CustomerPolicyServiceImpl implements CustomerPolicyService {
	
	@Autowired
	CustomerPolicyRepository reop;

	@Override
	public ByteArrayInputStream policyReport(List<CustomerPolicyDto> customerPolicy) {
		 	        Document document = new Document();
		        ByteArrayOutputStream out = new ByteArrayOutputStream();

		        try {

		            PdfPTable table = new PdfPTable(4);
		            table.setWidthPercentage(60);
		            table.setWidths(new int[]{3, 3, 3, 3});

		            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		            PdfPCell hcell;
		            hcell = new PdfPCell(new Phrase("Customer Id", headFont));
		            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(hcell);

		            hcell = new PdfPCell(new Phrase("Policy Id", headFont));
		            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(hcell);
		            
		            hcell = new PdfPCell(new Phrase("Policy Total Amount", headFont));
		            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(hcell);

		            hcell = new PdfPCell(new Phrase("Policy Start Date", headFont));
		            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(hcell);

		            for (CustomerPolicyDto policy : customerPolicy) {

		                PdfPCell cell;

		                cell = new PdfPCell(new Phrase( String.valueOf(policy.getPolicyId())));
		                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(cell);

		                cell = new PdfPCell(new Phrase(String.valueOf(policy.getCustomerId())));
		                cell.setPaddingLeft(5);
		                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                table.addCell(cell);
		                
		                cell = new PdfPCell(new Phrase(String.valueOf(policy.getPolicyTotalAmount())));
		                cell.setPaddingLeft(5);
		                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                table.addCell(cell);

		                cell = new PdfPCell(new Phrase(String.valueOf(policy.getPolicyStartDate().toString())));
		                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		                cell.setPaddingRight(5);
		                table.addCell(cell);
		            }

		            PdfWriter.getInstance(document, out);
		            document.open();
		            document.add(table);

		            document.close();

		        } catch (DocumentException ex) {
		           ex.getStackTrace();
		        }

		        return new ByteArrayInputStream(out.toByteArray());
		    }

	@Override
	public List<CustomerPolicyDto> getCustomerPolicyList(long id) {
		return reop.findAllPolicies(id);
	}

	
}
