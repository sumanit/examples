package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.LocalVariableTable;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LocalVariableTableReader extends AttributeReader<LocalVariableTable> {
    private short localVariableTableLength;
    private LocalVariableInfo[] localVariableInfos;
    @Override
    public void readBody(ByteBuffer buf, LocalVariableTable localVariableTable) {
        localVariableTableLength = ByteBufferReaderUtil.readShort(buf);
        localVariableInfos = new LocalVariableInfo[localVariableTableLength];
        for (int i=0;i<localVariableTableLength;i++){
            LocalVariableInfo localVariableInfo = new LocalVariableInfo();
            localVariableInfo.read(buf);
            localVariableInfos[i] = localVariableInfo;
        }
    }

    @Override
    public LocalVariableTable createAttribute() {
        return new LocalVariableTable();
    }

    class LocalVariableInfo{
        private short startPc;
        private short length;
        private short nameIndex;
        private short descriptorIndex;
        private short index;

        public void read(ByteBuffer buf){
            startPc = ByteBufferReaderUtil.readShort(buf);
            length = ByteBufferReaderUtil.readShort(buf);
            nameIndex = ByteBufferReaderUtil.readShort(buf);
            descriptorIndex = ByteBufferReaderUtil.readShort(buf);
            index = ByteBufferReaderUtil.readShort(buf);
        }

        @Override
        public String toString() {
            return "LocalVariableInfo{" +
                    "startPc=" + startPc +
                    ", length=" + length +
                    ", nameIndex=" + nameIndex +
                    ", descriptorIndex=" + descriptorIndex +
                    ", index=" + index +
                    '}';
        }
    }
}
