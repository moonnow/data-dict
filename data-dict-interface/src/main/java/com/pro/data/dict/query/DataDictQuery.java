package com.pro.data.dict.query;

/**
 * [数据字典]查询类, 表名[PRO_DATA_DICT].
 */
public class DataDictQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String dataDictId; // 数据字典编号

  protected java.lang.String dataDictName; // 数据字典名称

  protected java.lang.String dataDictKey; // 数据字典标识

  protected java.util.List<java.lang.String> dataDictIdAndin; // 数据字典编号Andin查询

  protected java.lang.String dataDictKeyAndeq; // 数据字典标识Andeq查询

  protected java.lang.String dataDictNameAndKeyLike; // 数据字典名称AndKeyLike查询

  protected java.lang.String dataDictKeyOrKeyLike; // 数据字典标识OrKeyLike查询

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

  public java.util.List<java.lang.String> getDataDictIdAndin() {
    return dataDictIdAndin;
  }

  public void setDataDictIdAndin(java.util.List<java.lang.String> dataDictIdAndin) {
    this.dataDictIdAndin = dataDictIdAndin;
  }

  public java.lang.String getDataDictKeyAndeq() {
    return dataDictKeyAndeq;
  }

  public void setDataDictKeyAndeq(java.lang.String dataDictKeyAndeq) {
    this.dataDictKeyAndeq = dataDictKeyAndeq;
  }

  public java.lang.String getDataDictNameAndKeyLike() {
    return dataDictNameAndKeyLike;
  }

  public void setDataDictNameAndKeyLike(java.lang.String dataDictNameAndKeyLike) {
    this.dataDictNameAndKeyLike = dataDictNameAndKeyLike;
  }

  public java.lang.String getDataDictKeyOrKeyLike() {
    return dataDictKeyOrKeyLike;
  }

  public void setDataDictKeyOrKeyLike(java.lang.String dataDictKeyOrKeyLike) {
    this.dataDictKeyOrKeyLike = dataDictKeyOrKeyLike;
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
