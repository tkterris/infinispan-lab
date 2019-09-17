package com.rhc.jdg;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.domain.FirstClass;
import com.rhc.jdg.domain.SecondClass;
import com.rhc.jdg.provider.JavaCacheProvider;
import com.rhc.jdg.provider.XmlCacheProvider;

public class CacheTest {
	
	@Test
	public void testJavaCache() {
		JavaCacheProvider javaCacheProvider = new JavaCacheProvider();
		Map<String, FirstClass> javaFirstCache = javaCacheProvider.getFirstCache();
		Map<String, SecondClass> javaSecondCache = javaCacheProvider.getSecondCache();
		javaFirstCache.put("key1", new FirstClass("value1"));
		javaFirstCache.put("key2", new FirstClass("value2"));
		Assert.assertEquals("Cache size is incorrect", 2, javaSecondCache.size());
		Assert.assertEquals("Value for key1 is incorrect", "value1", javaSecondCache.get("key1").getValue());
		Assert.assertEquals("Value for key2 is incorrect", "value2", javaSecondCache.get("key2").getValue());
		javaCacheProvider.stop();
	}
	
	@Test
	public void testXmlCache() {
		XmlCacheProvider xmlCacheProvider = new XmlCacheProvider();
		Map<String, FirstClass> xmlFirstCache = xmlCacheProvider.getFirstCache();
		Map<String, SecondClass> xmlSecondCache = xmlCacheProvider.getSecondCache();
		xmlFirstCache.put("key1", new FirstClass("value1"));
		xmlFirstCache.put("key2", new FirstClass("value2"));
		Assert.assertEquals("Cache size is incorrect", 2, xmlSecondCache.size());
		Assert.assertEquals("Value for key1 is incorrect", "value1", xmlSecondCache.get("key1").getValue());
		Assert.assertEquals("Value for key2 is incorrect", "value2", xmlSecondCache.get("key2").getValue());
		xmlCacheProvider.stop();
	}
}
