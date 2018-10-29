package com.pro.data.dict.entity;

/**
 * [数据字典]实体类, 表名[PRO_DATA_DICT].
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "PRO_DATA_DICT")
@org.hibernate.annotations.GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class DataDict implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @javax.persistence.Id
  @javax.persistence.GeneratedValue(generator = "jpa-uuid")
  protected java.lang.String dataDictId; // 数据字典编号

  protected java.lang.String dataDictName; // 数据字典名称

  protected java.lang.String dataDictKey; // 数据字典标识

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
