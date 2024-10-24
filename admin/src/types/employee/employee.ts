/**
 * 员工信息
 */
export interface Employee {
  /**
   * 地址
   */
  address?: string
  /**
   * 创建时间
   */
  createTime?: Date
  /**
   * 入职日期
   */
  date?: Date
  /**
   * 员工id
   */
  id?: string
  /**
   * 员工姓名
   */
  name?: string
  /**
   * 电话
   */
  phone?: string
  /**
   * 更新时间
   */
  updateTime?: Date
}

/**
 * 分页参数
 */
export interface EmployeeSearch extends PageParams {
  /**
   * 地址
   */
  address?: string
  /**
   * 员工姓名
   */
  name?: string
  /**
   * 电话
   */
  phone?: string
}

/**
 * 表单参数
 */
export interface EmployeeForm {
  /**
   * 地址
   */
  address?: string
  /**
   * 入职日期
   */
  date?: Date
  /**
   * 员工id
   */
  id?: string
  /**
   * 员工姓名
   */
  name?: string
  /**
   * 电话
   */
  phone?: string
}
