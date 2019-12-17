package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.InterfaceMethodrefInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 接口中方法的符号引用
 */
public class InterfaceMethodrefInfoReader extends ConstantReader<InterfaceMethodrefInfo> {
    @Override
    public InterfaceMethodrefInfo read(ByteBuffer buf) {
        InterfaceMethodrefInfo interfaceMethodrefInfo = new InterfaceMethodrefInfo();
        short classInfoIndex = ByteBufferReaderUtil.readShort(buf);
        interfaceMethodrefInfo.setClassInfoIndex(classInfoIndex);
        short nameAndTypeIndex = ByteBufferReaderUtil.readShort(buf);
        interfaceMethodrefInfo.setNameAndTypeIndex(nameAndTypeIndex);
        return interfaceMethodrefInfo;
    }

}
