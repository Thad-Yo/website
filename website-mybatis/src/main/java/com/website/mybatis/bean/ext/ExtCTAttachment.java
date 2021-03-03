package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.system.CTAttachment;
import lombok.Data;

import java.util.List;

@Data
public class ExtCTAttachment extends CTAttachment {
	private List<CTAttachment> ctAttachmentList;
}
