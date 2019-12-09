package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.LongInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 长整型字面量
 */
public class LongInfoReader extends ConstantReader<LongInfo> {
    @Override
    public LongInfo read(ByteBuffer buf) {
        long value =  ByteBufferReaderUtil.readLong(buf);
        LongInfo longInfo = new LongInfo();
        longInfo.setValue(value);
        return longInfo;
    }

}
