package com.Mapper;

import com.Pojo.PlanPk10;
import com.Pojo.PlanPk10Example;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanPk10Mapper {
    int countByExample(PlanPk10Example example);

    int deleteByExample(PlanPk10Example example);

    int deleteByPrimaryKey(Long id);

    int insert(PlanPk10 record);

    int insertSelective(PlanPk10 record);

    List<PlanPk10> selectByExample(PlanPk10Example example);

    List<PlanPk10> selectByDate(@Param("id")Long id ,@Param("startTime") Date startTime , @Param("endTime")Date endTime);
    
    PlanPk10 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlanPk10 record, @Param("example") PlanPk10Example example);

    int updateByExample(@Param("record") PlanPk10 record, @Param("example") PlanPk10Example example);

    int updateByPrimaryKeySelective(PlanPk10 record);

    int updateByPrimaryKey(PlanPk10 record);
}