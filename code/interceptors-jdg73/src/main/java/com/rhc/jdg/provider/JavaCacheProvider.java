package com.rhc.jdg.provider;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.eviction.EvictionStrategy;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

import com.rhc.jdg.domain.FirstClass;
import com.rhc.jdg.domain.SecondClass;
import com.rhc.jdg.interceptor.CastingCacheInterceptor;

public class JavaCacheProvider {
	private CacheContainer cacheContainer;

	protected CacheContainer getCacheContainer() {
		if (cacheContainer == null) {
			Configuration config = new ConfigurationBuilder()
					.jmxStatistics()
						.enable()
					.build();
			cacheContainer = new DefaultCacheManager(config);
			cacheContainer.start();
			registerInterceptors(cacheContainer.getCache());
		}
		return cacheContainer;
	}

	public Cache<String, String> getCache(String identifier) {
		return getCacheContainer().getCache(identifier);
	}

	public Cache<String, FirstClass> getFirstCache() {
		return getCacheContainer().getCache();
	}

	public Cache<String, SecondClass> getSecondCache() {
		return getCacheContainer().getCache();
	}
	
	private void registerInterceptors(Cache cache) {
		AdvancedCache<String, String> advancedCache = cache.getAdvancedCache();
		advancedCache.addInterceptor(new CastingCacheInterceptor(), 0);
	}
	
	public void stop() {
		if (cacheContainer != null) {
			cacheContainer.stop();
		}
	}
}
