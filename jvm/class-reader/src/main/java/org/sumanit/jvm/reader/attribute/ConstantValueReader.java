package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.ConstantValue;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class ConstantValueReader extends AttributeReader<ConstantValue> {

    @Override
    public void readBody(ByteBuffer buf, ConstantValue attribute) {
        short constantValueIndex = ByteBufferReaderUtil.readShort(buf);
        attribute.setConstantValueIndex(constantValueIndex);
    }

    @Override
    public ConstantValue createAttribute() {
        return new ConstantValue();
    }
}
