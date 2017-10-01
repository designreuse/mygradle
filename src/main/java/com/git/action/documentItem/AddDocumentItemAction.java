package com.git.action.documentItem;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentItemUploadInfo;
import com.git.bean.DocumentitemEntity;
import com.git.service.DocumentCatalogService;
import com.git.service.DocumentItemService;
import com.git.util.CharacterUtils;
import com.git.util.Constants;
import com.git.util.FileStorage;
import com.git.util.FileUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by lihao on 17/9/25.
 * 默认不能超过2M  超过2m file 是空指针
 */
public class AddDocumentItemAction extends ActionSupport {

    private long documentCatalogId;

    private List<File> file;
    private List<String> fileFileName;

    @Resource
    private DocumentItemService documentItemService;
    @Resource
    private DocumentCatalogService documentCatalogService;

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public String showAdd() {

        return "showAdd";

    }

    /**
     * 1,获得documentcatalog 对象
     * 2，获得客户端上传的文件，并且将这些文件所构成的集合与documentcatalog 对象关联起来
     * 3，将客户端上传的文件保存到服务器端的硬盘上，并设定好相应的文件名
     *
     * @return
     */
    public String upload() {


        DocumentCatalog documentCatalog = documentCatalogService.getDocumentCatalog(documentCatalogId);

        List<DocumentitemEntity> list = new ArrayList<>();
        DocumentitemEntity bean = null;
        Date date = new Date();
        HttpServletRequest request = ServletActionContext.getRequest();
        //设置session 获取到文件的总大小
        long totalSize = 0;
        for(File f:file) {
            totalSize +=f.length();
        }
        DocumentItemUploadInfo info = new DocumentItemUploadInfo();

        request.getSession().setAttribute("uploadInfo",info);


        for (int i = 0; i < file.size(); ++i) {
//            System.out.println(fileFileName.get(i));
            bean = new DocumentitemEntity();

            String fileName = fileFileName.get(i);

            //该文件已经存在
            if (documentItemService.isDocumentItemExistByDcomentCatalogIdAndName(documentCatalogId, fileName)) {
                this.addActionError("文件：" + fileName + " 已经存在！");
                return INPUT;//直接返回文档条目的上传页面

            }

            long length = file.get(i).length(); //文件真实大小
            String type = FileUtility.getExtName(fileName); //文件扩展名，即类型
            String size = CharacterUtils.getSize(length);
            long time = System.currentTimeMillis();
            String randomFileName = time + FileUtility.randomName(fileName);

            info.getTotalSize().add(length);
            info.getHasRead().add(0L);

            bean.setDate(date);
            bean.setAuthorId(1l);
            bean.setAuthorName("李浩");
            bean.setName(fileName); //文件真名
            bean.setSize(size);
            bean.setRealSize(length);
            bean.setType(type);
            bean.setRandomName(randomFileName);

//            FileChannel fileChannel  = file.get

            try {


                //得到要保存的文件
                File tempFile = new File(FileStorage.getDocumentItemStorage(request),
                        String.valueOf(documentCatalogId) + File.separator + randomFileName);

                System.out.println("-----"+tempFile.getAbsolutePath());

                //创建父目录
                FileUtils.forceMkdir(tempFile.getParentFile());

//                FileChannel fileChannel = new RandomAccessFile(file.get(i), "rw").getChannel();
//                fileChannel.transferTo(0, length, new RandomAccessFile(tempFile,"rw").getChannel());
                InputStream is = new FileInputStream(file.get(i));
                OutputStream os = new FileOutputStream(tempFile);

                int len = 0;
                byte[] buffer =new byte[1024];
                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer,0,len);

                    //模拟延时
                    Thread.sleep(50);

                    //当前一共读取了多少字节
//                    info.setHasRead(info.getHasRead()+len);
                    info.getHasRead().set(i,info.getHasRead().get(i)+len);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            list.add(bean);

        }

        documentItemService.saveDocumentItems(documentCatalog,list);

        //清除session中的对象
        request.getSession().removeAttribute("uploadInfo");


        return "success";
    }

    public void validateUpload() {

        long totalSize = file.stream().mapToLong(f -> f.length()).sum();

        if (totalSize > Constants.MAX_FILE_SIZE) {
            this.addActionError("上传文件不能超过" + (Constants.MAX_FILE_SIZE / 1024 / 1024) + "M");
            System.out.println("上次文件不能超过" + (Constants.MAX_FILE_SIZE / 1024 / 1024) + "M");
        }
        System.out.println("totalSize === " + totalSize);
    }
}
