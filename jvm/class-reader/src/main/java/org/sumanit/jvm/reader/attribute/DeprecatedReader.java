package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.model.attribute.Deprecated;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class DeprecatedReader extends AttributeReader {
    @Override
    public void readBody(ByteBuffer buf, Attribute attribute) {

    }

    @Override
    public Attribute createAttribute() {
        return new Deprecated();
    }
}
