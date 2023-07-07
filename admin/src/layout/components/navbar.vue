<template>
  <div>
    <div class="left">
      <el-icon
          style="font-size: 24px; color: rgba(0, 0, 0, 0.65); line-height: 60px; cursor: pointer"
          @click="menuStore.setIsCollapse()"
      >
        <Fold/>
      </el-icon>
    </div>
    <div class="userInfo">
      <img src="../../assets/img/pikaqiu.jpg"/>
      <div>
        <button class="logout" @click="handLogout">退出</button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {useCommonStore} from '@/store/modules/common'
import {useMenuStore} from '@/store/modules/menu'
import {useRouter} from 'vue-router'
import {ElMessageBox} from 'element-plus/es'

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

<style lang="scss" scoped>
.el-header {
  & > div {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .userInfo {
      float: right;
      display: flex;
      align-items: center;

      img {
        width: 30px;
        height: 30px;
        border-radius: 50%;
      }

      /* From www.lingdaima.com */
      button {
        margin-left: 20px;
        color: #090909;
        padding: 5px 10px;
        font-size: 12px;
        border-radius: 0.5em;
        background: #e8e8e8;
        border: 1px solid #e8e8e8;
      }

      button:hover {
        box-shadow: 2px 2px 6px #c5c5c5, -2px -2px 6px #ffffff;
      }
    }
  }
}
</style>