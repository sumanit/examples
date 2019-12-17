package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.EnclosingMethod;

import java.nio.ByteBuffer;

public class EnclosingMethodReader extends AttributeReader<EnclosingMethod>{
    @Override
    public void readBody(ByteBuffer buf, EnclosingMethod attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public EnclosingMethod createAttribute() {
        return new EnclosingMethod();
    }
}
