package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.*;

import java.util.List;

public class ExtHrResumeModel {
    private HrResumeBasic hrResumeBasic;
    private List<HrResumeEducation> hrResumeEducationList;
    private List<HrResumeWork> hrResumeWorkList;
    private List<HrResumeProject> hrResumeProjectList;
    private List<HrResumeSkill> hrResumeSkillList;
    private List<HrResumeLanguage> hrResumeLanguageList;
    private List<HrResumeDuty> hrResumeDutyList;
    private List<HrResumeHonor> hrResumeHonorList;
    private List<CTResumeAttachment> ctResumeAttachmentList;
    private String webResumeBasic;
    private String webResumeEducationList;
    private String webResumeWorkList;
    private String webResumeProjectList;
    private String webResumeLanguageList;
    private String webResumeDutyList;
    private String webResumeHonorList;


    /**
     * 培训经历
     */
    private List<HrResumeTrain> hrResumeTrainList;
    /**
     * 在校实践经历
     */
    private List<HrResumePractice> hrResumePracticeList;

    public HrResumeBasic getHrResumeBasic() {
        return hrResumeBasic;
    }

    public void setHrResumeBasic(HrResumeBasic hrResumeBasic) {
        this.hrResumeBasic = hrResumeBasic;
    }

    public List<HrResumeEducation> getHrResumeEducationList() {
        return hrResumeEducationList;
    }

    public void setHrResumeEducationList(List<HrResumeEducation> hrResumeEducationList) {
        this.hrResumeEducationList = hrResumeEducationList;
    }

    public List<HrResumeWork> getHrResumeWorkList() {
        return hrResumeWorkList;
    }

    public void setHrResumeWorkList(List<HrResumeWork> hrResumeWorkList) {
        this.hrResumeWorkList = hrResumeWorkList;
    }

    public List<HrResumeProject> getHrResumeProjectList() {
        return hrResumeProjectList;
    }

    public void setHrResumeProjectList(List<HrResumeProject> hrResumeProjectList) {
        this.hrResumeProjectList = hrResumeProjectList;
    }

    public List<HrResumeSkill> getHrResumeSkillList() {
        return hrResumeSkillList;
    }

    public void setHrResumeSkillList(List<HrResumeSkill> hrResumeSkillList) {
        this.hrResumeSkillList = hrResumeSkillList;
    }

    public List<HrResumeLanguage> getHrResumeLanguageList() {
        return hrResumeLanguageList;
    }

    public void setHrResumeLanguageList(List<HrResumeLanguage> hrResumeLanguageList) {
        this.hrResumeLanguageList = hrResumeLanguageList;
    }

    public List<HrResumeDuty> getHrResumeDutyList() {
        return hrResumeDutyList;
    }

    public void setHrResumeDutyList(List<HrResumeDuty> hrResumeDutyList) {
        this.hrResumeDutyList = hrResumeDutyList;
    }

    public List<HrResumeHonor> getHrResumeHonorList() {
        return hrResumeHonorList;
    }

    public void setHrResumeHonorList(List<HrResumeHonor> hrResumeHonorList) {
        this.hrResumeHonorList = hrResumeHonorList;
    }

    public List<CTResumeAttachment> getCtResumeAttachmentList() {
        return ctResumeAttachmentList;
    }

    public void setCtResumeAttachmentList(List<CTResumeAttachment> ctResumeAttachmentList) {
        this.ctResumeAttachmentList = ctResumeAttachmentList;
    }

	public List<HrResumeTrain> getHrResumeTrainList() {
		return hrResumeTrainList;
	}

	public void setHrResumeTrainList(List<HrResumeTrain> hrResumeTrainList) {
		this.hrResumeTrainList = hrResumeTrainList;
	}

	public List<HrResumePractice> getHrResumePracticeList() {
		return hrResumePracticeList;
	}

	public void setHrResumePracticeList(List<HrResumePractice> hrResumePracticeList) {
		this.hrResumePracticeList = hrResumePracticeList;
	}

    public String getWebResumeEducationList() {
        return webResumeEducationList;
    }

    public void setWebResumeEducationList(String webResumeEducationList) {
        this.webResumeEducationList = webResumeEducationList;
    }

    public String getWebResumeWorkList() {
        return webResumeWorkList;
    }

    public void setWebResumeWorkList(String webResumeWorkList) {
        this.webResumeWorkList = webResumeWorkList;
    }

    public String getWebResumeProjectList() {
        return webResumeProjectList;
    }

    public void setWebResumeProjectList(String webResumeProjectList) {
        this.webResumeProjectList = webResumeProjectList;
    }

    public String getWebResumeLanguageList() {
        return webResumeLanguageList;
    }

    public void setWebResumeLanguageList(String webResumeLanguageList) {
        this.webResumeLanguageList = webResumeLanguageList;
    }

    public String getWebResumeDutyList() {
        return webResumeDutyList;
    }

    public void setWebResumeDutyList(String webResumeDutyList) {
        this.webResumeDutyList = webResumeDutyList;
    }

    public String getWebResumeHonorList() {
        return webResumeHonorList;
    }

    public void setWebResumeHonorList(String webResumeHonorList) {
        this.webResumeHonorList = webResumeHonorList;
    }

    public String getWebResumeBasic() {
        return webResumeBasic;
    }

    public void setWebResumeBasic(String webResumeBasic) {
        this.webResumeBasic = webResumeBasic;
    }
}
