import dataDictValueService from '@/api/com/pro/data/dict/dataDictValue/dataDictValueService'

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveDataDictValue ({ commit, state }, dataDictValue) {
      return new Promise((resolve, reject) => {
        dataDictValueService.save(dataDictValue).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveDataDictValue ({ commit, state }, dataDictValueOrList) {
      return new Promise((resolve, reject) => {
        dataDictValueService.batchSave(dataDictValueOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateDataDictValue ({ commit, state }, dataDictValue) {
      return new Promise((resolve, reject) => {
        dataDictValueService.update(dataDictValue).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateDataDictValue ({ commit, state }, dataDictValueOrList) {
      return new Promise((resolve, reject) => {
        dataDictValueService.batchUpdate(dataDictValueOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeDataDictValue ({ commit, state }, dataDictValue) {
      return new Promise((resolve, reject) => {
        dataDictValueService.remove(dataDictValue).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveDataDictValue ({ commit, state }, dataDictValueOrList) {
      return new Promise((resolve, reject) => {
        dataDictValueService.batchRemove(dataDictValueOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getDataDictValueByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        dataDictValueService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllDataDictValue ({ commit, state }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetDataDictValue ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryDataDictValue ({ commit, state }, dataDictValueQuery) {
      return new Promise((resolve, reject) => {
        dataDictValueService.query(dataDictValueQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryDataDictValue ({ commit, state }, { dataDictValueQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.pagingQuery(dataDictValueQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getDataDictValueVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        dataDictValueService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllDataDictValueVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetDataDictValueVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryDataDictValueVO ({ commit, state }, dataDictValueQuery) {
      return new Promise((resolve, reject) => {
        dataDictValueService.queryVO(dataDictValueQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryDataDictValueVO ({ commit, state }, { dataDictValueQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        dataDictValueService.pagingQueryVO(dataDictValueQuery, rows, page).then(res => {
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
