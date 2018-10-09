package com.sunway.monitor.capcha.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.google.code.kaptcha.Producer;

@Service("CaptchaServiceImpl")
public class CaptchaServiceImpl implements Producer {

	/*
	 * 随机数
	 */
	private static Random random = new Random();


	@Override
	public BufferedImage createImage(String randomString) {

		int width = 120;
		int height = 40;

		Color color = getRandomColor();
		Color reverse = getReverseColor(color);

		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bi.createGraphics();
		String[] fontS = { Font.SANS_SERIF, "Arial", "Courier", "宋体", "楷体", "微软雅黑", "幼圆" };
		g.setFont(new Font(fontS[random.nextInt(fontS.length - 1)], Font.BOLD, 25));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 20, 30);
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), random.nextInt(2), random.nextInt(2));
		}
		return bi;
	}

	/*
	 * 随机字符字典
	 */
	private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/*
	 * 获取5位随机数
	 */
	@Override
	public String createText() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 5; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	/*
	 * 获取随机数颜色
	 */
	private static Color getRandomColor() {
		return new Color(50 + random.nextInt(20), 50 + random.nextInt(20), 50 + random.nextInt(20));
	}

	/*
	 * 返回某颜色的反色
	 */
	private static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

}
