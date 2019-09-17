package com.rhc.jdg.provider;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.FileDescriptorSource;
import org.infinispan.protostream.SerializationContext;

import com.rhc.jdg.domain.CacheKey;
import com.rhc.jdg.domain.CacheValue;
import com.rhc.jdg.marshaller.CacheKeyMarshaller;
import com.rhc.jdg.marshaller.CacheValueMarshaller;

public class RemoteCacheProvider{
	private RemoteCacheManager cacheManager;

	protected RemoteCacheManager getCacheManager() {
		if (cacheManager == null) {
			ProtoStreamMarshaller psm = new ProtoStreamMarshaller();
			SerializationContext ctx = psm.getSerializationContext();
			try {
				ctx.registerProtoFiles(FileDescriptorSource.fromResources("cachekey.proto"));
				ctx.registerProtoFiles(FileDescriptorSource.fromResources("cachevalue.proto"));
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			ctx.registerMarshaller(new CacheKeyMarshaller());
			ctx.registerMarshaller(new CacheValueMarshaller());
			
			Configuration config = new ConfigurationBuilder()
					.marshaller(psm)
					.addServer().host("localhost").port(11222)
					.build();
			cacheManager = new RemoteCacheManager(config, true);
			cacheManager.start();
		}
		return cacheManager;
	}

	public RemoteCache<CacheKey, CacheValue> getCache() {
		return getCacheManager().getCache("protoCache");
	}
	
	public void stop() {
		if (cacheManager != null) {
			cacheManager.stop();
		}
	}

}
