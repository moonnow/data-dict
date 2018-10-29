package com.pro.data.dict.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.data.dict.entity.DataDictValue;

public interface IDataDictValueJpaPersistent extends CrudRepository<DataDictValue, Long> {

}
