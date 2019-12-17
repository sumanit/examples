package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.Signature;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

public class SignatureReader extends AttributeReader<Signature> {
    @Override
    public void readBody(ByteBuffer buf, Signature attribute) {
        short signatureIndex = ByteBufferReaderUtil.readShort(buf);
        attribute.setSignatureIndex(signatureIndex);
    }

    @Override
    public Signature createAttribute() {
        return new Signature();
    }
}
