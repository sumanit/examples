package org.sumanit.jvm.model.attribute;


/**
 * Created by 苏曼 on 2019/12/4.
 */
public class InnerClasses extends Attribute {
    private short numberOfClasses;
    private InnerClassInfo[] innerClassInfos;

    public short getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(short numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public InnerClassInfo[] getInnerClassInfos() {
        return innerClassInfos;
    }

    public void setInnerClassInfos(InnerClassInfo[] innerClassInfos) {
        this.innerClassInfos = innerClassInfos;
    }

    public static class InnerClassInfo{
        private short innerClassInfoIndex;
        private short outerClassInfoIndex;
        private short innerNameIndex;
        private String innerClassAccessFlags;

        public short getInnerClassInfoIndex() {
            return innerClassInfoIndex;
        }

        public void setInnerClassInfoIndex(short innerClassInfoIndex) {
            this.innerClassInfoIndex = innerClassInfoIndex;
        }

        public short getOuterClassInfoIndex() {
            return outerClassInfoIndex;
        }

        public void setOuterClassInfoIndex(short outerClassInfoIndex) {
            this.outerClassInfoIndex = outerClassInfoIndex;
        }

        public short getInnerNameIndex() {
            return innerNameIndex;
        }

        public void setInnerNameIndex(short innerNameIndex) {
            this.innerNameIndex = innerNameIndex;
        }

        public String getInnerClassAccessFlags() {
            return innerClassAccessFlags;
        }

        public void setInnerClassAccessFlags(String innerClassAccessFlags) {
            this.innerClassAccessFlags = innerClassAccessFlags;
        }
    }
}
