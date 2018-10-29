package com.pro.data.dict.vo;

/**
 * [数据字典值]VO类, 表名[PRO_DATA_DICT_VALUE].
 */
public class DataDictValueVO implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String dataDictValueId; // 数据字典值编号

  protected java.lang.String code; // 代码

  protected java.lang.String displayName; // 显示名称

  protected java.lang.String dataDictId; // 数据字典编号

  protected java.lang.String dataDictName; // 数据字典名称

  public java.lang.String getDataDictValueId() {
    return dataDictValueId;
  }

  public void setDataDictValueId(java.lang.String dataDictValueId) {
    this.dataDictValueId = dataDictValueId;
  }

  public java.lang.String getCode() {
    return code;
  }

  public void setCode(java.lang.String code) {
    this.code = code;
  }

  public java.lang.String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(java.lang.String displayName) {
    this.displayName = displayName;
  }

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
