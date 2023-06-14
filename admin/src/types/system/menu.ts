export interface Menu {
    id: string
    path: string
    name: string
    redirect: string
    title: string
    icon: string
    pid: string
    children: Array< Menu >
}
