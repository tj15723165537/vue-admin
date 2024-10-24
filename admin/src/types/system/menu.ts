/**
 * 菜单信息
 */
export interface Menu {
  /**
   * 子菜单
   */
  children?: Menu[]
  /**
   * 菜单图标
   */
  icon?: string
  /**
   * 菜单id
   */
  id?: string
  /**
   * 菜单名称
   */
  name?: string
  /**
   * 菜单路径
   */
  path?: string
  /**
   * 父菜单id
   */
  pid?: string
  /**
   * 跳转路径
   */
  redirect?: string
  /**
   * 菜单标题
   */
  title?: string
}

/**
 * 菜单表单
 */
export interface MenuForm {
  /**
   * 菜单图标
   */
  icon?: string
  /**
   * 菜单id
   */
  id?: string
  /**
   * 路由名称
   */
  name?: string
  /**
   * 菜单路径
   */
  path?: string
  /**
   * 父级菜单
   */
  pid?: string
  /**
   * 重定向路径
   */
  redirect?: string
  /**
   * 菜单标题
   */
  title?: string
}
