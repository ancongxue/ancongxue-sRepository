package acx.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BuyOrder {
	
	private Integer boId;
	private Integer supId;
	private Integer shId;
	private Date boDate;
	private BigDecimal boPayable;
	private BigDecimal boPaid;
	private BigDecimal boArrears;
	private String boOriginal;
	private String boRemark;
	private String boAttn;
	private Integer boOperator;
	//一对多？加了这个字段？
	private List<BuyOrderDetail> buyOrderDetail;
	public Integer getBoId() {
		return boId;
	}
	public void setBoId(Integer boId) {
		this.boId = boId;
	}
	public Integer getSupId() {
		return supId;
	}
	public void setSupId(Integer supId) {
		this.supId = supId;
	}
	public Integer getShId() {
		return shId;
	}
	public void setShId(Integer shId) {
		this.shId = shId;
	}
	public Date getBoDate() {
		return boDate;
	}
	public void setBoDate(Date boDate) {
		this.boDate = boDate;
	}
	public BigDecimal getBoPayable() {
		return boPayable;
	}
	public void setBoPayable(BigDecimal boPayable) {
		this.boPayable = boPayable;
	}
	public BigDecimal getBoPaid() {
		return boPaid;
	}
	public void setBoPaid(BigDecimal boPaid) {
		this.boPaid = boPaid;
	}
	public BigDecimal getBoArrears() {
		return boArrears;
	}
	public void setBoArrears(BigDecimal boArrears) {
		this.boArrears = boArrears;
	}
	public String getBoOriginal() {
		return boOriginal;
	}
	public void setBoOriginal(String boOriginal) {
		this.boOriginal = boOriginal;
	}
	public String getBoRemark() {
		return boRemark;
	}
	public void setBoRemark(String boRemark) {
		this.boRemark = boRemark;
	}
	public String getBoAttn() {
		return boAttn;
	}
	public void setBoAttn(String boAttn) {
		this.boAttn = boAttn;
	}
	public Integer getBoOperator() {
		return boOperator;
	}
	public void setBoOperator(Integer boOperator) {
		this.boOperator = boOperator;
	}
	public List<BuyOrderDetail> getBuyOrderDetail() {
		return buyOrderDetail;
	}
	public void setBuyOrderDetail(List<BuyOrderDetail> buyOrderDetail) {
		this.buyOrderDetail = buyOrderDetail;
	}
	@Override
	public String toString() {
		return "BuyOrder [boId=" + boId + ", supId=" + supId + ", shId=" + shId + ", boDate=" + boDate + ", boPayable="
				+ boPayable + ", boPaid=" + boPaid + ", boArrears=" + boArrears + ", boOriginal=" + boOriginal
				+ ", boRemark=" + boRemark + ", boAttn=" + boAttn + ", boOperator=" + boOperator + ", buyOrderDetail="
				+ buyOrderDetail + "]";
	}
	
	

}
