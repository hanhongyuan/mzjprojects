package org.mzj.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommService {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private CommonService commonService;

	public String getServerTime() {
		System.out.println(commonService);
		commonService.test();
		return sdf.format(new Date());
	}
}
