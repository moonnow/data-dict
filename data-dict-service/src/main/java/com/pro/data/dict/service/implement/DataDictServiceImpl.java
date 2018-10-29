package com.pro.data.dict.service.implement;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.service.IDataDictService;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

import com.pro.data.dict.entity.DataDict;
import com.pro.data.dict.persistent.IDataDictPersistent;
import com.pro.data.dict.query.DataDictQuery;
import com.pro.data.dict.vo.DataDictVO;

import com.pro.data.dict.entity.DataDictValue;
import com.pro.data.dict.persistent.IDataDictValuePersistent;
import com.pro.data.dict.query.DataDictValueQuery;
import com.pro.data.dict.vo.DataDictValueVO;

@org.springframework.stereotype.Service("com.pro.data.dict.DataDictService")
@org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED, readOnly = true, rollbackFor = java.lang.Exception.class)
public class DataDictServiceImpl implements IDataDictService {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DataDictServiceImpl.class);

  @javax.annotation.Resource(name = "com.pro.data.dict.DataDictPersistent")
  private IDataDictPersistent dataDictPersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.saveDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      dataDict.setDataDictId(ToolUtil.getUUID());
      DataDictQuery dataDictQuery = new DataDictQuery();
      dataDictQuery.setDataDictKeyAndeq(dataDict.getDataDictKey());
      if (!dataDictPersistent.isUnique(dataDictQuery)) {
        throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictPersistent.getNotUniqueErrorMessage(dataDictQuery) });
      }
      dataDictPersistent.saveDataDict(dataDict);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchSaveDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      for (DataDict dataDict : dataDicts) {
        if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
        }
        dataDict.setDataDictId(ToolUtil.getUUID());
        DataDictQuery dataDictQuery = new DataDictQuery();
        dataDictQuery.setDataDictKeyAndeq(dataDict.getDataDictKey());
        if (!dataDictPersistent.isUnique(dataDictQuery)) {
          throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictPersistent.getNotUniqueErrorMessage(dataDictQuery) });
        }
      }
      dataDictPersistent.batchSaveDataDict(dataDicts);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.updateDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      if (ToolUtil.isNullStr(dataDict.getDataDictId())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      DataDict oldDataDict = dataDictPersistent.getDataDictByPk(dataDict.getDataDictId());
      if (oldDataDict == null) {
        throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      DataDictQuery dataDictQuery = new DataDictQuery();
      dataDictQuery.setDataDictKeyAndeq(dataDict.getDataDictKey());
      if (!dataDictQuery.getDataDictKeyAndeq().equals(oldDataDict.getDataDictKey())) {
        if (!dataDictPersistent.isUnique(dataDictQuery)) {
          throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictPersistent.getNotUniqueErrorMessage(dataDictQuery) });
        }
      }
      dataDictPersistent.updateDataDict(dataDict);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchUpdateDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      for (DataDict dataDict : dataDicts) {
        if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
        }
        if (ToolUtil.isNullStr(dataDict.getDataDictId())) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
        }
        DataDict oldDataDict = dataDictPersistent.getDataDictByPk(dataDict.getDataDictId());
        if (oldDataDict == null) {
          throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        DataDictQuery dataDictQuery = new DataDictQuery();
        dataDictQuery.setDataDictKeyAndeq(dataDict.getDataDictKey());
        if (!dataDictQuery.getDataDictKeyAndeq().equals(oldDataDict.getDataDictKey())) {
          if (!dataDictPersistent.isUnique(dataDictQuery)) {
            throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictPersistent.getNotUniqueErrorMessage(dataDictQuery) });
          }
        }
      }
      dataDictPersistent.batchUpdateDataDict(dataDicts);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.removeDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      Set<DataDict> dataDictSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(dataDict.getDataDictId())) {
        DataDictQuery dataDictQuery = ToolUtil.attributeReplication(DataDictQuery.class, dataDict);
        dataDictSet.addAll(dataDictPersistent.queryDataDict(dataDictQuery));
      } else {
        DataDict oldDataDict = dataDictPersistent.getDataDictByPk(dataDict.getDataDictId());
        if (oldDataDict == null) {
          throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        dataDictSet.add(oldDataDict);
      }
      if (ToolUtil.isNotEmpty(dataDictSet)) {
        dataDictPersistent.batchRemoveDataDict(dataDictSet);
      }
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchRemoveDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      Set<DataDict> dataDictSet = new LinkedHashSet<>();
      for (DataDict dataDict : dataDicts) {
        if (ToolUtil.isNullStr(dataDict.getDataDictId())) {
          DataDictQuery dataDictQuery = ToolUtil.attributeReplication(DataDictQuery.class, dataDict);
          dataDictSet.addAll(dataDictPersistent.queryDataDict(dataDictQuery));
        } else {
          DataDict oldDataDict = dataDictPersistent.getDataDictByPk(dataDict.getDataDictId());
          if (oldDataDict == null) {
            throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          dataDictSet.add(oldDataDict);
        }
      }
      if (ToolUtil.isNotEmpty(dataDictSet)) {
        dataDictPersistent.batchRemoveDataDict(dataDictSet);
      }
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountDataDict(DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getCountDataDict ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      return dataDictPersistent.getCountDataDict(dataDictQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public DataDict getDataDictByPk(java.lang.String dataDictId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getDataDictByPk ");
      log.debug("parameter dataDictId is : " + dataDictId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      return dataDictPersistent.getDataDictByPk(dataDictId);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDict> getAllDataDict() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getAllDataDict ");
    }
    try {
      return dataDictPersistent.getAllDataDict();
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDict> pagingGetDataDict(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingGetDataDict ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictPersistent.pagingGetDataDict(parameter);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDict> queryDataDict(DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.queryDataDict ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      return dataDictPersistent.queryDataDict(dataDictQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDict> pagingQueryDataDict(Parameter parameter, DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingQueryDataDict ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictPersistent.pagingQueryDataDict(parameter, dataDictQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public DataDictVO getDataDictVOByPk(java.lang.String dataDictId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getDataDictVOByPk ");
      log.debug("parameter dataDictId is : " + dataDictId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      return dataDictPersistent.getDataDictVOByPk(dataDictId);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictVO> getAllDataDictVO() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getAllDataDictVO ");
    }
    try {
      return dataDictPersistent.getAllDataDictVO();
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictVO> pagingGetDataDictVO(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingGetDataDictVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictPersistent.pagingGetDataDictVO(parameter);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictVO> queryDataDictVO(DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.queryDataDictVO ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      return dataDictPersistent.queryDataDictVO(dataDictQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictVO> pagingQueryDataDictVO(Parameter parameter, DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingQueryDataDictVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictPersistent.pagingQueryDataDictVO(parameter, dataDictQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @javax.annotation.Resource(name = "com.pro.data.dict.DataDictValuePersistent")
  private IDataDictValuePersistent dataDictValuePersistent;

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void saveDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.saveDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      dataDictValue.setDataDictValueId(ToolUtil.getUUID());
      DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
      dataDictValueQuery.setCodeAndeq(dataDictValue.getCode());
      dataDictValueQuery.setDataDictIdAndeq(dataDictValue.getDataDictId());
      if (!dataDictValuePersistent.isUnique(dataDictValueQuery)) {
        throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictValuePersistent.getNotUniqueErrorMessage(dataDictValueQuery) });
      }
      dataDictValuePersistent.saveDataDictValue(dataDictValue);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchSaveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchSaveDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      for (DataDictValue dataDictValue : dataDictValues) {
        if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
        }
        dataDictValue.setDataDictValueId(ToolUtil.getUUID());
        DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
        dataDictValueQuery.setCodeAndeq(dataDictValue.getCode());
        dataDictValueQuery.setDataDictIdAndeq(dataDictValue.getDataDictId());
        if (!dataDictValuePersistent.isUnique(dataDictValueQuery)) {
          throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictValuePersistent.getNotUniqueErrorMessage(dataDictValueQuery) });
        }
      }
      dataDictValuePersistent.batchSaveDataDictValue(dataDictValues);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void updateDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.updateDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      if (ToolUtil.isNullStr(dataDictValue.getDataDictValueId())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      DataDictValue oldDataDictValue = dataDictValuePersistent.getDataDictValueByPk(dataDictValue.getDataDictValueId());
      if (oldDataDictValue == null) {
        throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
      }
      DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
      dataDictValueQuery.setCodeAndeq(dataDictValue.getCode());
      dataDictValueQuery.setDataDictIdAndeq(dataDictValue.getDataDictId());
      if (!(dataDictValueQuery.getCodeAndeq().equals(oldDataDictValue.getCode()) && dataDictValueQuery.getDataDictIdAndeq().equals(oldDataDictValue.getDataDictId()))) {
        if (!dataDictValuePersistent.isUnique(dataDictValueQuery)) {
          throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictValuePersistent.getNotUniqueErrorMessage(dataDictValueQuery) });
        }
      }
      dataDictValuePersistent.updateDataDictValue(dataDictValue);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchUpdateDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchUpdateDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      for (DataDictValue dataDictValue : dataDictValues) {
        if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
        }
        if (ToolUtil.isNullStr(dataDictValue.getDataDictValueId())) {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
        }
        DataDictValue oldDataDictValue = dataDictValuePersistent.getDataDictValueByPk(dataDictValue.getDataDictValueId());
        if (oldDataDictValue == null) {
          throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
        dataDictValueQuery.setCodeAndeq(dataDictValue.getCode());
        dataDictValueQuery.setDataDictIdAndeq(dataDictValue.getDataDictId());
        if (!(dataDictValueQuery.getCodeAndeq().equals(oldDataDictValue.getCode()) && dataDictValueQuery.getDataDictIdAndeq().equals(oldDataDictValue.getDataDictId()))) {
          if (!dataDictValuePersistent.isUnique(dataDictValueQuery)) {
            throw DataDictException.getException(DataDictException.FW_DATA_CONTENTION_ERROR, new String[] { dataDictValuePersistent.getNotUniqueErrorMessage(dataDictValueQuery) });
          }
        }
      }
      dataDictValuePersistent.batchUpdateDataDictValue(dataDictValues);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void removeDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.removeDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      Set<DataDictValue> dataDictValueSet = new LinkedHashSet<>();
      if (ToolUtil.isNullStr(dataDictValue.getDataDictValueId())) {
        DataDictValueQuery dataDictValueQuery = ToolUtil.attributeReplication(DataDictValueQuery.class, dataDictValue);
        dataDictValueSet.addAll(dataDictValuePersistent.queryDataDictValue(dataDictValueQuery));
      } else {
        DataDictValue oldDataDictValue = dataDictValuePersistent.getDataDictValueByPk(dataDictValue.getDataDictValueId());
        if (oldDataDictValue == null) {
          throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
        }
        dataDictValueSet.add(oldDataDictValue);
      }
      if (ToolUtil.isNotEmpty(dataDictValueSet)) {
        dataDictValuePersistent.batchRemoveDataDictValue(dataDictValueSet);
      }
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  @org.springframework.transaction.annotation.Transactional(propagation = org.springframework.transaction.annotation.Propagation.REQUIRED, readOnly = false)
  public void batchRemoveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.batchRemoveDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      Set<DataDictValue> dataDictValueSet = new LinkedHashSet<>();
      for (DataDictValue dataDictValue : dataDictValues) {
        if (ToolUtil.isNullStr(dataDictValue.getDataDictValueId())) {
          DataDictValueQuery dataDictValueQuery = ToolUtil.attributeReplication(DataDictValueQuery.class, dataDictValue);
          dataDictValueSet.addAll(dataDictValuePersistent.queryDataDictValue(dataDictValueQuery));
        } else {
          DataDictValue oldDataDictValue = dataDictValuePersistent.getDataDictValueByPk(dataDictValue.getDataDictValueId());
          if (oldDataDictValue == null) {
            throw DataDictException.getException(DataDictException.FW_UPDATE_DATA_NOT_FIND_ERROR);
          }
          dataDictValueSet.add(oldDataDictValue);
        }
      }
      if (ToolUtil.isNotEmpty(dataDictValueSet)) {
        dataDictValuePersistent.batchRemoveDataDictValue(dataDictValueSet);
      }
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Long getCountDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getCountDataDictValue ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      return dataDictValuePersistent.getCountDataDictValue(dataDictValueQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public DataDictValue getDataDictValueByPk(java.lang.String dataDictValueId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getDataDictValueByPk ");
      log.debug("parameter dataDictValueId is : " + dataDictValueId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictValueId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      return dataDictValuePersistent.getDataDictValueByPk(dataDictValueId);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictValue> getAllDataDictValue() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getAllDataDictValue ");
    }
    try {
      return dataDictValuePersistent.getAllDataDictValue();
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictValue> pagingGetDataDictValue(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingGetDataDictValue ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictValuePersistent.pagingGetDataDictValue(parameter);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictValue> queryDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.queryDataDictValue ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      return dataDictValuePersistent.queryDataDictValue(dataDictValueQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictValue> pagingQueryDataDictValue(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingQueryDataDictValue ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictValuePersistent.pagingQueryDataDictValue(parameter, dataDictValueQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public DataDictValueVO getDataDictValueVOByPk(java.lang.String dataDictValueId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getDataDictValueVOByPk ");
      log.debug("parameter dataDictValueId is : " + dataDictValueId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictValueId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      return dataDictValuePersistent.getDataDictValueVOByPk(dataDictValueId);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictValueVO> getAllDataDictValueVO() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.getAllDataDictValueVO ");
    }
    try {
      return dataDictValuePersistent.getAllDataDictValueVO();
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictValueVO> pagingGetDataDictValueVO(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingGetDataDictValueVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictValuePersistent.pagingGetDataDictValueVO(parameter);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Collection<DataDictValueVO> queryDataDictValueVO(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.queryDataDictValueVO ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      return dataDictValuePersistent.queryDataDictValueVO(dataDictValueQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public Paging<DataDictValueVO> pagingQueryDataDictValueVO(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictService.pagingQueryDataDictValueVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      if (parameter == null || ToolUtil.isNullEntityAllFieldValue(parameter)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      return dataDictValuePersistent.pagingQueryDataDictValueVO(parameter, dataDictValueQuery);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

}
