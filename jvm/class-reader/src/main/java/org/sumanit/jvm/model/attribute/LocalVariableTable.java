package org.sumanit.jvm.model.attribute;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LocalVariableTable  extends Attribute {
    private short localVariableTableLength;
    private LocalVariableInfo[] localVariableInfos;

    public short getLocalVariableTableLength() {
        return localVariableTableLength;
    }

    public void setLocalVariableTableLength(short localVariableTableLength) {
        this.localVariableTableLength = localVariableTableLength;
    }

    public LocalVariableInfo[] getLocalVariableInfos() {
        return localVariableInfos;
    }

    public void setLocalVariableInfos(LocalVariableInfo[] localVariableInfos) {
        this.localVariableInfos = localVariableInfos;
    }

    public static class LocalVariableInfo{
        private short startPc;
        private short length;
        private short nameIndex;
        private short descriptorIndex;
        private short index;

        public short getStartPc() {
            return startPc;
        }

        public void setStartPc(short startPc) {
            this.startPc = startPc;
        }

        public short getLength() {
            return length;
        }

        public void setLength(short length) {
            this.length = length;
        }

        public short getNameIndex() {
            return nameIndex;
        }

        public void setNameIndex(short nameIndex) {
            this.nameIndex = nameIndex;
        }

        public short getDescriptorIndex() {
            return descriptorIndex;
        }

        public void setDescriptorIndex(short descriptorIndex) {
            this.descriptorIndex = descriptorIndex;
        }

        public short getIndex() {
            return index;
        }

        public void setIndex(short index) {
            this.index = index;
        }
    }
}
