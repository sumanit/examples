package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.RuntimeInvisibleAnotations;

import java.nio.ByteBuffer;

public class RuntimeInvisibleAnotationsReader extends AttributeReader<RuntimeInvisibleAnotations> {
    @Override
    public void readBody(ByteBuffer buf, RuntimeInvisibleAnotations attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public RuntimeInvisibleAnotations createAttribute() {
        return new RuntimeInvisibleAnotations();
    }
}
