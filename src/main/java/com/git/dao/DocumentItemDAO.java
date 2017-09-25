package com.git.dao;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentitemEntity;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
public interface DocumentItemDAO {

    List<DocumentitemEntity> listDocumentItmesByDocumentCatalogId(long documentCatalogId);

}
