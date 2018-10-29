import dataDictService from '@/api/com/pro/data/dict/dataDict/dataDictService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveDataDict ({ commit, state }, dataDict) {
      return new Promise((resolve, reject) => {
        dataDictService.save(dataDict).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveDataDict ({ commit, state }, dataDictOrList) {
      return new Promise((resolve, reject) => {
        dataDictService.batchSave(dataDictOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateDataDict ({ commit, state }, dataDict) {
      return new Promise((resolve, reject) => {
        dataDictService.update(dataDict).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateDataDict ({ commit, state }, dataDictOrList) {
      return new Promise((resolve, reject) => {
        dataDictService.batchUpdate(dataDictOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeDataDict ({ commit, state }, dataDict) {
      return new Promise((resolve, reject) => {
        dataDictService.remove(dataDict).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveDataDict ({ commit, state }, dataDictOrList) {
      return new Promise((resolve, reject) => {
        dataDictService.batchRemove(dataDictOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getDataDictByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        dataDictService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllDataDict ({ commit, state }) {
      return new Promise((resolve, reject) => {
        dataDictService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetDataDict ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryDataDict ({ commit, state }, dataDictQuery) {
      return new Promise((resolve, reject) => {
        dataDictService.query(dataDictQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryDataDict ({ commit, state }, { dataDictQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictService.pagingQuery(dataDictQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getDataDictVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        dataDictService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllDataDictVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        dataDictService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetDataDictVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryDataDictVO ({ commit, state }, dataDictQuery) {
      return new Promise((resolve, reject) => {
        dataDictService.queryVO(dataDictQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryDataDictVO ({ commit, state }, { dataDictQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictService.pagingQueryVO(dataDictQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    }
  },
  getters: {
  }
}
