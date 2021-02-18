package qsh.laputa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import qsh.laputa.entity.User;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 删除所有
     *
     * @return 影响行数
     */
    List<User> selectAll();

    int insertBatchSomeColumn(List<T> entityList);

    int deleteByIdWithFill(T entity);

    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);
}
