package com.pro.data.dict.query;

/**
 * [数据字典值]查询类, 表名[PRO_DATA_DICT_VALUE].
 */
public class DataDictValueQuery implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  protected java.lang.String dataDictValueId; // 数据字典值编号

  protected java.lang.String code; // 代码

  protected java.lang.String displayName; // 显示名称

  protected java.lang.String dataDictId; // 数据字典编号

  protected java.util.List<java.lang.String> dataDictValueIdAndin; // 数据字典值编号Andin查询

  protected java.lang.String codeAndeq; // 代码Andeq查询

  protected java.lang.String dataDictIdAndeq; // 数据字典编号Andeq查询

  protected java.lang.String codeAndKeyLike; // 代码AndKeyLike查询

  protected java.lang.String displayNameOrKeyLike; // 显示名称OrKeyLike查询

  protected java.lang.String dataDictIdOrKeyLike; // 数据字典编号OrKeyLike查询

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

  public java.util.List<java.lang.String> getDataDictValueIdAndin() {
    return dataDictValueIdAndin;
  }

  public void setDataDictValueIdAndin(java.util.List<java.lang.String> dataDictValueIdAndin) {
    this.dataDictValueIdAndin = dataDictValueIdAndin;
  }

  public java.lang.String getCodeAndeq() {
    return codeAndeq;
  }

  public void setCodeAndeq(java.lang.String codeAndeq) {
    this.codeAndeq = codeAndeq;
  }

  public java.lang.String getDataDictIdAndeq() {
    return dataDictIdAndeq;
  }

  public void setDataDictIdAndeq(java.lang.String dataDictIdAndeq) {
    this.dataDictIdAndeq = dataDictIdAndeq;
  }

  public java.lang.String getCodeAndKeyLike() {
    return codeAndKeyLike;
  }

  public void setCodeAndKeyLike(java.lang.String codeAndKeyLike) {
    this.codeAndKeyLike = codeAndKeyLike;
  }

  public java.lang.String getDisplayNameOrKeyLike() {
    return displayNameOrKeyLike;
  }

  public void setDisplayNameOrKeyLike(java.lang.String displayNameOrKeyLike) {
    this.displayNameOrKeyLike = displayNameOrKeyLike;
  }

  public java.lang.String getDataDictIdOrKeyLike() {
    return dataDictIdOrKeyLike;
  }

  public void setDataDictIdOrKeyLike(java.lang.String dataDictIdOrKeyLike) {
    this.dataDictIdOrKeyLike = dataDictIdOrKeyLike;
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
