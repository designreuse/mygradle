package com.git.service;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentitemEntity;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
public interface DocumentItemService {
    List<DocumentitemEntity> listDocumentItmesByDocumentCatalogId(long documentCatalogId);
}
