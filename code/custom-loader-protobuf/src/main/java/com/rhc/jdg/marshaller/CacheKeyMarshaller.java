package com.rhc.jdg.marshaller;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;

import com.rhc.jdg.domain.CacheKey;

public class CacheKeyMarshaller implements MessageMarshaller<CacheKey> {

	public Class<? extends CacheKey> getJavaClass() {
		return CacheKey.class;
	}

	public String getTypeName() {
		return "jdg.CacheKey";
	}

	public CacheKey readFrom(ProtoStreamReader reader) throws IOException {
		String index = reader.readString("index");
		String keyField = reader.readString("keyField");
		CacheKey value = new CacheKey();
		value.setIndex(index);
		value.setKeyField(keyField);
		return value;
	}

	public void writeTo(ProtoStreamWriter writer, CacheKey CacheKey) throws IOException {
		writer.writeString("index", CacheKey.getIndex());
		writer.writeString("keyField", CacheKey.getKeyField());
	}

}
