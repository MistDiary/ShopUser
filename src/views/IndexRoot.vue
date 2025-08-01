<template>
  <el-container class="container"
    style="display: flex; flex-direction: column; width: 100%; height: 100%"
  >
    <el-header style="background-color: #ecedeb; flex: 0 0 30px">
      <div class="header-box">
        <el-icon style="font-size: 30px;color: #18f51c"> <Shop /> </el-icon>
        <p>睿购商城APP</p>
      </div>
    </el-header>

    <el-container style="flex: 1">
      <el-main>
        
        <router-view />
      </el-main>
    </el-container>

    <el-footer
      style="
        background-color: #ecedeb;
        flex: 0 0 auto;
        display: flex;
        flex-direction: row;
        justify-content: space-around;
      "
    >
      <div class="footer-box">
        <el-segmented v-model="selected" :options="options">
          <template #default="{ item }">
            <div class="flex flex-col items-center gap-2 p-2 segmented-item" @click="navigateTo(item.path)">
              <el-icon size="20">
                <component :is="item.icon" />
              </el-icon>
              <div>{{ item.label }}</div>
            </div>
          </template>
        </el-segmented>
      </div>
    </el-footer>
  </el-container>
</template>

<script setup>
import { ref } from 'vue'
import { 
    Shop,
    House ,
  Menu ,
ShoppingCart ,
Setting
 } from "@element-plus/icons-vue";
import { useRouter } from 'vue-router';
 const selected  = ref('Index')
 const router =useRouter();
 const options = [
  {
    label: '首页',
    value: 'Index',
    icon: House,
    path: '/index'
  },
  {
    label: '分类',
    value: 'Menu',
    icon: Menu,
    path: '/sortManagement'
  },
  {
    label: '购物车 ',
    value: 'ShoppingCart ',
    icon: ShoppingCart ,
    path: '/shoppingCart'
  },
  {
    label: '个人中心',
    value: 'Setting',
    icon: Setting,
    path: '/setting'
  }
]

const navigateTo = (path) =>{
    router.push(path)
}

</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 600px; /* 设置一个最大宽度 */
  margin-left: auto;
  margin-right: auto;
  height:auto; /* 使用视口高度 */
  overflow: hidden; /* 防止内容溢出 */
   overflow-y: auto; /* 允许垂直滚动 */
}


.header-box {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  color: #fff;
}

.header-box p {
  color: #0e66f4;
}



.footer-box {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
  height: 100%;

  
}

.footer-box .el-segmented {
  width: 100%;
  display: flex;
  justify-content: space-around;
   background-color: #ecedeb;
}

.footer-box .el-segmented-item {
  flex: 1;
  text-align: center;
 
}

</style>
