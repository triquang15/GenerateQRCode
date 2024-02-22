package com.triquang.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.triquang.model.Student;

public class QRCodeGenerator {
	public static void generateQRCode(Student student) throws WriterException, IOException {
		String qrCodePath = "C:\\Developer\\QR-Code\\src\\main\\resources\\templates\\";
		String qrCodeName = qrCodePath + student.getFirstName() + student.getId() + "-My_Gallery.png";
		var codeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = codeWriter.encode("ID: " + student.getId() + "\n"+
												"First Name: " + student.getFirstName() + "\n"+
												"Last Name: " + student.getLastName() + "\n"+
												"Email: " + student.getEmail() + "\n"+
												"Phone: " + student.getMobile() + "\n"
		, BarcodeFormat.QR_CODE, 400, 400);
		Path path = FileSystems.getDefault().getPath(qrCodeName);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
}
