package com.pro.data.dict.persistent.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.pro.data.dict.entity.DataDictValue;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.persistent.IDataDictValuePersistent;
import com.pro.data.dict.query.DataDictValueQuery;
import com.pro.data.dict.vo.DataDictValueVO;
import com.pro.tool.persistent.implement.ToolPersistent;
import com.pro.tool.util.Paging;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Repository("com.pro.data.dict.DataDictValuePersistent")
public class DataDictValuePersistentImpl extends ToolPersistent implements IDataDictValuePersistent {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DataDictValuePersistentImpl.class);

  public static final String TABLE_ALIAS = "dataDictValue";

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
  public void saveDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.saveDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      this.insert(INSERT_SQL, dataDictValue);
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
  public void batchSaveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.batchSaveDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      this.insert(INSERT_SQL, dataDictValues);
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
  public void updateDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.updateDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      this.update(UPDATE_SQL, dataDictValue);
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
  public void batchUpdateDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.batchUpdateDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      this.update(UPDATE_SQL, dataDictValues);
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
  public void removeDataDictValue(DataDictValue dataDictValue) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.removeDataDictValue ");
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDictValue.getDataDictValueId());
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
  public void batchRemoveDataDictValue(Collection<DataDictValue> dataDictValues) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.batchRemoveDataDictValue ");
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      this.del(DEL_SQL_BY_PK, dataDictValues);
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
  public Long getCountDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.getCountDataDictValue ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
      }
      return this.queryCount(countSql, dataDictValueQuery, Long.class);
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
  public DataDictValue getDataDictValueByPk(java.lang.String dataDictValueId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.getDataDictValueByPk ");
      log.debug("parameter dataDictValueId is : " + dataDictValueId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictValueId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDictValueId);
        }
      }
      Collection<DataDictValue> dataDictValueSet = this.query(querySql, mapSqlParameterSource, DataDictValue.class);
      return ToolUtil.isNotEmpty(dataDictValueSet) ? dataDictValueSet.iterator().next() : null;
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
  public Collection<DataDictValue> getAllDataDictValue() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.getAllDataDictValue ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictValue.class);
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
  public Paging<DataDictValue> pagingGetDataDictValue(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.pagingGetDataDictValue ");
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
      Paging<DataDictValue> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDictValue> dataDictValueSet = this.query(querySql, DataDictValue.class);
        if (ToolUtil.isNotEmpty(dataDictValueSet)) {
          Set<String> inDataDictValueId = new LinkedHashSet<>();
          for (DataDictValue dataDictValue : dataDictValueSet) {
            inDataDictValueId.add(dataDictValue.getDataDictValueId());
          }
          DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
          dataDictValueQuery.setDataDictValueIdAndin(new ArrayList<>(inDataDictValueId));
          Collection<DataDictValue> rDataDictValueSet = this.queryDataDictValue(dataDictValueQuery);
          if (ToolUtil.isNotEmpty(rDataDictValueSet)) {
            paging.setData(rDataDictValueSet);
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
  public Collection<DataDictValue> queryDataDictValue(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.queryDataDictValue ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictValue.class, dataDictValueQuery);
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
  public Paging<DataDictValue> pagingQueryDataDictValue(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.pagingQueryDataDictValue ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
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
      Paging<DataDictValue> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDictValue> dataDictValueSet = this.query(querySql, DataDictValue.class, dataDictValueQuery);
        if (ToolUtil.isNotEmpty(dataDictValueSet)) {
          Set<String> inDataDictValueId = new LinkedHashSet<>();
          for (DataDictValue dataDictValue : dataDictValueSet) {
            inDataDictValueId.add(dataDictValue.getDataDictValueId());
          }
          DataDictValueQuery rDataDictValueQuery = new DataDictValueQuery();
          rDataDictValueQuery.setDataDictValueIdAndin(new ArrayList<>(inDataDictValueId));
          Collection<DataDictValue> rDataDictValueSet = this.queryDataDictValue(rDataDictValueQuery);
          if (ToolUtil.isNotEmpty(rDataDictValueSet)) {
            paging.setData(rDataDictValueSet);
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
  public boolean isUnique(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.isUnique ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        countSql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
      }
      Long count = this.queryCount(countSql, dataDictValueQuery, Long.class);
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
  public String getNotUniqueErrorMessage(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    return this.getNotUniqueErrorMsg(COLUMNS, COLUMNS_PARAMETER, dataDictValueQuery).toString();
  }

  @Override
  public DataDictValueVO getDataDictValueVOByPk(java.lang.String dataDictValueId) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.getDataDictValueVOByPk ");
      log.debug("parameter dataDictValueId is : " + dataDictValueId);
    }
    try {
      if (ToolUtil.isNullStr(dataDictValueId)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getByPkSql(COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      if (ToolUtil.isNotEmpty(PRIMARY_KEY) && PRIMARY_KEY.size() == 1) {
        for (String pk : PRIMARY_KEY) {
          mapSqlParameterSource.addValue(pk, dataDictValueId);
        }
      }
      Collection<DataDictValueVO> dataDictValueVOSet = this.query(querySql, mapSqlParameterSource, DataDictValueVO.class);
      return ToolUtil.isNotEmpty(dataDictValueVOSet) ? dataDictValueVOSet.iterator().next() : null;
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
  public Collection<DataDictValueVO> getAllDataDictValueVO() throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.getAllDataDictValueVO ");
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictValueVO.class);
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
  public Paging<DataDictValueVO> pagingGetDataDictValueVO(Parameter parameter) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.pagingGetDataDictValueVO ");
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
      Paging<DataDictValueVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDictValue> dataDictValueSet = this.query(querySql, DataDictValue.class);
        if (ToolUtil.isNotEmpty(dataDictValueSet)) {
          Set<String> inDataDictValueId = new LinkedHashSet<>();
          for (DataDictValue dataDictValue : dataDictValueSet) {
            inDataDictValueId.add(dataDictValue.getDataDictValueId());
          }
          DataDictValueQuery dataDictValueQuery = new DataDictValueQuery();
          dataDictValueQuery.setDataDictValueIdAndin(new ArrayList<>(inDataDictValueId));
          Collection<DataDictValueVO> rDataDictValueVOSet = this.queryDataDictValueVO(dataDictValueQuery);
          if (ToolUtil.isNotEmpty(rDataDictValueVOSet)) {
            paging.setData(rDataDictValueVOSet);
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
  public Collection<DataDictValueVO> queryDataDictValueVO(DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.queryDataDictValueVO ");
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    try {
      StringBuilder querySql = new StringBuilder(SELECT_VO_SQL);
      if (!ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
      }
      querySql.append(this.getSortSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS));
      return this.query(querySql, DataDictValueVO.class, dataDictValueQuery);
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
  public Paging<DataDictValueVO> pagingQueryDataDictValueVO(Parameter parameter, DataDictValueQuery dataDictValueQuery) throws DataDictException {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValuePersistent.pagingQueryDataDictValueVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
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
      Paging<DataDictValueVO> paging = new Paging<>(parameter);
      StringBuilder countSql = new StringBuilder(COUNT_SQL);
      Long count = this.queryCount(countSql, Long.class);
      paging.setCount(count);
      if (count > 0) {
        StringBuilder querySql = new StringBuilder(this.getPagingSql(TABLE_NAME, COLUMNS_PARAMETER, PRIMARY_KEY, TABLE_ALIAS));
        querySql.append(this.getQuerySql(COLUMNS, COLUMNS_PARAMETER, TABLE_ALIAS, dataDictValueQuery));
        querySql.append(this.getPagingSql(SORT, COLUMNS_PARAMETER, TABLE_ALIAS, paging));
        Collection<DataDictValue> dataDictValueSet = this.query(querySql, DataDictValue.class, dataDictValueQuery);
        if (ToolUtil.isNotEmpty(dataDictValueSet)) {
          Set<String> inDataDictValueId = new LinkedHashSet<>();
          for (DataDictValue dataDictValue : dataDictValueSet) {
            inDataDictValueId.add(dataDictValue.getDataDictValueId());
          }
          DataDictValueQuery rDataDictValueQuery = new DataDictValueQuery();
          rDataDictValueQuery.setDataDictValueIdAndin(new ArrayList<>(inDataDictValueId));
          Collection<DataDictValueVO> rDataDictValueVOSet = this.queryDataDictValueVO(rDataDictValueQuery);
          if (ToolUtil.isNotEmpty(rDataDictValueVOSet)) {
            paging.setData(rDataDictValueVOSet);
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
