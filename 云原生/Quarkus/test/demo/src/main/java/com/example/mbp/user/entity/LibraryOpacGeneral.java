package com.example.mbp.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * opac概要信息
 */
public class LibraryOpacGeneral implements Serializable {
    /**
     * 控制号
     */
    private String ctrlNo;

    /**
     * marc编号
     */
    private Long marcId;

    /**
     * marc源
     */
    private String marcSource;

    /**
     * 状态
     */
    private String status;

    /**
     * 期刊标志
     */
    private Byte journalFlag;

    /**
     * ISBN/ISSN
     */
    private String infoIsbn;

    /**
     * ISBN/ISSN(去掉-)
     */
    private String infoIsbnValue;

    /**
     * 标题
     */
    private String infoTitle;

    /**
     * 主要作者
     */
    private String infoAuthor;

    /**
     * 出版地
     */
    private String infoPublocale;

    /**
     * 出版社
     */
    private String infoPublisher;

    /**
     * 出版日期
     */
    private String infoPubdate;

    /**
     * 改刊编号
     */
    private String changeId;

    /**
     * 改刊指示符
     */
    private Integer changeIndex;

    /**
     * 出版日期(时间类型)
     */
    private Date infoPubdateValue;

    /**
     * 统一书号
     */
    private String infoUbsn;

    /**
     * 中图分类
     */
    private String infoClc;

    /**
     * 科图法分类
     */
    private String infoLccsa;

    /**
     * 作品语种
     */
    private String infoLanguage;

    /**
     * 载体形态项
     */
    private String infoMediumInfo;

    /**
     * 版本项
     */
    private String infoEditionInfo;

    /**
     * 从编项
     */
    private String infoSeriesInfo;

    /**
     * 主题词信息
     */
    private String infoSubjectInfo;

    /**
     * 封面信息
     */
    private String infoCover;

    /**
     * 计算识别码
     */
    private String calcCode;

    /**
     * 藏书数
     */
    private Integer collectionCnt;

    /**
     * 不可借的数量
     */
    private Integer unlendableCnt;

    /**
     * 借出的数量
     */
    private Integer lendCnt;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 文种(文字种类,例如中文)
     */
    private String infoCharacter;

    /**
     * 资料库类型
     */
    private String infoDbType;

    /**
     * 文档类型
     */
    private String infoDocType;

    /**
     * 题名和责任项信息
     */
    private String infoTitleAuthorInfo;

    private static final long serialVersionUID = 1L;

    public String getCtrlNo() {
        return ctrlNo;
    }

    public void setCtrlNo(String ctrlNo) {
        this.ctrlNo = ctrlNo;
    }

    public Long getMarcId() {
        return marcId;
    }

    public void setMarcId(Long marcId) {
        this.marcId = marcId;
    }

    public String getMarcSource() {
        return marcSource;
    }

