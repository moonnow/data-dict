package com.pro.data.dict.entity;

/**
 * [数据字典值]实体类, 表名[PRO_DATA_DICT_VALUE].
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PRO_DATA_DICT_VALUE")
@org.hibernate.annotations.GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class DataDictValue implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @javax.persistence.GeneratedValue(generator = "jpa-uuid")
  protected java.lang.String dataDictValueId; // 数据字典值编号

  protected java.lang.String code; // 代码

  protected java.lang.String displayName; // 显示名称

  protected java.lang.String dataDictId; // 数据字典编号

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
