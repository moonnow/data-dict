package com.pro.data.dict.vo;

/**
 * [数据字典]VO类, 表名[PRO_DATA_DICT].
 */
public class DataDictVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String dataDictId; // 数据字典编号

  protected java.lang.String dataDictName; // 数据字典名称

  protected java.lang.String dataDictKey; // 数据字典标识

  protected java.lang.String description; // 描述

  public java.lang.String getDataDictId() {
    return dataDictId;
  }

  public void setDataDictId(java.lang.String dataDictId) {
    this.dataDictId = dataDictId;
  }

  public java.lang.String getDataDictName() {
    return dataDictName;
  }

  public void setDataDictName(java.lang.String dataDictName) {
    this.dataDictName = dataDictName;
  }

  public java.lang.String getDataDictKey() {
    return dataDictKey;
  }

  public void setDataDictKey(java.lang.String dataDictKey) {
    this.dataDictKey = dataDictKey;
  }

  public java.lang.String getDescription() {
    return description;
  }

  public void setDescription(java.lang.String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object object) {
    return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, object);
  }

  @Override
  public int hashCode() {
    return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
  }

}
