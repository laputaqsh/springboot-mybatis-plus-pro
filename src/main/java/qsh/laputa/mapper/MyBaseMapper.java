package qsh.laputa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 删除所有
     *
     * @return 影响行数
     */
    int deleteAll();
}
