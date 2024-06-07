package com.example.mbp.world.mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 
 */
public class LibAsset implements Serializable {
    /**
     * 馆藏详情编号
     */
    private Long assetId;

    /**
     * 资产编号
     */
    private String assetNo;

    /**
     * 条形码
     */
    private String barcode;

    /**
     * 书籍编号
     */
    private Long ctrlId;

    /**
     * 馆藏编号
     */
    private String orgId;

    /**
     * 索取号
     */
    private String callNo;

    /**
     * 卷期
     */
    private String volume;

    /**
     * 装帧
     */
    private String bindery;

    /**
     * 价格
     */
    private String price;

    /**
     * 价格(分)
     */
    private Integer priceVal;

    /**
     * 版本
     */
    private String edition;

    /**
     * 状态
     */
    private String status;

    /**
     * 书籍属性预留
     */
    private String prop0;

    /**
     * 书籍属性预留
     */
    private String prop1;

    /**
     * 书籍属性预留
     */
    private String prop2;

    /**
     * 书籍属性预留
     */
    private String prop3;

    private String callNo0;

    private String callNo1;

    private String callNo2;

    private String callNo3;

    private String sourceId;

    private String sourceType;

    /**
     * 借书次数
     */
    private Integer loanTimes;

    private String errMsg;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 特藏码
     */
    private String specCode;

    /**
     * 假数据标记: 0正常数据 1假数据
     */
    private Integer faker;

    private static final long serialVersionUID = 1L;

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Long getCtrlId() {
        return ctrlId;
    }

