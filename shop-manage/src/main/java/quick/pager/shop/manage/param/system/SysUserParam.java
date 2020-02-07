package quick.pager.shop.manage.param.system;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import quick.pager.shop.param.Param;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserParam extends Param {
    private static final long serialVersionUID = 2802879969759895845L;

    private String phone;
    private String username;

    private String password;

    private List<Long> roleIds;

    private String avatar;

    private String loginCode;

}
