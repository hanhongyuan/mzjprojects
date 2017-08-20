package org.mzj.test.eureka.sample;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;

public class TagSampler implements Sampler{

	@Override
	public boolean isSampled(Span span) {
		System.out.println(span.tags());
		return true;
	}

}
