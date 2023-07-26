<template>
  <div>
    <div class='left'>
      <el-icon
        style='font-size: 24px; color: rgba(0, 0, 0, 0.65); line-height: 60px; cursor: pointer'
        @click='menuStore.setIsCollapse()'
      >
        <Fold />
      </el-icon>
    </div>
    <div class='userInfo'>
      <el-dropdown>
    <span class='el-dropdown-link'>
    <img src='../../assets/img/pikaqiu.jpg' />
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>
              <Reset-password />
            </el-dropdown-item>
            <el-dropdown-item>修改头像</el-dropdown-item>
            <el-dropdown-item @click='handLogout'>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang='ts' setup>
import { useCommonStore } from '@/store/modules/common'
import { useMenuStore } from '@/store/modules/menu'
import { useRouter } from 'vue-router'
import { ElMessageBox } from 'element-plus/es'
import ResetPassword from '@/layout/components/resetPassword.vue'

const router = useRouter()
const commonStore: any = useCommonStore()
const menuStore = useMenuStore()
const handLogout = () => {
  ElMessageBox.confirm('确定要退出登录吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  })
    .then((res) => {
      commonStore.removeToken()
      menuStore.setAsyncRoutestMark(false)
      router.push('/login')
    })
    .catch((err) => {
    })
}
</script>

<style lang='scss' scoped>
.el-header {
  & > div {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .userInfo {
      float: right;
      margin-right: 10px;
      display: flex;
      align-items: center;

      img {
        width: 30px;
        height: 30px;
        border-radius: 50%;
      }

    }
  }
}
</style>