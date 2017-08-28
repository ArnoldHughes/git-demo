package com.pwc.sdc.calc.vo;

import java.util.Date;

public class VarFormula {
	
	private int vfId;
	private String varName;
	private String formula;
	private String childVarName;
	private String varValue;
	private String varDescription;
	private String createdBy;
	private Date creationTime;
	private String updatedBy;
	private Date updatedTime;
	private String status;
	public VarFormula() {
		super();
	}
	public VarFormula(int vfId, String varName, String formula,
			String childVarName, String varValue, String varDescription,
			String createdBy, Date creationTime, String updatedBy,
			Date updatedTime, String status) {
		super();
		this.vfId = vfId;
		this.varName = varName;
		this.formula = formula;
		this.childVarName = childVarName;
		this.varValue = varValue;
		this.varDescription = varDescription;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.updatedBy = updatedBy;
		this.updatedTime = updatedTime;
		this.status = status;
	}
	public int getVfId() {
		return vfId;
	}
	public void setVfId(int vfId) {
		this.vfId = vfId;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getChildVarName() {
		return childVarName;
	}
	public void setChildVarName(String childVarName) {
		this.childVarName = childVarName;
	}
	public String getVarValue() {
		return varValue;
	}
	public void setVarValue(String varValue) {
		this.varValue = varValue;
	}
	public String getVarDescription() {
		return varDescription;
	}
	public void setVarDescription(String varDescription) {
		this.varDescription = varDescription;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
