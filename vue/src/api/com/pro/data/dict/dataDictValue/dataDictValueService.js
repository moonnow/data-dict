import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/data/dict/dataDictValue'

const vourl = '/pro/data/dict/dataDictValue/vo'

export default {
  save: (dataDictValue) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), dataDictValue, toolService.getConfig())
  },
  batchSave: (dataDictValueOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (dataDictValueOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), dataDictValueOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(dataDictValueOrList), toolService.getConfig())
    }
  },
  update: (dataDictValue) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), dataDictValue, toolService.getConfig())
  },
  batchUpdate: (dataDictValueOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (dataDictValueOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), dataDictValueOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(dataDictValueOrList), toolService.getConfig())
    }
  },
  remove: (dataDictValue) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(dataDictValue))
  },
  batchRemove: (dataDictValueOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (dataDictValueOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(dataDictValueOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(dataDictValueOrList)))
    }
  },
  getByPk: (primaryKey) => {
    let parameter = new Parameter()
    parameter.action = toolService.getByPk
    parameter.primaryKey = primaryKey
    return axios.get(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  getAll: () => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  paging: (rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), toolService.getConfig())
  },
  query: (dataDictValueQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), dataDictValueQuery, toolService.getConfig())
  },
  pagingQuery: (dataDictValueQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), dataDictValueQuery, toolService.getConfig())
  },
  getVOByPk: (primaryKey) => {
    let parameter = new Parameter()
    parameter.action = toolService.getVOByPk
    parameter.primaryKey = primaryKey
    return axios.get(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  getAllVO: () => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), toolService.getConfig())
  },
  pagingVO: (rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), toolService.getConfig())
  },
  queryVO: (dataDictValueQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), dataDictValueQuery, toolService.getConfig())
  },
  pagingQueryVO: (dataDictValueQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), dataDictValueQuery, toolService.getConfig())
  }
}
