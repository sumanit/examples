package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.Signature;

import java.nio.ByteBuffer;

public class SignatureReader extends AttributeReader<Signature> {
    @Override
    public void readBody(ByteBuffer buf, Signature attribute) {
        super.readBody(buf, attribute);
    }

    @Override
    public Signature createAttribute() {
        return new Signature();
    }
}
