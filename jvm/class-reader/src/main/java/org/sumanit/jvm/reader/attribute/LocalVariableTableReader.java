package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.LocalVariableTable;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LocalVariableTableReader extends AttributeReader<LocalVariableTable> {

    @Override
    public void readBody(ByteBuffer buf, LocalVariableTable localVariableTable) {
        short localVariableTableLength = ByteBufferReaderUtil.readShort(buf);
        localVariableTable.setLocalVariableTableLength(localVariableTableLength);
        LocalVariableTable.LocalVariableInfo[] localVariableInfos = new LocalVariableTable.LocalVariableInfo[localVariableTableLength];
        LocalVariableInfoReader  localVariableInfoReader = new LocalVariableInfoReader();
        for (int i=0;i<localVariableTableLength;i++){
            LocalVariableTable.LocalVariableInfo localVariableInfo = localVariableInfoReader.read(buf);
            localVariableInfos[i] = localVariableInfo;
        }
        localVariableTable.setLocalVariableInfos(localVariableInfos);

    }

    @Override
    public LocalVariableTable createAttribute() {
        return new LocalVariableTable();
    }

    class LocalVariableInfoReader{

        public LocalVariableTable.LocalVariableInfo read(ByteBuffer buf){
            short startPc = ByteBufferReaderUtil.readShort(buf);
            short length = ByteBufferReaderUtil.readShort(buf);
            short nameIndex = ByteBufferReaderUtil.readShort(buf);
            short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
            short index = ByteBufferReaderUtil.readShort(buf);
            LocalVariableTable.LocalVariableInfo localVariableInfo = new LocalVariableTable.LocalVariableInfo();
            localVariableInfo.setStartPc(startPc);
            localVariableInfo.setLength(length);
            localVariableInfo.setNameIndex(nameIndex);
            localVariableInfo.setDescriptorIndex(descriptorIndex);
            localVariableInfo.setIndex(index);
            return localVariableInfo;
        }

    }
}
