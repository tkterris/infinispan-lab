package com.rhc.jdg.provider;

import java.io.IOException;

import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import com.rhc.jdg.domain.FirstClass;
import com.rhc.jdg.domain.SecondClass;

public class XmlCacheProvider {
	private CacheContainer cacheContainer;

	protected CacheContainer getCacheContainer() {
		if (cacheContainer == null) {
			try {
				cacheContainer = new DefaultCacheManager("cache-config.xml",
						true);
				cacheContainer.start();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return cacheContainer;
	}

	public Cache<String, String> getCache(String identifier) {
		return getCacheContainer().getCache(identifier);
	}

	public Cache<String, String> getCache() {
		return getCacheContainer().getCache();
	}

	public Cache<String, FirstClass> getFirstCache() {
		return getCacheContainer().getCache();
	}

	public Cache<String, SecondClass> getSecondCache() {
		return getCacheContainer().getCache();
	}
	
	public void stop() {
		if (cacheContainer != null) {
			cacheContainer.stop();
		}
	}

}
