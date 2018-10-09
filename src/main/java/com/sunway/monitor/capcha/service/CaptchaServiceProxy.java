package com.sunway.monitor.capcha.service;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Producer;

@Service("CaptchaServiceProxy")
public class CaptchaServiceProxy implements Producer {

	private static int SWITCH = 1;

	@Resource(name = "CaptchaServiceImpl")
	private Producer captchaServiceA;

	@Resource(name = "KaptchaServiceImpl")
	private Producer captchaServiceB;

	@Override
	public BufferedImage createImage(String text) {
		
		SWITCH++;
		if (SWITCH == Integer.MAX_VALUE) {
			SWITCH = 1;
		}
		if ((SWITCH % 2) == 1) {
			return captchaServiceA.createImage(text);
		} else {
			return captchaServiceB.createImage(text);
		}
	}

	@Override
	public String createText() {
		if (SWITCH == Integer.MAX_VALUE) {
			SWITCH = 1;
		}
		if ((SWITCH % 2) == 1) {
			return captchaServiceA.createText();
		} else {
			return captchaServiceB.createText();
		}
	}

}
