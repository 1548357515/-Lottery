package com.Mapper;

import com.Pojo.PlanName;
import com.Pojo.PlanNameExample;
import com.Pojo.PlanNameKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanNameMapper {
    int countByExample(PlanNameExample example);

    int deleteByExample(PlanNameExample example);

    int deleteByPrimaryKey(PlanNameKey key);

    int insert(PlanName record);

    int insertSelective(PlanName record);

    List<PlanName> selectByExample(PlanNameExample example);

    PlanName selectByPrimaryKey(PlanNameKey key);

    int updateByExampleSelective(@Param("record") PlanName record, @Param("example") PlanNameExample example);

    int updateByExample(@Param("record") PlanName record, @Param("example") PlanNameExample example);

    int updateByPrimaryKeySelective(PlanName record);

    int updateByPrimaryKey(PlanName record);
}