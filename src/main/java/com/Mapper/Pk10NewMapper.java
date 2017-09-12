package com.Mapper;

import com.Pojo.Pk10New;
import com.Pojo.Pk10NewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Pk10NewMapper {
    int countByExample(Pk10NewExample example);

    int deleteByExample(Pk10NewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Pk10New record);

    int insertSelective(Pk10New record);

    List<Pk10New> selectByExample(Pk10NewExample example);

    Pk10New selectByPrimaryKey(Long id);
    
    Pk10New selectByexpect(Long expect);
    
    int updateByExampleSelective(@Param("record") Pk10New record, @Param("example") Pk10NewExample example);

    int updateByExample(@Param("record") Pk10New record, @Param("example") Pk10NewExample example);

    int updateByPrimaryKeySelective(Pk10New record);

    int updateByPrimaryKey(Pk10New record);
}