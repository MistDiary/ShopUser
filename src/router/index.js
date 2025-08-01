import { createRouter, createWebHashHistory } from 'vue-router'
import Register from '../views/Register.vue'
import Login from '../views/Login.vue'
import IndexRoot from '../views/IndexRoot.vue'
import Index from '../views/Index.vue'
import ProInfo from '../views/ProInfo.vue'
import ModifyPassword from '../views/ModifyPassword.vue'
import SortManagement from '../views/SortManagement.vue'
import ShoppingCart from '../views/ShoppingCart.vue'
import Setting from '../views/Setting.vue'
import ProList from '../views/ProList.vue'
import BusInfo from '../views/BusInfo.vue'
import ManageAddress from '../views/ManageAddress.vue'
import ViewOrder from '../views/ViewOrder.vue'
import AddressEdit from '../views/AddressEdit.vue'
import All from '../views/All.vue'
import Unshipped from '../views/Unshipped.vue'
import Unpaid from '../views/Unpaid.vue'
import Shipped from '../views/Shipped.vue'
import Over from '../views/Over.vue'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Login
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/modifyPassword',
    name: 'ModifyPassword',
    component: ModifyPassword
  },
  {
    path: '/proInfo',
    name: 'ProInfo',
    component: ProInfo
  },
  {
    path: '/proList',
    name: 'ProList',
    component: ProList
  },
  {
    path: '/busInfo',
    name: 'BusInfo',
    component: BusInfo
  },
  {
    path: '/manageAddress',
    name: 'ManageAddress',
    component: ManageAddress
  },

  {
    path: '/viewOrder',
    name: 'ViewOrder',
    component: ViewOrder
  },
  {
    path: '/addressEdit',
    name: 'AddressEdit',
    component: AddressEdit
  },
  {
    path: '/all',
    name: 'All',
    component: All
  },
  {
    path: '/shipped',
    name: 'Shipped',
    component: Shipped
  },
  {
    path: '/unshipped',
    name: 'Unshipped',
    component: Unshipped
  },
  {
    path: '/unpaid',
    name:'Unpaid',
    component: Unpaid
  },
  {
    path: '/over',
    name: 'Over',
    component: Over
  },
  {
    path: '/indexRoot',
    name: 'IndexRoot',
    component: IndexRoot,
    children: [
      {
        path: '/',
        name: 'Index',
        component: Index
      },
      {
        path: '/index',
        name: 'Index',
        component: Index
      },
      
      {
        path: '/sortManagement',
        name: 'SortManagement',
        component: SortManagement
      },
      {
        path: '/category/:category',
        name: 'Category',
        component: SortManagement
      },
    
      
  
      {
        path: '/shoppingCart',
        name: 'ShoppingCart',
        component: ShoppingCart
      },
      {
        path: '/setting',
        name: 'Setting',
        component: Setting
      }
    
    ]
  }



]


const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
