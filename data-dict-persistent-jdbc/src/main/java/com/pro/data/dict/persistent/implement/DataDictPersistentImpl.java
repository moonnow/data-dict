package com.pro.data.dict.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.data.dict.entity.DataDict;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.persistent.IDataDictPersistent;
import com.pro.data.dict.query.DataDictQuery;
import com.pro.data.dict.vo.DataDictVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.data.dict.DataDictPersistent")
public class DataDictPersistentImpl extends ToolPersistent implements IDataDictPersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DataDictPersistentImpl.class);

  public static final String TABLE_ALIAS = "dataDict";

  public static final LinkedHashSet<String> PRIMARY_KEY = new LinkedHashSet<>();
  public static final LinkedHashSet<String> COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> COLUMNS_PARAMETER = new LinkedHashMap<>();
  public static final LinkedHashSet<String> VIRTUAL_COLUMNS = new LinkedHashSet<>();
  public static final LinkedHashMap<String, String> SORT = new LinkedHashMap<>();

  private static StringBuilder INSERT_SQL = new StringBuilder();
  private static StringBuilder UPDATE_SQL = new StringBuilder();
  private static StringBuilder DEL_SQL_BY_PK = new StringBuilder();
  public static StringBuilder SELECT_SQL = new StringBuilder();
  public static StringBuilder SELECT_VO_SQL = new StringBuilder();
  public static StringBuilder COUNT_SQL = new StringBuilder();
  public static StringBuilder COLUMN_LIST_ALIAS = new StringBuilder();
  public static StringBuilder COLUMN_LIST_NOT_ALIAS = new StringBuilder();

  @PostConstruct
  private void init() {
    super.init(TABLE_NAME, PRIMARY_KEY, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, SORT);
    INSERT_SQL = getInsertSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER);
    UPDATE_SQL = getUpdateSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY);
    DEL_SQL_BY_PK = getDelSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY);
    SELECT_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
    SELECT_VO_SQL = getSelectSql(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, VIRTUAL_COLUMNS, PRIMARY_KEY, TABLE_ALIAS);
    COUNT_SQL = getCountSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS);
    COLUMN_LIST_ALIAS = getColumnList(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS);
    COLUMN_LIST_NOT_ALIAS = getColumnList(TABLE_NAME, COLUMNS, COLUMNS_PARAMETER);
  }

  @Override
  public void saveDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.saveDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      this.insert(INSERT_SQL, dataDict);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchSaveDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.batchSaveDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      this.insert(INSERT_SQL, dataDicts);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void updateDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.updateDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      this.update(UPDATE_SQL, dataDict);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchUpdateDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.batchUpdateDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      this.update(UPDATE_SQL, dataDicts);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void removeDataDict(DataDict dataDict) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.removeDataDict ");
      log.debug("parameter dataDict is : " + dataDict);
    }
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDict.getDataDictId());
        }
      }
      this.del(DEL_SQL_BY_PK, mapSqlParameterSource);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public void batchRemoveDataDict(Collection<DataDict> dataDicts) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.batchRemoveDataDict ");
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      this.del(DEL_SQL_BY_PK, dataDicts);
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.getCountDataDict ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
      }
      return this.queryCount(countSql, dataDictQuery, Long.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.getDataDictByPk ");
      log.debug("parameter dataDictId is : " + dataDictId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDictId);
        }
      }
      Collection<DataDict> dataDictSet = this.query(querySql, mapSqlParameterSource, DataDict.class);
      return ToolUtil.isNotEmpty(dataDictSet) ? dataDictSet.iterator().next() : null;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.getAllDataDict ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDict.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.pagingGetDataDict ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<DataDict> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDict> dataDictSet = this.query(querySql, DataDict.class);
        if (ToolUtil.isNotEmpty(dataDictSet)) {
          Set<String> inDataDictId = new LinkedHashSet<>();
          for (DataDict dataDict : dataDictSet) {
            inDataDictId.add(dataDict.getDataDictId());
          }
          DataDictQuery dataDictQuery = new DataDictQuery();
          dataDictQuery.setDataDictIdAndin(new ArrayList<>(inDataDictId));
          Collection<DataDict> rDataDictSet = this.queryDataDict(dataDictQuery);
          if (ToolUtil.isNotEmpty(rDataDictSet)) {
            paging.setData(rDataDictSet);
          }
        }
      }
      return paging;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.queryDataDict ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDict.class, dataDictQuery);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.pagingQueryDataDict ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      if (parameter == null) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<DataDict> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDict> dataDictSet = this.query(querySql, DataDict.class, dataDictQuery);
        if (ToolUtil.isNotEmpty(dataDictSet)) {
          Set<String> inDataDictId = new LinkedHashSet<>();
          for (DataDict dataDict : dataDictSet) {
            inDataDictId.add(dataDict.getDataDictId());
          }
          DataDictQuery rDataDictQuery = new DataDictQuery();
          rDataDictQuery.setDataDictIdAndin(new ArrayList<>(inDataDictId));
          Collection<DataDict> rDataDictSet = this.queryDataDict(rDataDictQuery);
          if (ToolUtil.isNotEmpty(rDataDictSet)) {
            paging.setData(rDataDictSet);
          }
        }
      }
      return paging;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public boolean isUnique(DataDictQuery dataDictQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.isUnique ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
      }
      Long count = this.queryCount(countSql, dataDictQuery, Long.class);
      return count < 1;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

  @Override
  public String getNotUniqueErrorMessage(DataDictQuery dataDictQuery) throws DataDictException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, dataDictQuery).toString();
  }

  @Override
  public DataDictVO getDataDictVOByPk(java.lang.String dataDictId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictPersistent.getDataDictVOByPk ");
      log.debug("parameter dataDictId is : " + dataDictId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDictId);
        }
      }
      Collection<DataDictVO> dataDictVOSet = this.query(querySql, mapSqlParameterSource, DataDictVO.class);
      return ToolUtil.isNotEmpty(dataDictVOSet) ? dataDictVOSet.iterator().next() : null;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.getAllDataDictVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictVO.class);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.pagingGetDataDictVO ");
      log.debug("parameter parameter is : " + parameter);
    }
    try {
      if (parameter == null) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<DataDictVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDict> dataDictSet = this.query(querySql, DataDict.class);
        if (ToolUtil.isNotEmpty(dataDictSet)) {
          Set<String> inDataDictId = new LinkedHashSet<>();
          for (DataDict dataDict : dataDictSet) {
            inDataDictId.add(dataDict.getDataDictId());
          }
          DataDictQuery dataDictQuery = new DataDictQuery();
          dataDictQuery.setDataDictIdAndin(new ArrayList<>(inDataDictId));
          Collection<DataDictVO> rDataDictVOSet = this.queryDataDictVO(dataDictQuery);
          if (ToolUtil.isNotEmpty(rDataDictVOSet)) {
            paging.setData(rDataDictVOSet);
          }
        }
      }
      return paging;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.queryDataDictVO ");
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictVO.class, dataDictQuery);
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
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
      log.debug("Staring call DataDictPersistent.pagingQueryDataDictVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    try {
      if (parameter == null) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " parameter ");
      }
      if (parameter.getRows() < 0) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " rows ", " 大于等于0" });
      }
      if (parameter.getPage() < 1) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_CONT_LONG_ERROR, new String[] { " page ", " 大于等于1" });
      }
      Paging<DataDictVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDict> dataDictSet = this.query(querySql, DataDict.class, dataDictQuery);
        if (ToolUtil.isNotEmpty(dataDictSet)) {
          Set<String> inDataDictId = new LinkedHashSet<>();
          for (DataDict dataDict : dataDictSet) {
            inDataDictId.add(dataDict.getDataDictId());
          }
          DataDictQuery rDataDictQuery = new DataDictQuery();
          rDataDictQuery.setDataDictIdAndin(new ArrayList<>(inDataDictId));
          Collection<DataDictVO> rDataDictVOSet = this.queryDataDictVO(rDataDictQuery);
          if (ToolUtil.isNotEmpty(rDataDictVOSet)) {
            paging.setData(rDataDictVOSet);
          }
        }
      }
      return paging;
    } catch (DataDictException e) {
      if (log.isErrorEnabled()) {
        log.error(e);
      }
      throw e;
    } catch (org.springframework.dao.DataAccessException e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_DAO_ACCESS_ERROR, e.getMessage());
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      throw DataDictException.getException(e, DataDictException.FW_ERROR, e.getMessage());
    }
  }

}
