package org.sumanit.jvm.reader.attribute;


import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.model.constant.Utf8Info;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class AttributeReader<T extends  Attribute> {

    public T read(ByteBuffer buf,Clazz clazz){
        T t = readHead(buf,clazz);
        readBody(buf,t);
        return t;
    }

    public T readHead(ByteBuffer buf,Clazz clazz){
        short attributeNameIndex = ByteBufferReaderUtil.readShort(buf);
        Utf8Info attributeName = (Utf8Info) clazz.getConstantPool()[attributeNameIndex-1];
        System.out.println(attributeName.getValue());
        AttributeReader reader = getReader(attributeName.getValue(), clazz);
        Attribute attribute = reader.createAttribute();
        attribute.setAttributeNameIndex(attributeNameIndex);
        int attributeLength = ByteBufferReaderUtil.readInt(buf);
        attribute.setAttributeLength(attributeLength);
        attribute.setClazz(clazz);
        reader.readBody(buf,attribute);
        return (T)attribute;
    }
    public void readBody(ByteBuffer buf,T attribute){

    }
    public T createAttribute(){
        return null;
    }

    public static AttributeReader getReader(String attributeName, Clazz clazz){
        switch (attributeName){
            case "Code":
                return new CodeReader();
            case "ConstantValue":
                return new ConstantValueReader();
            case "Deprecated":
                return new DeprecatedReader();
            case "Exceptions":
                return new ExceptionsReader();
            case "EnclosingMethod":
                return new EnclosingMethodReader();
            case "InnerClasses":
                return new InnerClassesReader();
            case "LineNumberTable":
                return new LineNumberTableReader();
            case "LocalVariableTable":
                return new LocalVariableTableReader();
            case "StackMapTable":
                return new StackMapTableReader();
            case "Signature":
                return new SignatureReader();
            case "LocalVariableTypeTable":
                return new LocalVariableTypeTableReader();
            case "RuntimeVisibleAnotations":
                return new RuntimeVisibleAnotationsReader();
            case "RuntimeInvisibleAnotations":
                return new RuntimeInvisibleAnotationsReader();
            case "RuntimeVisibleParameterAnnotations":
                return new RuntimeVisibleParameterAnnotationsReader();
            case "RuntimeInvisibleParameterAnnotations":
                return new RuntimeInvisibleParameterAnnotationsReader();
            case "AnnotationDefault":
                return new AnnotationDefaultReader();
            case "BootstrapMethods":
                return new BootstrapMethodsReader();
        }
        System.out.println(attributeName);
        return null;
    }
}
