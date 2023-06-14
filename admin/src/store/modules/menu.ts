import {defineStore} from 'pinia'
import {getMenuList} from "@/api/system";

export const useMenuStore = defineStore('menu', {
    state: () => {
        return {
            menuList: [],
            asyncRoutestMark: false,
            hasSetMenuList: false,
            isCollapse: false
        }
    },
    actions: {
        async setMenuList() {
          const result = await getMenuList()
          // @ts-ignore
          this.menuList = result.data
        },
        setAsyncRoutestMark(val: boolean) {
            this.asyncRoutestMark = val
        },
        setIsCollapse() {
            this.isCollapse = !this.isCollapse
        }
    }
})
