package acx.entity;

import java.math.BigDecimal;
import java.util.Date;

//有时候实体类要实现Serializable接口，有的不用实现，这是为什么？

public class AccountRecords {

	private String arId;
	private Integer supId;
	private Date arDate;
	private String arOrderId;
	private String arBusType;
	private BigDecimal arPayable;
	private BigDecimal arPaid;
	//数据库里的Decimal对应java里的BigDecimal
	private BigDecimal arRears;
	private BigDecimal arDiscount;
	private String arAttn;
	//为什么操作员是数字？
	private Integer arOperator;
	private String arRemark;
	public String getArId() {
		return arId;
	}
	public void setArId(String arId) {
		this.arId = arId;
	}
	public Integer getSupId() {
		return supId;
	}
	public void setSupId(Integer supId) {
		this.supId = supId;
	}
	public Date getArDate() {
		return arDate;
	}
	public void setArDate(Date arDate) {
		this.arDate = arDate;
	}
	public String getArOrderId() {
		return arOrderId;
	}
	public void setArOrderId(String arOrderId) {
		this.arOrderId = arOrderId;
	}
	public String getArBusType() {
		return arBusType;
	}
	public void setArBusType(String arBusType) {
		this.arBusType = arBusType;
	}
	public BigDecimal getArPayable() {
		return arPayable;
	}
	public void setArPayable(BigDecimal arPayable) {
		this.arPayable = arPayable;
	}
	public BigDecimal getArPaid() {
		return arPaid;
	}
	public void setArPaid(BigDecimal arPaid) {
		this.arPaid = arPaid;
	}
	public BigDecimal getArRears() {
		return arRears;
	}
	public void setArRears(BigDecimal arRears) {
		this.arRears = arRears;
	}
	public BigDecimal getArDiscount() {
		return arDiscount;
	}
	public void setArDiscount(BigDecimal arDiscount) {
		this.arDiscount = arDiscount;
	}
	public String getArAttn() {
		return arAttn;
	}
	public void setArAttn(String arAttn) {
		this.arAttn = arAttn;
	}
	public Integer getArOperator() {
		return arOperator;
	}
	public void setArOperator(Integer arOperator) {
		this.arOperator = arOperator;
	}
	public String getArRemark() {
		return arRemark;
	}
	public void setArRemark(String arRemark) {
		this.arRemark = arRemark;
	}
	@Override
	public String toString() {
		return "AccountRecords [arId=" + arId + ", supId=" + supId + ", arDate=" + arDate + ", arOrderId=" + arOrderId
				+ ", arBusType=" + arBusType + ", arPayable=" + arPayable + ", arPaid=" + arPaid + ", arRears="
				+ arRears + ", arDiscount=" + arDiscount + ", arAttn=" + arAttn + ", arOperator=" + arOperator
				+ ", arRemark=" + arRemark + "]";
	}
	
	
	
}
