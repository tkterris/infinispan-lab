package com.rhc.jdg.util;

import java.io.IOException;

import org.infinispan.commons.CacheException;
import org.infinispan.commons.configuration.ConfiguredBy;
import org.infinispan.commons.marshall.WrappedByteArray;
import org.infinispan.commons.persistence.Store;
import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.persistence.spi.AdvancedCacheLoader;
import org.infinispan.persistence.spi.InitializationContext;
import org.infinispan.protostream.DescriptorParserException;
import org.infinispan.protostream.FileDescriptorSource;
import org.infinispan.protostream.ProtobufUtil;
import org.infinispan.protostream.SerializationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rhc.jdg.domain.CacheKey;
import com.rhc.jdg.domain.CacheValue;
import com.rhc.jdg.marshaller.CacheKeyMarshaller;
import com.rhc.jdg.marshaller.CacheValueMarshaller;

@Store
@ConfiguredBy(XiaoStoreConfiguration.class)
public class XiaoCacheLoader implements AdvancedCacheLoader<CacheKey, CacheValue> {
	
	private static Logger logger = LoggerFactory.getLogger(XiaoCacheLoader.class);
	
	private SerializationContext ctx;
	private InitializationContext initCtx;

	public void start() {
		logger.info("======STARTING");
		try {
			ctx.registerProtoFiles(FileDescriptorSource.fromResources("cachekey.proto"));
			ctx.registerProtoFiles(FileDescriptorSource.fromResources("cachevalue.proto"));
		} catch (Exception e) {
			logger.error("==========ERROR STARTING CACHE", e);
		}
		ctx.registerMarshaller(new CacheKeyMarshaller());
		ctx.registerMarshaller(new CacheValueMarshaller());
	}

	public void stop() {
		// TODO Auto-generated method stub
		logger.info("======STOPPING");
		
	}

	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		logger.info("======CHECKING CONTAINS");
		return true;
	}

	public void init(InitializationContext initCtx) {
		// TODO Auto-generated method stub
		logger.info("======INITING");
		this.ctx = ProtobufUtil.newSerializationContext();
		this.initCtx = initCtx;
		
	}

	public MarshalledEntry<CacheKey, CacheValue> load(Object key) {
		logger.info("======LOADING");
		try {
			byte[] keyBytes = ((WrappedByteArray) key).getBytes();
			System.out.println("========cache key size: " + keyBytes.length);
			CacheKey keyObject = ProtobufUtil.fromWrappedByteArray(ctx, keyBytes);
			//TODO: fetch from cache store
			CacheValue valueObject = null;
			return initCtx.getMarshalledEntryFactory()
					.newMarshalledEntry(keyBytes, ProtobufUtil.toWrappedByteArray(ctx, valueObject), null);
		} catch (IOException e) {
			throw new CacheException("Unable to load object", e);
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
