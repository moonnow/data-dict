package com.pro.data.dict.persistent;

import java.util.Collection;

import com.pro.data.dict.entity.DataDictValue;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.query.DataDictValueQuery;
import com.pro.data.dict.vo.DataDictValueVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IDataDictValuePersistent {

  public static final String TABLE_NAME = "PRO_DATA_DICT_VALUE";

  public void saveDataDictValue(DataDictValue dataDictValue) throws DataDictException;

  public void batchSaveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException;

  public void updateDataDictValue(DataDictValue dataDictValue) throws DataDictException;

  public void batchUpdateDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException;

  public void removeDataDictValue(DataDictValue dataDictValue) throws DataDictException;

  public void batchRemoveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException;

  public Long getCountDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public DataDictValue getDataDictValueByPk(java.lang.String dataDictValueId) throws DataDictException;

  public Collection<DataDictValue> getAllDataDictValue() throws DataDictException;

  public Paging<DataDictValue> pagingGetDataDictValue(Parameter parameter) throws DataDictException;

  public Collection<DataDictValue> queryDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public Paging<DataDictValue> pagingQueryDataDictValue(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public boolean isUnique(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public String getNotUniqueErrorMessage(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public DataDictValueVO getDataDictValueVOByPk(java.lang.String dataDictValueId) throws DataDictException;

  public Collection<DataDictValueVO> getAllDataDictValueVO() throws DataDictException;

  public Paging<DataDictValueVO> pagingGetDataDictValueVO(Parameter parameter) throws DataDictException;

  public Collection<DataDictValueVO> queryDataDictValueVO(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public Paging<DataDictValueVO> pagingQueryDataDictValueVO(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException;

}
