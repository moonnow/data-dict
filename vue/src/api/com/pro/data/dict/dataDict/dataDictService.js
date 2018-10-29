import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/data/dict/dataDict'

const vourl = '/pro/data/dict/dataDict/vo'

export default {
  save: (dataDict) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), dataDict, toolService.getConfig())
  },
  batchSave: (dataDictOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (dataDictOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), dataDictOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(dataDictOrList), toolService.getConfig())
    }
  },
  update: (dataDict) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), dataDict, toolService.getConfig())
  },
  batchUpdate: (dataDictOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (dataDictOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), dataDictOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(dataDictOrList), toolService.getConfig())
    }
  },
  remove: (dataDict) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(dataDict))
  },
  batchRemove: (dataDictOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (dataDictOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(dataDictOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(dataDictOrList)))
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
  query: (dataDictQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), dataDictQuery, toolService.getConfig())
  },
  pagingQuery: (dataDictQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), dataDictQuery, toolService.getConfig())
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
  queryVO: (dataDictQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), dataDictQuery, toolService.getConfig())
  },
  pagingQueryVO: (dataDictQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), dataDictQuery, toolService.getConfig())
  }
}
