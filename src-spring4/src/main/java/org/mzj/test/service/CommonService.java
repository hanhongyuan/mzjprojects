package org.mzj.test.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value=false)
public interface CommonService {
	public void test();
}