    public void setCtrlId(Long ctrlId) {
        this.ctrlId = ctrlId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBindery() {
        return bindery;
    }

    public void setBindery(String bindery) {
        this.bindery = bindery;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPriceVal() {
        return priceVal;
    }

    public void setPriceVal(Integer priceVal) {
        this.priceVal = priceVal;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProp0() {
        return prop0;
    }

    public void setProp0(String prop0) {
        this.prop0 = prop0;
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getCallNo0() {
        return callNo0;
    }

    public void setCallNo0(String callNo0) {
        this.callNo0 = callNo0;
    }

    public String getCallNo1() {
        return callNo1;
    }

    public void setCallNo1(String callNo1) {
        this.callNo1 = callNo1;
    }

    public String getCallNo2() {
        return callNo2;
    }

    public void setCallNo2(String callNo2) {
        this.callNo2 = callNo2;
    }

    public String getCallNo3() {
        return callNo3;
    }

    public void setCallNo3(String callNo3) {
        this.callNo3 = callNo3;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getLoanTimes() {
        return loanTimes;
    }

    public void setLoanTimes(Integer loanTimes) {
        this.loanTimes = loanTimes;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public Integer getFaker() {
        return faker;
    }

    public void setFaker(Integer faker) {
        this.faker = faker;
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
        LibAsset other = (LibAsset) that;
        return (this.getAssetId() == null ? other.getAssetId() == null : this.getAssetId().equals(other.getAssetId()))
            && (this.getAssetNo() == null ? other.getAssetNo() == null : this.getAssetNo().equals(other.getAssetNo()))
            && (this.getBarcode() == null ? other.getBarcode() == null : this.getBarcode().equals(other.getBarcode()))
            && (this.getCtrlId() == null ? other.getCtrlId() == null : this.getCtrlId().equals(other.getCtrlId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getCallNo() == null ? other.getCallNo() == null : this.getCallNo().equals(other.getCallNo()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getBindery() == null ? other.getBindery() == null : this.getBindery().equals(other.getBindery()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPriceVal() == null ? other.getPriceVal() == null : this.getPriceVal().equals(other.getPriceVal()))
            && (this.getEdition() == null ? other.getEdition() == null : this.getEdition().equals(other.getEdition()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProp0() == null ? other.getProp0() == null : this.getProp0().equals(other.getProp0()))
            && (this.getProp1() == null ? other.getProp1() == null : this.getProp1().equals(other.getProp1()))
            && (this.getProp2() == null ? other.getProp2() == null : this.getProp2().equals(other.getProp2()))
            && (this.getProp3() == null ? other.getProp3() == null : this.getProp3().equals(other.getProp3()))
            && (this.getCallNo0() == null ? other.getCallNo0() == null : this.getCallNo0().equals(other.getCallNo0()))
            && (this.getCallNo1() == null ? other.getCallNo1() == null : this.getCallNo1().equals(other.getCallNo1()))
            && (this.getCallNo2() == null ? other.getCallNo2() == null : this.getCallNo2().equals(other.getCallNo2()))
            && (this.getCallNo3() == null ? other.getCallNo3() == null : this.getCallNo3().equals(other.getCallNo3()))
            && (this.getSourceId() == null ? other.getSourceId() == null : this.getSourceId().equals(other.getSourceId()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getLoanTimes() == null ? other.getLoanTimes() == null : this.getLoanTimes().equals(other.getLoanTimes()))
            && (this.getErrMsg() == null ? other.getErrMsg() == null : this.getErrMsg().equals(other.getErrMsg()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getSpecCode() == null ? other.getSpecCode() == null : this.getSpecCode().equals(other.getSpecCode()))
            && (this.getFaker() == null ? other.getFaker() == null : this.getFaker().equals(other.getFaker()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAssetId() == null) ? 0 : getAssetId().hashCode());
        result = prime * result + ((getAssetNo() == null) ? 0 : getAssetNo().hashCode());
        result = prime * result + ((getBarcode() == null) ? 0 : getBarcode().hashCode());
        result = prime * result + ((getCtrlId() == null) ? 0 : getCtrlId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getCallNo() == null) ? 0 : getCallNo().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getBindery() == null) ? 0 : getBindery().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPriceVal() == null) ? 0 : getPriceVal().hashCode());
        result = prime * result + ((getEdition() == null) ? 0 : getEdition().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProp0() == null) ? 0 : getProp0().hashCode());
        result = prime * result + ((getProp1() == null) ? 0 : getProp1().hashCode());
        result = prime * result + ((getProp2() == null) ? 0 : getProp2().hashCode());
        result = prime * result + ((getProp3() == null) ? 0 : getProp3().hashCode());
        result = prime * result + ((getCallNo0() == null) ? 0 : getCallNo0().hashCode());
        result = prime * result + ((getCallNo1() == null) ? 0 : getCallNo1().hashCode());
        result = prime * result + ((getCallNo2() == null) ? 0 : getCallNo2().hashCode());
        result = prime * result + ((getCallNo3() == null) ? 0 : getCallNo3().hashCode());
        result = prime * result + ((getSourceId() == null) ? 0 : getSourceId().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getLoanTimes() == null) ? 0 : getLoanTimes().hashCode());
        result = prime * result + ((getErrMsg() == null) ? 0 : getErrMsg().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getSpecCode() == null) ? 0 : getSpecCode().hashCode());
        result = prime * result + ((getFaker() == null) ? 0 : getFaker().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", assetId=").append(assetId);
        sb.append(", assetNo=").append(assetNo);
        sb.append(", barcode=").append(barcode);
        sb.append(", ctrlId=").append(ctrlId);
        sb.append(", orgId=").append(orgId);
        sb.append(", callNo=").append(callNo);
        sb.append(", volume=").append(volume);
        sb.append(", bindery=").append(bindery);
        sb.append(", price=").append(price);
        sb.append(", priceVal=").append(priceVal);
        sb.append(", edition=").append(edition);
        sb.append(", status=").append(status);
        sb.append(", prop0=").append(prop0);
        sb.append(", prop1=").append(prop1);
        sb.append(", prop2=").append(prop2);
        sb.append(", prop3=").append(prop3);
        sb.append(", callNo0=").append(callNo0);
        sb.append(", callNo1=").append(callNo1);
        sb.append(", callNo2=").append(callNo2);
        sb.append(", callNo3=").append(callNo3);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", loanTimes=").append(loanTimes);
        sb.append(", errMsg=").append(errMsg);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", specCode=").append(specCode);
        sb.append(", faker=").append(faker);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}