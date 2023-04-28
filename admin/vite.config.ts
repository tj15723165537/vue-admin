import {defineConfig, loadEnv} from 'vite'
import vue from '@vitejs/plugin-vue'

const path = require('path')


export default defineConfig(({mode}) => {
    const {VITE_BASE_API_NODE, VITE_BASE_API_JAVA} = loadEnv(mode, process.cwd());
    return {
        plugins: [vue()],
        define: {
            'process.env': {}
        },
        resolve: {
            // 配置路径别名
            alias: {
                '@': path.resolve(__dirname, './src')
            }
        },
        server: {
            open:true,
            port: 4396,
            proxy: {
                '/api': {
                    target: VITE_BASE_API_JAVA,
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/api/, '')
                },
                '/foo': {
                    target: VITE_BASE_API_NODE,
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/foo/, '')
                }
            }
        }
    }
})
