package acx.entity;

import java.math.BigDecimal;

public class Supplier {
	
    private Integer supId;
    private String supName;
    private String supLinkman;
    private String supPhone;
    private String supAddress;
    private String supRemark;    
    private BigDecimal supPay;
    private String supType;



    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName == null ? null : supName.trim();
    }

    public String getSupLinkman() {
        return supLinkman;
    }

    public void setSupLinkman(String supLinkman) {
        this.supLinkman = supLinkman == null ? null : supLinkman.trim();
    }

    public String getSupPhone() {
        return supPhone;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone == null ? null : supPhone.trim();
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress == null ? null : supAddress.trim();
    }

    public String getSupRemark() {
        return supRemark;
    }

    public void setSupRemark(String supRemark) {
        this.supRemark = supRemark == null ? null : supRemark.trim();
    }
}