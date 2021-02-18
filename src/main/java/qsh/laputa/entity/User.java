package qsh.laputa.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    private String name;

    @TableField(fill = FieldFill.UPDATE)
    private Integer age;

    private String email;

    private Long managerId;//上级ID

    @TableField(fill = FieldFill.INSERT)    //创建时填充数据
    private LocalDateTime createTime;//创建时间

    @TableField(fill = FieldFill.UPDATE)    //更新时填充数据
    private LocalDateTime updateTime;//更新时间

    @Version    //版本：newVersion = oldVersion + 1
    private Integer version;//版本

    @TableLogic     //逻辑删除标识
    @TableField(select = false)// 不进行 select 查询
    private Integer deleted;//逻辑删除标记(0，未删除；1，已删除)
}
