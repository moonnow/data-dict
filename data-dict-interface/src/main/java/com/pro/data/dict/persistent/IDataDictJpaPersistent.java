package com.pro.data.dict.persistent;

import org.springframework.data.repository.CrudRepository;

import com.pro.data.dict.entity.DataDict;

public interface IDataDictJpaPersistent extends CrudRepository<DataDict, Long> {

}
