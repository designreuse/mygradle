package com.git.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/28.
 */
public class DocumentItemUploadInfo {

    private List<Long> totalSize = new ArrayList<>();//上传文件的总大小
    private List<Long> hasRead= new ArrayList<>();//当前已经传送的大小

    public List<Long> getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(List<Long> totalSize) {
        this.totalSize = totalSize;
    }

    public List<Long> getHasRead() {
        return hasRead;
    }

    public void setHasRead(List<Long> hasRead) {
        this.hasRead = hasRead;
    }
}
