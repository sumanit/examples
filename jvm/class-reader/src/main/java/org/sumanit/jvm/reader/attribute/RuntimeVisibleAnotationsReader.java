package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.RuntimeVisibleAnotations;

import java.nio.ByteBuffer;

public class RuntimeVisibleAnotationsReader extends AttributeReader<RuntimeVisibleAnotations> {
    @Override
    public void readBody(ByteBuffer buf, RuntimeVisibleAnotations attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public RuntimeVisibleAnotations createAttribute() {
        return  new RuntimeVisibleAnotations();
    }
}
