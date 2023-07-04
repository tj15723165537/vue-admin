/**
 * 角色信息
 */
export interface RoleVO {
  /**
   * 创建人
   */
  createBy?: string;
  /**
   * 创建时间
   */
  createTime?: Date;
  /**
   * id
   */
  id?: number;
  /**
   * 角色名称
   */
  name?: string;
  /**
   * 备注
   */
  remark?: string;
}