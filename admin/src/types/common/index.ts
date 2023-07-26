import { User } from "../system/user";
/**
 * 登录表单
 */
export interface LoginForm {
  /**
   * 账号
   */
  account?: string;
  /**
   * 密码
   */
  password?: string;
}

/**
 * 登录信息
 */
export interface LoginResult {
  /**
   * token
   */
  token?: string;
  /**
   * 用户信息
   */
  userInfo?: User;
}


export interface ResetPasswordForm {
  oldPassword?: string
  newPassword?: string
  confirmNewPassword?: string
}