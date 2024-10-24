import { defineStore } from "pinia"

export const useCommonStore = defineStore("common", {
  state: (): { token: string | undefined } => {
    return {
      token: undefined,
    }
  },
  actions: {
    setToken(val: string) {
      this.token = val
    },
    removeToken() {
      this.token = undefined
    },
  },
  persist: true, //开启该库的持久化
})
