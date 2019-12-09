package org.sumanit.jvm.reader;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.FieldInfo;
import org.sumanit.jvm.model.MethodInfo;
import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.reader.constant.*;
import org.sumanit.jvm.writer.ClassWriter;
import org.sumanit.jvm.writer.ConsoleWriter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class ClassReader {

    public ClassReader() {

    }

    public Clazz read(File file) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(file, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(2048);
        Clazz clazz = null;
        while (inChannel.read(buf)!= -1) {
            buf.flip();

            clazz = read(buf);
            buf.clear();

        }
        aFile.close();
        return clazz;
    }

    private Clazz read(ByteBuffer buf){
        Clazz clazz = new Clazz();
        String magic = ByteBufferReaderUtil.readHexStr(buf, 4);
        clazz.setMagic(magic);
        short minor_version = ByteBufferReaderUtil.readShort(buf);
        clazz.setMinorVersion(minor_version);
        short major_version = ByteBufferReaderUtil.readShort(buf);
        clazz.setMajorVersion(major_version);
        Constant[] constants = readConstantPool(buf, clazz);
        clazz.setConstantPool(constants);
        String accessFlags = ByteBufferReaderUtil.readHexStr(buf, 2);
        clazz.setAccessFlags(accessFlags);
        short classIndex = ByteBufferReaderUtil.readShort(buf);
        clazz.setThisClassIndex(classIndex);
        short superClassIndex = ByteBufferReaderUtil.readShort(buf);
        clazz.setSuperClassIndex(superClassIndex);
        short[] interfaces = readInterfaces(buf);
        clazz.setInterfaceIndexs(interfaces);
        FieldInfo[] fieldInfos = readFields(buf,clazz);
        clazz.setFieldInfos(fieldInfos);
        MethodInfo[] methodInfos = readMethods(buf,clazz);
        clazz.setMethodInfos(methodInfos);
        return clazz;

    }
    private MethodInfo[]  readMethods(ByteBuffer buf,Clazz clazz){
        short methodCount = ByteBufferReaderUtil.readShort(buf);
        MethodInfo[] methodInfos = new MethodInfo[methodCount];
        MethodInfoReader methodInfoReader = new MethodInfoReader();
        for (int i = 0; i < methodCount; i++) {
            MethodInfo methodInfo = methodInfoReader.read(buf,clazz);
            methodInfo.setClazz(clazz);
            methodInfos[i] = methodInfo;
        }
        return methodInfos;
    }
    private FieldInfo[] readFields(ByteBuffer buf,Clazz clazz){
        short fieldCount = ByteBufferReaderUtil.readShort(buf);
        FieldInfo[] fieldInfos = new FieldInfo[fieldCount];
        FieldInfoReader fieldInfoReader = new FieldInfoReader();
        for (int i = 0; i < fieldCount; i++) {
            FieldInfo fieldInfo = fieldInfoReader.read(buf,clazz);
            fieldInfo.setClazz(clazz);
            fieldInfos[i] = fieldInfo;

        }
        return fieldInfos;
    }
    private void readAttributes(ByteBuffer buf){
        short attributesCount = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < attributesCount; i++) {

        }
    }
    private  short[] readInterfaces(ByteBuffer buf){
        short interfaceCounts = ByteBufferReaderUtil.readShort(buf);
        short[] interfaceIndexs = new short[interfaceCounts];
        for (int i = 0; i < interfaceCounts; i++) {
            interfaceIndexs[i] = ByteBufferReaderUtil.readShort(buf);
        }
        return interfaceIndexs;
    }
    private Constant[] readConstantPool(ByteBuffer buf,Clazz clazz){
        short constant_pool_count = ByteBufferReaderUtil.readShort(buf);
        clazz.setConstantPoolCount(constant_pool_count);
        Constant[] constants = new Constant[constant_pool_count-1];
        System.out.println("constant_pool_count:"+constant_pool_count);
        for (int i = 1; i < constant_pool_count; i++) {
            Constant constant = readConstant(buf);
            constant.setClazz(clazz);
            constants[i-1]=constant;
        }
        return constants;
    }

    private Constant readConstant(ByteBuffer buf){
        byte tag = buf.get();
        ConstantReader constantReader = ConstantReader.getReader(tag);
        Constant result = constantReader.read(buf);
        return result;

    }

    public static void main(String[] args) {
        ClassReader classReader = new ClassReader();
        try {
            Clazz clazz = classReader.read(new File("F:\\examples\\jvm\\load-test\\target\\classes\\org\\sumanit\\Test.class"));
            ClassWriter classWriter = new ClassWriter(new ConsoleWriter());
            classWriter.write(clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
