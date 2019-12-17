package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.RuntimeInvisibleParameterAnnotations;

import java.nio.ByteBuffer;

public class RuntimeInvisibleParameterAnnotationsReader extends AttributeReader<RuntimeInvisibleParameterAnnotations> {
    @Override
    public void readBody(ByteBuffer buf, RuntimeInvisibleParameterAnnotations attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public RuntimeInvisibleParameterAnnotations createAttribute() {
        return new RuntimeInvisibleParameterAnnotations();
    }
}
