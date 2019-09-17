package com.rhc.jdg.marshaller;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;

import com.rhc.jdg.domain.CacheValue;

public class CacheValueMarshaller implements MessageMarshaller<CacheValue> {

	public Class<? extends CacheValue> getJavaClass() {
		return CacheValue.class;
	}

	public String getTypeName() {
		return "jdg.CacheValue";
	}

	public CacheValue readFrom(ProtoStreamReader reader) throws IOException {
		String name = reader.readString("name");
		String email = reader.readString("email");
		CacheValue value = new CacheValue();
		value.setName(name);
		value.setEmail(email);
		return value;
	}

	public void writeTo(ProtoStreamWriter writer, CacheValue cacheValue) throws IOException {
		writer.writeString("name", cacheValue.getName());
		writer.writeString("email", cacheValue.getEmail());
	}

}
