package com.rhc.jdg.util;

import org.infinispan.configuration.cache.AbstractStoreConfigurationBuilder;
import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;

public class XiaoStoreConfigurationBuilder extends AbstractStoreConfigurationBuilder
	<XiaoStoreConfiguration, XiaoStoreConfigurationBuilder> {

	public XiaoStoreConfigurationBuilder(PersistenceConfigurationBuilder builder) {
		super(builder);
	}

	public XiaoStoreConfiguration create() {
		return new XiaoStoreConfiguration(attributes.protect(), async.create(), singletonStore.create());
	}

	public XiaoStoreConfigurationBuilder self() {
		return this;
	}

}