    public void setMarcSource(String marcSource) {
        this.marcSource = marcSource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte getJournalFlag() {
        return journalFlag;
    }

    public void setJournalFlag(Byte journalFlag) {
        this.journalFlag = journalFlag;
    }

    public String getInfoIsbn() {
        return infoIsbn;
    }

    public void setInfoIsbn(String infoIsbn) {
        this.infoIsbn = infoIsbn;
    }

    public String getInfoIsbnValue() {
        return infoIsbnValue;
    }

    public void setInfoIsbnValue(String infoIsbnValue) {
        this.infoIsbnValue = infoIsbnValue;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoAuthor() {
        return infoAuthor;
    }

    public void setInfoAuthor(String infoAuthor) {
        this.infoAuthor = infoAuthor;
    }

    public String getInfoPublocale() {
        return infoPublocale;
    }

    public void setInfoPublocale(String infoPublocale) {
        this.infoPublocale = infoPublocale;
    }

    public String getInfoPublisher() {
        return infoPublisher;
    }

    public void setInfoPublisher(String infoPublisher) {
        this.infoPublisher = infoPublisher;
    }

    public String getInfoPubdate() {
        return infoPubdate;
    }

    public void setInfoPubdate(String infoPubdate) {
        this.infoPubdate = infoPubdate;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public Integer getChangeIndex() {
        return changeIndex;
    }

    public void setChangeIndex(Integer changeIndex) {
        this.changeIndex = changeIndex;
    }

    public Date getInfoPubdateValue() {
        return infoPubdateValue;
    }

    public void setInfoPubdateValue(Date infoPubdateValue) {
        this.infoPubdateValue = infoPubdateValue;
    }

    public String getInfoUbsn() {
        return infoUbsn;
    }

    public void setInfoUbsn(String infoUbsn) {
        this.infoUbsn = infoUbsn;
    }

    public String getInfoClc() {
        return infoClc;
    }

    public void setInfoClc(String infoClc) {
        this.infoClc = infoClc;
    }

    public String getInfoLccsa() {
        return infoLccsa;
    }

    public void setInfoLccsa(String infoLccsa) {
        this.infoLccsa = infoLccsa;
    }

    public String getInfoLanguage() {
        return infoLanguage;
    }

    public void setInfoLanguage(String infoLanguage) {
        this.infoLanguage = infoLanguage;
    }

    public String getInfoMediumInfo() {
        return infoMediumInfo;
    }

    public void setInfoMediumInfo(String infoMediumInfo) {
        this.infoMediumInfo = infoMediumInfo;
    }

    public String getInfoEditionInfo() {
        return infoEditionInfo;
    }

    public void setInfoEditionInfo(String infoEditionInfo) {
        this.infoEditionInfo = infoEditionInfo;
    }

    public String getInfoSeriesInfo() {
        return infoSeriesInfo;
    }

    public void setInfoSeriesInfo(String infoSeriesInfo) {
        this.infoSeriesInfo = infoSeriesInfo;
    }

    public String getInfoSubjectInfo() {
        return infoSubjectInfo;
    }

    public void setInfoSubjectInfo(String infoSubjectInfo) {
        this.infoSubjectInfo = infoSubjectInfo;
    }

    public String getInfoCover() {
        return infoCover;
    }

    public void setInfoCover(String infoCover) {
        this.infoCover = infoCover;
    }

    public String getCalcCode() {
        return calcCode;
    }

    public void setCalcCode(String calcCode) {
        this.calcCode = calcCode;
    }

    public Integer getCollectionCnt() {
        return collectionCnt;
    }

    public void setCollectionCnt(Integer collectionCnt) {
        this.collectionCnt = collectionCnt;
    }

    public Integer getUnlendableCnt() {
        return unlendableCnt;
    }

    public void setUnlendableCnt(Integer unlendableCnt) {
        this.unlendableCnt = unlendableCnt;
    }

    public Integer getLendCnt() {
        return lendCnt;
    }

    public void setLendCnt(Integer lendCnt) {
        this.lendCnt = lendCnt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getInfoCharacter() {
        return infoCharacter;
    }

    public void setInfoCharacter(String infoCharacter) {
        this.infoCharacter = infoCharacter;
    }

    public String getInfoDbType() {
        return infoDbType;
    }

    public void setInfoDbType(String infoDbType) {
        this.infoDbType = infoDbType;
    }

    public String getInfoDocType() {
        return infoDocType;
    }

    public void setInfoDocType(String infoDocType) {
        this.infoDocType = infoDocType;
    }

    public String getInfoTitleAuthorInfo() {
        return infoTitleAuthorInfo;
    }

    public void setInfoTitleAuthorInfo(String infoTitleAuthorInfo) {
        this.infoTitleAuthorInfo = infoTitleAuthorInfo;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LibraryOpacGeneral other = (LibraryOpacGeneral) that;
        return (this.getCtrlNo() == null ? other.getCtrlNo() == null : this.getCtrlNo().equals(other.getCtrlNo()))
            && (this.getMarcId() == null ? other.getMarcId() == null : this.getMarcId().equals(other.getMarcId()))
            && (this.getMarcSource() == null ? other.getMarcSource() == null : this.getMarcSource().equals(other.getMarcSource()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getJournalFlag() == null ? other.getJournalFlag() == null : this.getJournalFlag().equals(other.getJournalFlag()))
            && (this.getInfoIsbn() == null ? other.getInfoIsbn() == null : this.getInfoIsbn().equals(other.getInfoIsbn()))
            && (this.getInfoIsbnValue() == null ? other.getInfoIsbnValue() == null : this.getInfoIsbnValue().equals(other.getInfoIsbnValue()))
            && (this.getInfoTitle() == null ? other.getInfoTitle() == null : this.getInfoTitle().equals(other.getInfoTitle()))
            && (this.getInfoAuthor() == null ? other.getInfoAuthor() == null : this.getInfoAuthor().equals(other.getInfoAuthor()))
            && (this.getInfoPublocale() == null ? other.getInfoPublocale() == null : this.getInfoPublocale().equals(other.getInfoPublocale()))
            && (this.getInfoPublisher() == null ? other.getInfoPublisher() == null : this.getInfoPublisher().equals(other.getInfoPublisher()))
            && (this.getInfoPubdate() == null ? other.getInfoPubdate() == null : this.getInfoPubdate().equals(other.getInfoPubdate()))
            && (this.getChangeId() == null ? other.getChangeId() == null : this.getChangeId().equals(other.getChangeId()))
            && (this.getChangeIndex() == null ? other.getChangeIndex() == null : this.getChangeIndex().equals(other.getChangeIndex()))
            && (this.getInfoPubdateValue() == null ? other.getInfoPubdateValue() == null : this.getInfoPubdateValue().equals(other.getInfoPubdateValue()))
            && (this.getInfoUbsn() == null ? other.getInfoUbsn() == null : this.getInfoUbsn().equals(other.getInfoUbsn()))
            && (this.getInfoClc() == null ? other.getInfoClc() == null : this.getInfoClc().equals(other.getInfoClc()))
            && (this.getInfoLccsa() == null ? other.getInfoLccsa() == null : this.getInfoLccsa().equals(other.getInfoLccsa()))
            && (this.getInfoLanguage() == null ? other.getInfoLanguage() == null : this.getInfoLanguage().equals(other.getInfoLanguage()))
            && (this.getInfoMediumInfo() == null ? other.getInfoMediumInfo() == null : this.getInfoMediumInfo().equals(other.getInfoMediumInfo()))
            && (this.getInfoEditionInfo() == null ? other.getInfoEditionInfo() == null : this.getInfoEditionInfo().equals(other.getInfoEditionInfo()))
            && (this.getInfoSeriesInfo() == null ? other.getInfoSeriesInfo() == null : this.getInfoSeriesInfo().equals(other.getInfoSeriesInfo()))
            && (this.getInfoSubjectInfo() == null ? other.getInfoSubjectInfo() == null : this.getInfoSubjectInfo().equals(other.getInfoSubjectInfo()))
            && (this.getInfoCover() == null ? other.getInfoCover() == null : this.getInfoCover().equals(other.getInfoCover()))
            && (this.getCalcCode() == null ? other.getCalcCode() == null : this.getCalcCode().equals(other.getCalcCode()))
            && (this.getCollectionCnt() == null ? other.getCollectionCnt() == null : this.getCollectionCnt().equals(other.getCollectionCnt()))
            && (this.getUnlendableCnt() == null ? other.getUnlendableCnt() == null : this.getUnlendableCnt().equals(other.getUnlendableCnt()))
            && (this.getLendCnt() == null ? other.getLendCnt() == null : this.getLendCnt().equals(other.getLendCnt()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getInfoCharacter() == null ? other.getInfoCharacter() == null : this.getInfoCharacter().equals(other.getInfoCharacter()))
            && (this.getInfoDbType() == null ? other.getInfoDbType() == null : this.getInfoDbType().equals(other.getInfoDbType()))
            && (this.getInfoDocType() == null ? other.getInfoDocType() == null : this.getInfoDocType().equals(other.getInfoDocType()))
            && (this.getInfoTitleAuthorInfo() == null ? other.getInfoTitleAuthorInfo() == null : this.getInfoTitleAuthorInfo().equals(other.getInfoTitleAuthorInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCtrlNo() == null) ? 0 : getCtrlNo().hashCode());
        result = prime * result + ((getMarcId() == null) ? 0 : getMarcId().hashCode());
        result = prime * result + ((getMarcSource() == null) ? 0 : getMarcSource().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getJournalFlag() == null) ? 0 : getJournalFlag().hashCode());
        result = prime * result + ((getInfoIsbn() == null) ? 0 : getInfoIsbn().hashCode());
        result = prime * result + ((getInfoIsbnValue() == null) ? 0 : getInfoIsbnValue().hashCode());
        result = prime * result + ((getInfoTitle() == null) ? 0 : getInfoTitle().hashCode());
        result = prime * result + ((getInfoAuthor() == null) ? 0 : getInfoAuthor().hashCode());
        result = prime * result + ((getInfoPublocale() == null) ? 0 : getInfoPublocale().hashCode());
        result = prime * result + ((getInfoPublisher() == null) ? 0 : getInfoPublisher().hashCode());
        result = prime * result + ((getInfoPubdate() == null) ? 0 : getInfoPubdate().hashCode());
        result = prime * result + ((getChangeId() == null) ? 0 : getChangeId().hashCode());
        result = prime * result + ((getChangeIndex() == null) ? 0 : getChangeIndex().hashCode());
        result = prime * result + ((getInfoPubdateValue() == null) ? 0 : getInfoPubdateValue().hashCode());
        result = prime * result + ((getInfoUbsn() == null) ? 0 : getInfoUbsn().hashCode());
        result = prime * result + ((getInfoClc() == null) ? 0 : getInfoClc().hashCode());
        result = prime * result + ((getInfoLccsa() == null) ? 0 : getInfoLccsa().hashCode());
        result = prime * result + ((getInfoLanguage() == null) ? 0 : getInfoLanguage().hashCode());
        result = prime * result + ((getInfoMediumInfo() == null) ? 0 : getInfoMediumInfo().hashCode());
        result = prime * result + ((getInfoEditionInfo() == null) ? 0 : getInfoEditionInfo().hashCode());
        result = prime * result + ((getInfoSeriesInfo() == null) ? 0 : getInfoSeriesInfo().hashCode());
        result = prime * result + ((getInfoSubjectInfo() == null) ? 0 : getInfoSubjectInfo().hashCode());
        result = prime * result + ((getInfoCover() == null) ? 0 : getInfoCover().hashCode());
        result = prime * result + ((getCalcCode() == null) ? 0 : getCalcCode().hashCode());
        result = prime * result + ((getCollectionCnt() == null) ? 0 : getCollectionCnt().hashCode());
        result = prime * result + ((getUnlendableCnt() == null) ? 0 : getUnlendableCnt().hashCode());
        result = prime * result + ((getLendCnt() == null) ? 0 : getLendCnt().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getInfoCharacter() == null) ? 0 : getInfoCharacter().hashCode());
        result = prime * result + ((getInfoDbType() == null) ? 0 : getInfoDbType().hashCode());
        result = prime * result + ((getInfoDocType() == null) ? 0 : getInfoDocType().hashCode());
        result = prime * result + ((getInfoTitleAuthorInfo() == null) ? 0 : getInfoTitleAuthorInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ctrlNo=").append(ctrlNo);
        sb.append(", marcId=").append(marcId);
        sb.append(", marcSource=").append(marcSource);
        sb.append(", status=").append(status);
        sb.append(", journalFlag=").append(journalFlag);
        sb.append(", infoIsbn=").append(infoIsbn);
        sb.append(", infoIsbnValue=").append(infoIsbnValue);
        sb.append(", infoTitle=").append(infoTitle);
        sb.append(", infoAuthor=").append(infoAuthor);
        sb.append(", infoPublocale=").append(infoPublocale);
        sb.append(", infoPublisher=").append(infoPublisher);
        sb.append(", infoPubdate=").append(infoPubdate);
        sb.append(", changeId=").append(changeId);
        sb.append(", changeIndex=").append(changeIndex);
        sb.append(", infoPubdateValue=").append(infoPubdateValue);
        sb.append(", infoUbsn=").append(infoUbsn);
        sb.append(", infoClc=").append(infoClc);
        sb.append(", infoLccsa=").append(infoLccsa);
        sb.append(", infoLanguage=").append(infoLanguage);
        sb.append(", infoMediumInfo=").append(infoMediumInfo);
        sb.append(", infoEditionInfo=").append(infoEditionInfo);
        sb.append(", infoSeriesInfo=").append(infoSeriesInfo);
        sb.append(", infoSubjectInfo=").append(infoSubjectInfo);
        sb.append(", infoCover=").append(infoCover);
        sb.append(", calcCode=").append(calcCode);
        sb.append(", collectionCnt=").append(collectionCnt);
        sb.append(", unlendableCnt=").append(unlendableCnt);
        sb.append(", lendCnt=").append(lendCnt);
        sb.append(", createUser=").append(createUser);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", infoCharacter=").append(infoCharacter);
        sb.append(", infoDbType=").append(infoDbType);
        sb.append(", infoDocType=").append(infoDocType);
        sb.append(", infoTitleAuthorInfo=").append(infoTitleAuthorInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}