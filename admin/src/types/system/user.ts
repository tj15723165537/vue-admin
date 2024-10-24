/**
 * 用户信息
 */
export interface User {
  /**
   * 账号
   */
  account?: string
  /**
   * 创建时间
   */
  createTime?: Date
  /**
   * 用户id
   */
  id?: number
  /**
   * 密码
   */
  password?: string
  /**
   * 状态
   */
  status?: 0 | 1 | boolean
  /**
   * 更新时间
   */
  updateTime?: Date
}

/**
 * 用户分页查询参数
 */
export interface UserSearch extends PageParams {
  /**
   * 账号
   */
  account?: string
  /**
   * 状态
   */
  status?: 0 | 1
}
