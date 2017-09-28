package com.git.action.documentItem;

import com.git.bean.DocumentitemEntity;
import com.git.service.DocumentItemService;
import com.git.util.CharacterUtils;
import com.git.util.Constants;
import com.git.util.FileStorage;
import com.git.util.FileUtility;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * Created by lihao on 17/9/28.
 */
public class EditDocumentItemAction extends ActionSupport {
    private long documentCatalogId;
    private long itemId;
    private DocumentItemService documentItemService;
    private File file;
    private String fileFileName;


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public DocumentItemService getDocumentItemService() {
        return documentItemService;
    }

    public void setDocumentItemService(DocumentItemService documentItemService) {
        this.documentItemService = documentItemService;
    }

    public String show() {
        DocumentitemEntity bean = documentItemService.getDocumentItemById(itemId);
        this.addFieldError("show", "源文件：" + bean.getName() + "将会被替换掉");
        return "show";
    }

//    @Override
//    public String execute() throws Exception {
//        return SUCCESS;
//    }

    public String update() throws Exception {
        //1,验证文件是否存在
        DocumentitemEntity oldbean = documentItemService.getDocumentItemById(itemId);
        if (!fileFileName.equals(oldbean.getName())) {
            boolean isExist = documentItemService.isDocumentItemExistByDcomentCatalogIdAndName(documentCatalogId, fileFileName);
            if (isExist) {
                this.addFieldError("error", "源文件：" + fileFileName + "文件已经存在！");
                return INPUT;
            }

        }


        //要删除的文件名
        String filename = oldbean.getRandomName();

        String randomFileName = System.currentTimeMillis() + FileUtility.randomName(fileFileName);
        String type = FileUtility.getExtName(fileFileName);
        String size = CharacterUtils.getSize(file.length());

        //2 生成bean
        oldbean.setDate(new Date());
        oldbean.setName(fileFileName);
        oldbean.setRandomName(randomFileName);
        oldbean.setRealSize(file.length());
        oldbean.setSize(size);
        oldbean.setType(type);

        //3，删除文件

        HttpServletRequest request = ServletActionContext.getRequest();
        File oldFile = new File(FileStorage.getDocumentItemStorage(request),
                String.valueOf(documentCatalogId) + File.separator + filename);

        FileUtils.forceDelete(oldFile);
        if (oldFile.getParentFile().list().length == 0) {
            FileUtils.forceDelete(oldFile.getParentFile());
        }


        //4，保存文件
        //得到要保存的文件
        File tempFile = new File(FileStorage.getDocumentItemStorage(request),
                String.valueOf(documentCatalogId) + File.separator + randomFileName);


        FileChannel fileChannel = new RandomAccessFile(file,"rw").getChannel();
        fileChannel.transferTo(0, file.length(), new RandomAccessFile(tempFile,"rw").getChannel());

        //5,保存bean
        documentItemService.updateDocumentItem(oldbean);


        return SUCCESS;

    }


    public void validateUpdate() {
        if (file.length() > Constants.MAX_FILE_SIZE) {
            this.addFieldError("error", "上传文件不能超过" + (Constants.MAX_FILE_SIZE / 1024 / 1024) + "M");
        }
    }


}
