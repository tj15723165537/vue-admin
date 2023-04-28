<template>
  <div class="common-layout">
    <el-container>
      <el-aside :style="{ width: store.isCollapse ? '64px' : '200px' }">
        <Sidebar></Sidebar>
      </el-aside>
      <el-container>
        <el-header>
          <Navbar></Navbar>
        </el-header>
        <el-main>
          <Content></Content>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup lang="ts">
import Navbar from './components/navbar.vue'
import Sidebar from './components/sidebar.vue'
import Content from './components/content.vue'
import { useMenuStore } from '@/store/modules/menu'

const store = useMenuStore()
</script>

<style scoped></style>
