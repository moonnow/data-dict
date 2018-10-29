package com.pro.data.dict.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.data.dict.entity.DataDictValue;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.query.DataDictValueQuery;
import com.pro.data.dict.service.IDataDictService;
import com.pro.data.dict.vo.DataDictValueVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/data/dict/dataDictValue" })
public class DataDictValueController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DataDictValueController.class);

  @javax.annotation.Resource(name = "com.pro.data.dict.DataDictService")
  private IDataDictService dataDictService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<DataDictValue> save(Parameter parameter, @RequestBody DataDictValue dataDictValue) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      dataDictService.saveDataDictValue(dataDictValue);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_SAVE })
  @ResponseBody
  public Responses<DataDictValue> batchSave(Parameter parameter, @RequestBody List<DataDictValue> dataDictValues) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      dataDictService.batchSaveDataDictValue(dataDictValues);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.PUT }, params = { ToolUtil.ACTION + ToolUtil.ACTION_UPDATE })
  @ResponseBody
  public Responses<DataDictValue> update(Parameter parameter, @RequestBody DataDictValue dataDictValue) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      dataDictService.updateDataDictValue(dataDictValue);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.PUT }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_UPDATE })
  @ResponseBody
  public Responses<DataDictValue> batchUpdate(Parameter parameter, @RequestBody List<DataDictValue> dataDictValues) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      dataDictService.batchUpdateDataDictValue(dataDictValues);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.DELETE }, params = { ToolUtil.ACTION + ToolUtil.ACTION_REMOVE })
  @ResponseBody
  public Responses<DataDictValue> remove(Parameter parameter, @RequestBody DataDictValue dataDictValue) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValue is : " + dataDictValue);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (dataDictValue == null || ToolUtil.isNullEntityAllFieldValue(dataDictValue)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValue ");
      }
      dataDictService.removeDataDictValue(dataDictValue);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.DELETE }, params = { ToolUtil.ACTION + ToolUtil.ACTION_BATCH_REMOVE })
  @ResponseBody
  public Responses<DataDictValue> batchRemove(Parameter parameter, @RequestBody List<DataDictValue> dataDictValues) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValues is : " + dataDictValues);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDictValues)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValues ");
      }
      dataDictService.batchRemoveDataDictValue(dataDictValues);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.GET }, params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_BY_PK })
  @ResponseBody
  public Responses<DataDictValue> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<DataDictValue> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      responses.setData(dataDictService.getDataDictValueByPk(parameter.getPrimaryKey()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.POST })
  @ResponseBody
  public Responses<DataDictValue> get(Parameter parameter, @RequestBody DataDictValueQuery dataDictValueQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    Responses<DataDictValue> responses = new Responses<>(parameter);
    try {
      if (dataDictValueQuery == null || ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(dataDictService.getAllDataDictValue());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingGetDataDictValue(parameter));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(dataDictService.queryDataDictValue(dataDictValueQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingQueryDataDictValue(parameter, dataDictValueQuery));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(method = { RequestMethod.GET }, params = { ToolUtil.ACTION + ToolUtil.ACTION_GET_VO_BY_PK })
  @ResponseBody
  public Responses<DataDictValueVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<DataDictValueVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictValueId ");
      }
      responses.setData(dataDictService.getDataDictValueVOByPk(parameter.getPrimaryKey()));
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

  @RequestMapping(value = { "vo" }, method = { RequestMethod.POST })
  @ResponseBody
  public Responses<DataDictValueVO> getVO(Parameter parameter, @RequestBody DataDictValueQuery dataDictValueQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictValueController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictValueQuery is : " + dataDictValueQuery);
    }
    Responses<DataDictValueVO> responses = new Responses<>(parameter);
    try {
      if (dataDictValueQuery == null || ToolUtil.isNullEntityAllFieldValue(dataDictValueQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.getAllDataDictValueVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingGetDataDictValueVO(parameter));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.queryDataDictValueVO(dataDictValueQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingQueryDataDictValueVO(parameter, dataDictValueQuery));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      }
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error(e.getMessage(), e);
      }
      responses.setException(e);
    }
    return responses;
  }

}
