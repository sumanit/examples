package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.FieldrefInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字段的符号引用，主要有两个属性
 */
public class FieldrefInfoReader extends ConstantReader<FieldrefInfo> {
    @Override
    public FieldrefInfo read(ByteBuffer buf) {
        FieldrefInfo fieldrefInfo = new FieldrefInfo();
        short classInfoIndex = ByteBufferReaderUtil.readShort(buf);
        short nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
        fieldrefInfo.setClassInfoIndex(classInfoIndex);
        fieldrefInfo.setNameAndTypeIndex(nameAndTypeIndex);
        return fieldrefInfo;
    }

}
