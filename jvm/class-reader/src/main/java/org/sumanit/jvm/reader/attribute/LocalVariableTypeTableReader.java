package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.LocalVariableTypeTable;

import java.nio.ByteBuffer;

public class LocalVariableTypeTableReader extends AttributeReader<LocalVariableTypeTable> {
    @Override
    public void readBody(ByteBuffer buf, LocalVariableTypeTable attribute) {

    }

    @Override
    public LocalVariableTypeTable createAttribute() {
        return new LocalVariableTypeTable();
    }
}
