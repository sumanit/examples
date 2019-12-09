package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.Synthetic;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class SyntheticReader extends AttributeReader<Synthetic> {
    @Override
    public void readBody(ByteBuffer buf,Synthetic synthetic) {

    }

    @Override
    public Synthetic createAttribute() {
        return new Synthetic();
    }
}
