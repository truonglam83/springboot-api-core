package com.api.coreapi.sys.test;

import com.api.coreapi.sys.test.dto.TestDbDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDbDto> testDb();
}
