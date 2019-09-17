package com.rhc.jdg.interceptor;

import org.infinispan.commands.VisitableCommand;
import org.infinispan.commands.read.GetKeyValueCommand;
import org.infinispan.commands.write.PutKeyValueCommand;
import org.infinispan.context.InvocationContext;
import org.infinispan.interceptors.base.BaseCustomInterceptor;

import com.rhc.jdg.domain.FirstClass;
import com.rhc.jdg.domain.SecondClass;


public class CastingCacheInterceptor extends BaseCustomInterceptor{
	@Override
	protected Object handleDefault(InvocationContext ctx,
			VisitableCommand command) throws Throwable {
		if (command instanceof PutKeyValueCommand) {
			PutKeyValueCommand putCommand = (PutKeyValueCommand) command;
			if (putCommand.getValue() instanceof FirstClass) {
				FirstClass value = (FirstClass) putCommand.getValue();
				putCommand.setValue(value.getValue());
			}
		}
		if (command instanceof GetKeyValueCommand) {
			GetKeyValueCommand getCommand = (GetKeyValueCommand) command;
			Object value = super.handleDefault(ctx, getCommand);
			//TODO: logic to detect if class is LRU map
			if (value instanceof String) {
				return new SecondClass((String) value);
			} else {
				return value;
			}
		}
		System.out.println("Intercepting! " + ctx + ":" + command);
		return super.handleDefault(ctx, command);
	}
}
