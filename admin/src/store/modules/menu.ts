import { defineStore } from "pinia"
import { getMenuList } from "@/api/system/menu"
import { Menu } from "@/types/system/menu"
import { getAuthList } from "@/api/common"

interface State {
  menuList: Menu[]
  asyncRoutestMark: boolean
  hasSetMenuList: boolean
  isCollapse: boolean
}

export const useMenuStore = defineStore("menu", {
  state: (): State => {
    return {
      menuList: [],
      asyncRoutestMark: false,
      hasSetMenuList: false,
      isCollapse: false,
    }
  },
  actions: {
    async setMenuList() {
      const result = await getAuthList()
      this.menuList = result.data
    },
    setAsyncRoutestMark(val: boolean) {
      this.asyncRoutestMark = val
    },
    setIsCollapse() {
      this.isCollapse = !this.isCollapse
    },
  },
})
