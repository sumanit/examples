package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.RuntimeVisibleParameterAnnotations;

import java.nio.ByteBuffer;

public class RuntimeVisibleParameterAnnotationsReader extends  AttributeReader<RuntimeVisibleParameterAnnotations> {
    @Override
    public void readBody(ByteBuffer buf, RuntimeVisibleParameterAnnotations attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public RuntimeVisibleParameterAnnotations createAttribute() {
        return new RuntimeVisibleParameterAnnotations();
    }
}
