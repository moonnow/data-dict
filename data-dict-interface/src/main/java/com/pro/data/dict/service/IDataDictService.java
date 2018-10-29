package com.pro.data.dict.service;

import java.util.Collection;

import com.pro.data.dict.exception.DataDictException;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;

import com.pro.data.dict.entity.DataDict;
import com.pro.data.dict.query.DataDictQuery;
import com.pro.data.dict.vo.DataDictVO;

import com.pro.data.dict.entity.DataDictValue;
import com.pro.data.dict.query.DataDictValueQuery;
import com.pro.data.dict.vo.DataDictValueVO;

public interface IDataDictService {

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

  public DataDictVO getDataDictVOByPk(java.lang.String dataDictId) throws DataDictException;

  public Collection<DataDictVO> getAllDataDictVO() throws DataDictException;

  public Paging<DataDictVO> pagingGetDataDictVO(Parameter parameter) throws DataDictException;

  public Collection<DataDictVO> queryDataDictVO(DataDictQuery dataDictQuery) throws DataDictException;

  public Paging<DataDictVO> pagingQueryDataDictVO(Parameter parameter, DataDictQuery dataDictQuery) throws DataDictException;

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

  public DataDictValueVO getDataDictValueVOByPk(java.lang.String dataDictValueId) throws DataDictException;

  public Collection<DataDictValueVO> getAllDataDictValueVO() throws DataDictException;

  public Paging<DataDictValueVO> pagingGetDataDictValueVO(Parameter parameter) throws DataDictException;

  public Collection<DataDictValueVO> queryDataDictValueVO(DataDictValueQuery dataDictValueQuery) throws DataDictException;

  public Paging<DataDictValueVO> pagingQueryDataDictValueVO(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException;

}
