package com.Mapper;

import com.Pojo.AcountFund;
import com.Pojo.AcountFundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcountFundMapper {
    int countByExample(AcountFundExample example);

    int deleteByExample(AcountFundExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcountFund record);

    int insertSelective(AcountFund record);

    List<AcountFund> selectByExample(AcountFundExample example);

    AcountFund selectByPrimaryKey(Integer id);
    
    AcountFund selectByCountId(Integer accountId);

    int updateByExampleSelective(@Param("record") AcountFund record, @Param("example") AcountFundExample example);

    int updateByExample(@Param("record") AcountFund record, @Param("example") AcountFundExample example);

    int updateByPrimaryKeySelective(AcountFund record);

    int updateByPrimaryKey(AcountFund record);
}