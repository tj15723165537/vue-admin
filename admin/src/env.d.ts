/// <reference types="vite/client" />
import * as axios from 'axios'

declare module '*.vue' {
    import type {DefineComponent} from 'vue'
    // eslint-disable-next-line @typescript-eslint/no-explicit-any, @typescript-eslint/ban-types
    const component: DefineComponent<{}, {}, any>
    export default component
    export default '.vue'
}

declare module 'axios' {
    interface AxiosInstance {
        // eslint-disable-next-line no-undef
        (config: AxiosRequestConfig): Promise<any>
    }
}
