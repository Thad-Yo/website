package com.website.mybatis.bean.ext.system;

import com.website.mybatis.bean.auto.system.CTAttachment;

/**
 * <p>Title: ${FILE_NAME}</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 *
 * @author twh
 * @version 1.0
 * @date 2017/4/18 0018
 */
public class ExtAttachment extends CTAttachment {
    private String attachmentId;

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
