<template>
  <div class="sidebar">
    <div class="title">{{ store.isCollapse ? 'EMP' : 'EMPOLYEE' }}</div>
    <el-menu
        class="el-menu-vertical-demo"
        :unique-opened="true"
        :router="true"
        :collapse="store.isCollapse"
        :collapse-transition="false"
        :default-active="route.path"
    >
      <el-menu-item index="/home">
        <el-icon>
          <HomeFilled/>
        </el-icon>
        <template #title>首页</template>
      </el-menu-item>
      <template v-for="item in dataList" :key="item.path">
        <el-sub-menu :index="item.path" v-if="item.children.length">
          <template #title>
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <span>{{ item.title }}</span>
          </template>
          <el-menu-item-group>
            <el-menu-item :index="i.path" v-for="i in item.children" :key="i.path">
              <template #title>
                <el-icon>
                  <component :is="i.icon"></component>
                </el-icon>
                <span>{{ i.title }}</span>
              </template>
            </el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>

        <el-menu-item :index="item.path" v-else>
          <el-icon>
            <component :is="item.icon"></component>
          </el-icon>
          <template #title>{{ item.title }}</template>
        </el-menu-item>
      </template>
    </el-menu>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import { useMenuStore } from '@/store/modules/menu'
import { Menu } from '@/types/system/menu'

const store = useMenuStore()
const route = useRoute()
let dataList = ref<Menu[]>()
dataList.value = store.menuList
</script>
<style lang="scss" scoped>
.sidebar {
  height: 100%;

  .title {
    font-size: 20px;
    text-align: center;
    padding: 20px 0 30px 0;
    color: #fff;
    font-weight: 700;
  }

  .el-menu {
    height: calc(100% - 96px);
  }
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>