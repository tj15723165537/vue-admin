import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import {useCommonStore} from '@/store/modules/common'
import {useMenuStore} from '@/store/modules/menu'

const contactRoutes: RouteRecordRaw[] = [
    {
        path: '/login',
        component: () => import('@/view/login/index.vue')
    },
    {
        path: '/home',
        redirect: '/home',
        component: () => import('@/layout/index.vue'),
        children: [
            {
                path: '',
                meta: {
                    title: '首页',
                    icon: 'home'
                },
                component: () => import('@/view/home/index.vue')
            }
        ]
    },
    {
        path: '/',
        redirect: '/login'
    }
]
export const router = createRouter({
    history: createWebHistory(),
    routes: contactRoutes
})

router.beforeEach(async (to, form, next) => {
    const store = useCommonStore()
    const menuStore = useMenuStore()
    const whiteList = ['/login']
    if (store.token) {
        if(!menuStore.asyncRoutestMark){
            await menuStore.setMenuList()
            menuStore.menuList.map((item: any) => {
                if(item.path === '/home') return
                console.log(item)
                const component = {
                    path: item.path,
                    redirect: item.redirect,
                    component: () => import('@/layout/index.vue'),
                    meta: {
                        title: item.title,
                        icon: item.icon
                    },
                    children:[]
                }
                if(item.children?.length > 0) {
                        item.children.map((child: any) => {
                            const childComponent = {
                                path: child.path,
                                component: () => import(`../view${child.path}/index.vue`),
                                meta: {
                                    title: child.title,
                                    icon: child.icon
                                }
                            }
                            // @ts-ignore
                            component.children.push(childComponent)
                        })
                }
                router.addRoute(component)
            })
            menuStore.setAsyncRoutestMark(true)
            next({...to, replace: true})
        }else{
            next()
        }
    } else {
        if (whiteList.indexOf(to.path) !== -1) {
            // 在免登录白名单，直接进入
            next()
        } else {
            next(`/login?redirect=${to.fullPath}`) // 否则全部重定向到登录页
        }
    }
})
