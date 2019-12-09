package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.IntegerInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 整型字面量
 */
public class IntegerInfoReader extends ConstantReader<IntegerInfo> {

    @Override
    public IntegerInfo read(ByteBuffer buf) {
        IntegerInfo integerInfo = new IntegerInfo();
        int value = ByteBufferReaderUtil.readInt(buf);
        integerInfo.setValue(value);
        return integerInfo;
    }

}
