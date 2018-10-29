package com.pro.data.dict.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.data.dict.entity.DataDict;
import com.pro.data.dict.exception.DataDictException;
import com.pro.data.dict.query.DataDictQuery;
import com.pro.data.dict.service.IDataDictService;
import com.pro.data.dict.vo.DataDictVO;
import com.pro.tool.rest.ToolController;
import com.pro.tool.util.Parameter;
import com.pro.tool.util.Responses;
import com.pro.tool.util.ToolUtil;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("prototype")
@RequestMapping(value = { "pro/data/dict/dataDict" })
public class DataDictController extends ToolController {

  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DataDictController.class);

  @javax.annotation.Resource(name = "com.pro.data.dict.DataDictService")
  private IDataDictService dataDictService;

  @RequestMapping(method = { RequestMethod.POST }, params = { ToolUtil.ACTION + ToolUtil.ACTION_SAVE })
  @ResponseBody
  public Responses<DataDict> save(Parameter parameter, @RequestBody DataDict dataDict) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.save ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDict is : " + dataDict);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      dataDictService.saveDataDict(dataDict);
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
  public Responses<DataDict> batchSave(Parameter parameter, @RequestBody List<DataDict> dataDicts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.batchSave ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      dataDictService.batchSaveDataDict(dataDicts);
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
  public Responses<DataDict> update(Parameter parameter, @RequestBody DataDict dataDict) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.update ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDict is : " + dataDict);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      dataDictService.updateDataDict(dataDict);
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
  public Responses<DataDict> batchUpdate(Parameter parameter, @RequestBody List<DataDict> dataDicts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.batchUpdate ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      dataDictService.batchUpdateDataDict(dataDicts);
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
  public Responses<DataDict> remove(Parameter parameter, @RequestBody DataDict dataDict) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.remove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDict is : " + dataDict);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (dataDict == null || ToolUtil.isNullEntityAllFieldValue(dataDict)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDict ");
      }
      dataDictService.removeDataDict(dataDict);
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
  public Responses<DataDict> batchRemove(Parameter parameter, @RequestBody List<DataDict> dataDicts) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.batchRemove ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDicts is : " + dataDicts);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (ToolUtil.isEmpty(dataDicts)) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDicts ");
      }
      dataDictService.batchRemoveDataDict(dataDicts);
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
  public Responses<DataDict> getByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.getByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<DataDict> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      responses.setData(dataDictService.getDataDictByPk(parameter.getPrimaryKey()));
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
  public Responses<DataDict> get(Parameter parameter, @RequestBody DataDictQuery dataDictQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.get ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    Responses<DataDict> responses = new Responses<>(parameter);
    try {
      if (dataDictQuery == null || ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(dataDictService.getAllDataDict());
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingGetDataDict(parameter));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL.equals(parameter.getAction())) {
          responses.setData(dataDictService.queryDataDict(dataDictQuery));
        } else if (ToolUtil.ACTION_PAGING.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingQueryDataDict(parameter, dataDictQuery));
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
  public Responses<DataDictVO> getVOByPk(Parameter parameter) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.getVOByPk ");
      log.debug("parameter parameter is : " + parameter);
    }
    Responses<DataDictVO> responses = new Responses<>();
    try {
      if (ToolUtil.isNullStr(parameter.getPrimaryKey())) {
        throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_NULL_ERROR, " dataDictId ");
      }
      responses.setData(dataDictService.getDataDictVOByPk(parameter.getPrimaryKey()));
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
  public Responses<DataDictVO> getVO(Parameter parameter, @RequestBody DataDictQuery dataDictQuery) {
    if (log.isDebugEnabled()) {
      log.debug("Staring call DataDictController.getVO ");
      log.debug("parameter parameter is : " + parameter);
      log.debug("parameter dataDictQuery is : " + dataDictQuery);
    }
    Responses<DataDictVO> responses = new Responses<>(parameter);
    try {
      if (dataDictQuery == null || ToolUtil.isNullEntityAllFieldValue(dataDictQuery)) {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.getAllDataDictVO());
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingGetDataDictVO(parameter));
        } else {
          throw DataDictException.getException(DataDictException.FW_PARAMETER_IS_ERROR, " action ");
        }
      } else {
        if (ToolUtil.ACTION_GET_ALL_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.queryDataDictVO(dataDictQuery));
        } else if (ToolUtil.ACTION_PAGING_VO.equals(parameter.getAction())) {
          responses.setData(dataDictService.pagingQueryDataDictVO(parameter, dataDictQuery));
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
