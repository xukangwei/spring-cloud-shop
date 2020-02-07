package quick.pager.shop.manage.controller.system;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.Constants;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.manage.param.system.AuthorizationParam;
import quick.pager.shop.manage.response.system.MenuResponse;
import quick.pager.shop.manage.service.system.PermissionService;
import quick.pager.shop.response.Response;

/**
 * 权限
 */
@RestController
@RequestMapping(Constants.Module.MANAGE)
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 菜单授权
     *
     * @param param 请求参数
     */
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE_GRANT')")
    @PostMapping("/grant")
    public Response grant(@RequestBody AuthorizationParam param) {

        if (Objects.isNull(param.getRoleId())) {
            return new Response(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
        }

        return permissionService.grant(param.getPermissions(), param.getRoleId());
    }

    /**
     * 根据权限菜单主键查询非路由级菜单
     *
     * @param permissionId 菜单主键
     */
    @GetMapping("/permission/{permissionId}")
    @PreAuthorize("hasAuthority('PAGER_SYSTEM_ROLE_PERMISSION')")
    public Response<List<MenuResponse>> permission(@PathVariable("permissionId") Long permissionId) {
        return permissionService.permission(permissionId);
    }
}
