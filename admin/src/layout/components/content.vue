<template>
  <div class="top">
    <el-breadcrumb :separator-icon="ArrowRight">
      <el-breadcrumb-item v-for="(item, index) in breadcrumbList" :key="index">
        {{ item.name }}
      </el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <div class="content">
    <router-view />
  </div>
</template>

<script lang="ts" setup>
import { ArrowRight } from "@element-plus/icons-vue"
import { useRoute, RouteLocationNormalizedLoaded, RouteLocationMatched } from "vue-router"
import { watch, ref, onMounted } from "vue"

const route = useRoute()
type breadcrumbList = {
  name: string
  path: string
}[]

const breadcrumbList = ref<breadcrumbList>([])
watch(route, (val) => {
  getbreadcrumbList(val)
})
onMounted(() => {
  getbreadcrumbList(route)
})

//获取面包屑路由信息
function getbreadcrumbList(val: RouteLocationNormalizedLoaded) {
  const list: breadcrumbList = val.matched.map((item: RouteLocationMatched) => {
    return {
      name: item.meta.title as string,
      path: item.path,
    }
  })
  breadcrumbList.value = list
}
</script>
<style lang="scss" scoped>
.top {
  margin-bottom: 15px;
  margin-left: 5px;
}

.content {
  padding: 15px 10px;
  background: white;
  border-radius: 3px;
  box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
  flex: 1;
}
</style>
