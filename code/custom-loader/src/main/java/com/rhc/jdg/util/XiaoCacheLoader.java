package com.rhc.jdg.util;

import org.infinispan.commons.CacheException;
import org.infinispan.commons.configuration.ConfiguredBy;
import org.infinispan.commons.persistence.Store;
import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.persistence.spi.CacheLoader;
import org.infinispan.persistence.spi.InitializationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Store
@ConfiguredBy(XiaoStoreConfiguration.class)
public class XiaoCacheLoader<K,V> implements CacheLoader<K, V> {
	
	private static Logger logger = LoggerFactory.getLogger(XiaoCacheLoader.class);

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
		return false;
	}

	public void init(InitializationContext arg0) {
		// TODO Auto-generated method stub
		logger.info("======INITING");
		
	}

	public MarshalledEntry<K, V> load(Object arg0) {
		// TODO Auto-generated method stub
		logger.info("======LOADING");
		throw new CacheException("Unable to load object");
	}

}
