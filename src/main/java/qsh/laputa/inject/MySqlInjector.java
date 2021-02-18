package qsh.laputa.inject;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import org.springframework.stereotype.Component;
import qsh.laputa.method.SelectAllMethod;

import java.util.List;

@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new SelectAllMethod());
        //由于排除了deleted字段，故其在数据库可被正确设置默认值，而不会设为null
        methodList.add(new InsertBatchSomeColumn(t -> (!t.isLogicDelete()) && !t.getColumn().equals("version")));
        methodList.add(new LogicDeleteByIdWithFill());
        methodList.add(new AlwaysUpdateSomeColumnById(t -> !t.getColumn().equals("name")));
        return methodList;
    }
}
