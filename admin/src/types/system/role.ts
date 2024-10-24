/**
 * 角色信息
 */
export interface RoleVO {
  /**
   * 创建人
   */
  createBy?: string
  /**
   * 创建时间
   */
  createTime?: Date
  /**
   * id
   */
  id?: number
  /**
   * 角色名称
   */
  name?: string
  /**
   * 备注
   */
  remark?: string
}

export interface RoleSearch extends PageParams {
  /**
   * 角色名
   */
  name?: string
}

export interface RoleAssignForm {
  /**
   * 角色id
   */
  id: string
  /**
   * 菜单集合
   */
  menuList: string[]
}

export interface RoleMenuList {
  /**
   * 角色已有权限菜单列表
   */
  roleMenuList: string[]
  /**
   * 所有菜单列表
   */
  menuList: any[]
}
