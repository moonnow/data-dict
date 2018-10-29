package com.pro.data.dict.persistent;

import java.util.Collection;

import com.pro.data.dict.entity.DataDict;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.query.DataDictQuery;
import com.pro.data.dict.vo.DataDictVO;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

public interface IDataDictPersistent {

  public static final String TABLE_NAME = "PRO_DATA_DICT";

  public void saveDataDict(DataDict dataDict) throws DataDictException;

  public void batchSaveDataDict(Collection<DataDict> dataDicts) throws DataDictException;

  public void updateDataDict(DataDict dataDict) throws DataDictException;

  public void batchUpdateDataDict(Collection<DataDict> dataDicts) throws DataDictException;

  public void removeDataDict(DataDict dataDict) throws DataDictException;

  public void batchRemoveDataDict(Collection<DataDict> dataDicts) throws DataDictException;

  public Long getCountDataDict(DataDictQuery dataDictQuery) throws DataDictException;

  public DataDict getDataDictByPk(java.lang.String dataDictId) throws DataDictException;

  public Collection<DataDict> getAllDataDict() throws DataDictException;

  public Paging<DataDict> pagingGetDataDict(Parameter parameter) throws DataDictException;

  public Collection<DataDict> queryDataDict(DataDictQuery dataDictQuery) throws DataDictException;

  public Paging<DataDict> pagingQueryDataDict(Parameter parameter, DataDictQuery dataDictQuery) throws DataDictException;

  public boolean isUnique(DataDictQuery dataDictQuery) throws DataDictException;

  public String getNotUniqueErrorMessage(DataDictQuery dataDictQuery) throws DataDictException;

  public DataDictVO getDataDictVOByPk(java.lang.String dataDictId) throws DataDictException;

  public Collection<DataDictVO> getAllDataDictVO() throws DataDictException;

  public Paging<DataDictVO> pagingGetDataDictVO(Parameter parameter) throws DataDictException;

  public Collection<DataDictVO> queryDataDictVO(DataDictQuery dataDictQuery) throws DataDictException;

  public Paging<DataDictVO> pagingQueryDataDictVO(Parameter parameter, DataDictQuery dataDictQuery) throws DataDictException;

}
