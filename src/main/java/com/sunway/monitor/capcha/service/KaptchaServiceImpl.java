package com.sunway.monitor.capcha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Service("KaptchaServiceImpl")
public class KaptchaServiceImpl extends DefaultKaptcha {

	@Autowired
	private  ConfigFactory factory;
	
	@Override
	public Config getConfig() {
		 return factory.getConfig();
	}
 
}
