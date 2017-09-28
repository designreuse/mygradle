package com.git.bean;

/**
 * Created by lixueqin on 2017/9/28.
 */
public class DocumentItemUploadInfo {

    private long totalSize;//上传文件的总大小
    private long hasRead;//当前已经传送的大小

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public long getHasRead() {
        return hasRead;
    }

    public void setHasRead(long hasRead) {
        this.hasRead = hasRead;
    }
}
