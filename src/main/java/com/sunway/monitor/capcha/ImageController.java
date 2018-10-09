package com.sunway.monitor.capcha;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;

@RestController
@RequestMapping("/img")
public class ImageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
 
	@Resource(name = "CaptchaServiceProxy")
	private Producer captchaService;

	@RequestMapping(method = GET)
	public void send(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.setProperty("java.awt.headless", "true");
		logger.debug(String.format("java.awt.headless=%s", System.getProperty("java.awt.headless")));

		String randomText = captchaService.createText();
		
		BufferedImage bi = captchaService.createImage(randomText);

		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

}
