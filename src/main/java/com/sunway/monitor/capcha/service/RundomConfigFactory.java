package com.sunway.monitor.capcha.service;

import java.util.Properties;

import org.springframework.stereotype.Component;

import com.google.code.kaptcha.util.Config;

@Component
public class RundomConfigFactory implements ConfigFactory {

	private static int SWITCH = 1;

	@Override
	public Config getConfig() {
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border", "no");
		properties.setProperty("kaptcha.textproducer.font.color", "black");
		properties.setProperty("kaptcha.textproducer.font.color", "25,25,25");
		properties.setProperty("kaptcha.noise.color", "250,50,50");
		properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
		properties.setProperty("kaptcha.textproducer.char.string", "2345679ABCDEFGHJKLMNPQRSTUVWXY");
		properties.setProperty("kaptcha.image.width", "120");
		properties.setProperty("kaptcha.image.height", "40");
		properties.setProperty("kaptcha.textproducer.font.size", "25");
		properties.setProperty("kaptcha.textproducer.char.length", "4");
		properties.setProperty("kaptcha.textproducer.char.space", "5");
		// properties.setProperty("kaptcha.session.key", "loginCode");
		properties.setProperty("kaptcha.textproducer.char.length", "5");
		properties.setProperty("kaptcha.textproducer.font.names", "Arial, Courier,宋体,楷体,微软雅黑,幼圆");
		properties.setProperty("kaptcha.background.clear.from", "200,200,200");
		properties.setProperty("kaptcha.background.clear.to", "248,248,248");
		SWITCH++;
		if (SWITCH == Integer.MAX_VALUE) {
			SWITCH = 1;
		}

		switch (SWITCH % 4) {
		case 0:
			properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
			properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
			break;
		case 1:
			properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
			properties.setProperty("kaptcha.obscurificator.impl",   "com.google.code.kaptcha.impl.WaterRipple");
			break;
		case 2:
			properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
			properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
			break;
		case 3:
			properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
			properties.setProperty("kaptcha.obscurificator.impl",   "com.google.code.kaptcha.impl.WaterRipple");
			break;
		}

		Config config = new Config(properties);

		return config;
	}

}
