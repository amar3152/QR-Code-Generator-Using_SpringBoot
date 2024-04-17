package com.qr.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qr.service.QRCodeGeneratorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/qr")
public class QRController {
	
	@Autowired
	QRCodeGeneratorService qrcodeservice;
	
	@GetMapping(value="/qrcode/{content}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] generateQrCode(@PathVariable String content) throws IOException {
		int width = 200;
		int height = 200;
		return qrcodeservice.generateQrCodeImage(content,width,height);
	}
	

}
