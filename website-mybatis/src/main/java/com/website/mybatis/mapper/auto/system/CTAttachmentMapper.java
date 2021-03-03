package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.auto.system.CTAttachmentExample;

public interface CTAttachmentMapper {
    int countByExample(CTAttachmentExample example);

    int deleteByExample(CTAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CTAttachment record);

    int insertSelective(CTAttachment record);

    List<CTAttachment> selectByExample(CTAttachmentExample example);

    CTAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CTAttachment record, @Param("example") CTAttachmentExample example);

    int updateByExample(@Param("record") CTAttachment record, @Param("example") CTAttachmentExample example);

    int updateByPrimaryKeySelective(CTAttachment record);

    int updateByPrimaryKey(CTAttachment record);
}