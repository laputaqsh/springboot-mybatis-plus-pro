package qsh.laputa.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import qsh.laputa.entity.User;

import java.util.List;

@InterceptorIgnore(tenantLine = "true")     //拦截忽略，method级>mapper级
public interface UserMapper extends BaseMapper<User> {

    @InterceptorIgnore(tenantLine = "false")     //method级拦截忽略
    @Select("select * from pro_user ${ew.customSqlSegment}")
    List<User> mySelect(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
