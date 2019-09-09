package com.rhc.jdg.util;

import org.infinispan.commons.configuration.ConfiguredBy;
import org.infinispan.commons.persistence.Store;
import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.persistence.spi.CacheLoader;
import org.infinispan.persistence.spi.InitializationContext;

@Store
@ConfiguredBy(XiaoStoreConfiguration.class)
public class XiaoCacheLoader<K,V> implements CacheLoader<K, V> {

	public void start() {
		// TODO Auto-generated method stub
		System.out.println("======STARTING");
		
	}

	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("======STOPPING");
		
	}

	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		System.out.println("======CHECKING CONTAINS");
		return false;
	}

	public void init(InitializationContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("======INITING");
		
	}

	public MarshalledEntry<K, V> load(Object arg0) {
		// TODO Auto-generated method stub
		System.out.println("======LOADING");
		return null;
	}

}
