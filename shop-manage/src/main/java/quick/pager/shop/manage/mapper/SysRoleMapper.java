package quick.pager.shop.manage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import quick.pager.shop.manage.model.SysRole;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 根据roleId 与 sysUserId 查看系统用户角色
     *
     * @param roleId    t_role id
     * @param sysUserId t_sys_role id
     * @return 系统角色内容
     */
    SysRole selectSysRole(@Param("roleId") Long roleId, @Param("sysUserId") Long sysUserId);

    /**
     * 根据用户id查询角色
     *
     * @param sysUserId 系统登陆用户主键
     * @return 系统角色列表
     */
    List<SysRole> selectBySysUserId(@Param("sysUserId") Long sysUserId);

}
