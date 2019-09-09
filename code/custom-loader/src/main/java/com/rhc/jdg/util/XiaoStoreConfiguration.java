package com.rhc.jdg.util;

import org.infinispan.commons.configuration.BuiltBy;
import org.infinispan.commons.configuration.ConfigurationFor;
import org.infinispan.commons.configuration.attributes.AttributeSet;
import org.infinispan.configuration.cache.AbstractStoreConfiguration;
import org.infinispan.configuration.cache.AsyncStoreConfiguration;
import org.infinispan.configuration.cache.SingletonStoreConfiguration;

@BuiltBy(XiaoStoreConfigurationBuilder.class)
@ConfigurationFor(XiaoCacheLoader.class)
public class XiaoStoreConfiguration extends AbstractStoreConfiguration {

	public XiaoStoreConfiguration(AttributeSet attributes, AsyncStoreConfiguration async,
			SingletonStoreConfiguration singletonStore) {
		super(attributes, async, singletonStore);
	}

}
