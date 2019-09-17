package com.rhc.jdg.util;

import java.io.IOException;

import org.infinispan.commons.CacheException;
import org.infinispan.commons.configuration.ConfiguredBy;
import org.infinispan.commons.marshall.WrappedByteArray;
import org.infinispan.commons.persistence.Store;
import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.persistence.spi.AdvancedCacheLoader;
import org.infinispan.persistence.spi.InitializationContext;
import org.infinispan.protostream.ProtobufUtil;
import org.infinispan.protostream.SerializationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Store
@ConfiguredBy(XiaoStoreConfiguration.class)
public class XiaoCacheLoader<K,V> implements AdvancedCacheLoader<K, V> {
	
	private static Logger logger = LoggerFactory.getLogger(XiaoCacheLoader.class);
	
	private SerializationContext ctx;

	public void start() {
		// TODO Auto-generated method stub
		logger.info("======STARTING");
		
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

	public void init(InitializationContext ctx) {
		// TODO Auto-generated method stub
		logger.info("======INITING");
		this.ctx = ProtobufUtil.newSerializationContext();
		
	}

	public MarshalledEntry<K, V> load(Object arg0) {
		// TODO Auto-generated method stub
		logger.info("======LOADING");
		try {
			ProtobufUtil.fromWrappedByteArray(ctx, ((WrappedByteArray) arg0).getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CacheException("Unable to load object");
	}

	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}

}
