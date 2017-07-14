package com.mzj.crawler;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import cn.wanghaomiao.xpath.model.JXDocument;

public class LianjiaTest {

	@Test
	public void testChengjiao() {
		try {
			Document doc = Jsoup.connect("http://bj.lianjia.com/xiaoqu/pg1").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0").get();
			JXDocument xiaoquDoc = new JXDocument(doc);
			
			List<Object> lis = xiaoquDoc.sel("//ul[@class='listContent']/li");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
