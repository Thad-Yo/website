package com.website.mybatis.bean.ext.system;

import lombok.Data;

/**
 * <p>Title: ${file_name}</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 *
 * @author twh
 * @version 1.0
 * @date ${date}
 */
@Data
public class ExtUploadErrorModel {
    private String lineNo;
    private String fieldName;
    private String value;
    private String errorMessage;

    public ExtUploadErrorModel() {
    }

    public ExtUploadErrorModel(String lineNo, String fieldName, String value, String errorMessage) {
        this.lineNo = lineNo;
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
        this.value = value;
    }
}
