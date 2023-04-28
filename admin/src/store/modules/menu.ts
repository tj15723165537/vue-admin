import { defineStore } from 'pinia'
export const useMenuStore = defineStore('menu', {
  state: () => {
    return {
      menuList: [],
      hasSetMenuList: false,
      isCollapse: false
    }
  },
  // 也可以定义为
  // state: () => ({ count: 0 })
  actions: {
    setMenuList(val: any) {
      this.menuList = val
    },
    setIsCollapse() {
      this.isCollapse = !this.isCollapse
    }
  }
})
