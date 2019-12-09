package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字段或方法的部分符号引用
 *
 * 该数据结构定义了 字段的 字段名 字段类型
 *
 * 该数据结构定义了 方法的 方法名 参数类型  返回值类型
 */
public class NameAndTypeInfo extends Constant {
    /**
     * 字段或方法名的索引
     */
    private short nameIndex;
    /**
     * 字段或方法描述符的索引
     */
    private short descriptionIndex;

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptionIndex() {
        return descriptionIndex;
    }

    public void setDescriptionIndex(short descriptionIndex) {
        this.descriptionIndex = descriptionIndex;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + index2Str(nameIndex) +
                ", description=" + index2Str(descriptionIndex) +
                '}';
    }

    public String getTypeName() {
        return "NameAndType";
    }
}
