package qsh.laputa.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import qsh.laputa.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    @Select("select * from pro_user ${ew.customSqlSegment}")
    List<User> customSelect(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
