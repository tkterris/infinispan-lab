package com.rhc.jdg.provider;

import org.infinispan.client.hotrod.RemoteCache;
import org.junit.Assert;
import org.junit.Test;

import com.rhc.jdg.domain.CacheKey;
import com.rhc.jdg.domain.CacheValue;

public class RemoteCacheProviderTest {
	
	@Test
	public void testRemoteCache() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<CacheKey, CacheValue> remoteCache = remoteCacheProvider.getCache();
		remoteCache.put(new CacheKey("1", "key1"), new CacheValue("name1", "email1"));
		remoteCache.put(new CacheKey("2", "key2"), new CacheValue("name2", "email2"));
		Assert.assertEquals("Value for key1 is incorrect", "name1", remoteCache.get(new CacheKey("1", "key1")).getName());
		Assert.assertEquals("Value for key2 is incorrect", "name2", remoteCache.get(new CacheKey("2", "key2")).getName());
		Assert.assertEquals("Cache size is incorrect", 2, remoteCache.size());
		remoteCacheProvider.stop();
	}
	
	@Test
	public void testRemoteCacheEvictionCount() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<CacheKey, CacheValue> remoteCache = remoteCacheProvider.getCache();
		for (int i = 0; i < 20; i++) {
			remoteCache.put(new CacheKey("" + i, "key" + i), new CacheValue("name1", "email1"));
		}
		Assert.assertTrue("Cache is not evicting entries", remoteCache.size() <= 10);
		remoteCache.clear();
		remoteCacheProvider.stop();
	}
	
	@Test
	public void testRemoteCacheEvictionMemory() {
		RemoteCacheProvider remoteCacheProvider = new RemoteCacheProvider();
		RemoteCache<CacheKey, CacheValue> remoteCache = remoteCacheProvider.getCache();
		for (int i = 0; i < 20; i++) {
			remoteCache.put(new CacheKey("" + i, "key" + i), new CacheValue("1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890"
					+ "1234567890", "email1"));
		}
		Assert.assertTrue("Cache is not evicting entries", remoteCache.size() < 20);
		remoteCache.clear();
		remoteCacheProvider.stop();
	}
}
