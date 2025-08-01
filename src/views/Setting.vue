<template>
  <div class="wrapper">
    <div v-for="u in user"
    :key="u.user_id">
    <header>设置</header>
    <div class="setting">
      <p style=" text-align: right;" @click="detil">&nbsp;个人信息</p>
   

    <div class="photo">
      <img src="../assets/ef1d6b8e4b0323a885e49a37834e1b9e.jpg" />
    </div>
    <div class="users">
      用户名：{{ u.user_name }}<br/>
      账号id：{{ u.user_id }}
    </div>
    <div class="one"><p @click="viewOrder">&nbsp;查看订单</p></div>
    <div class="one"><p @click="manageAddress">&nbsp;我的收货地址</p></div>
    <div style="width: 100%;height: 5vw;  background-color: #f4f4f5;"></div>
    <div class="two" style="text-align: center;" @click="login"><p>退出登录</p></div>
    </div>
  </div>
   </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

import { inject } from "vue";
const user=ref([]);

const axios=inject("axios");
const  init=()=>{
  axios
  .post("user/usermessage",{
    user_id:123
  })
  .then((Response)=>{
   console.log(Response.data)
   user.value=Response.data;
  })
  .catch((error)=>{
    console.log(error);
  });
 
};
init();

const router = useRouter();
let viewOrder = () => {
  router.push({ path: "/viewOrder" });
};
let manageAddress = () => {
  router.push({ path: "/manageAddress" });
};
let login = () => {
  router.push({ path: "/login" });
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background-color: #f0f0f0;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 4px;
  width: 500px; /* 固定宽度 */
  overflow-y: auto; /* 允许垂直滚动 */
 
}
.wrapper header {
  width: 500px;
  height: 12vw;
  background-color: #0cc524;
  color: #fff;
  font-size: 4.8vw;
  text-align: center;
align-items: center;
}
.photo {
  border-width:1px;
  border-top-style:solid;
  border-bottom-style:solid;
  border-top-color:#f4f4f5;
  border-bottom-color:#f4f4f5;
  width:20%;
  height: 20vw;
  display: flex;
  float: left;
  margin-left: 30px;
   margin-bottom: 2vw;
}
.users {
  border-width:1px;
  border-top-style:solid;
  border-bottom-style:solid;
  border-top-color:#f4f4f5;
  border-bottom-color:#f4f4f5;
  width: 70%;
  height: 30vw;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: left;
  background-color: #ffffff;
  float: left;
  margin-bottom: 2vw;

}
.setting {
  width: 100%;
  height: 8vw;
  background-color: #ffffff;
  color: #73767a;
  margin-top: 20px;
  font-size: 30px;
}
.one{
  border-width:1px;
  border-top-style:solid;
  border-bottom-style:solid;
  border-top-color:#f4f4f5;
  border-bottom-color:#f4f4f5;
  padding-top: 2vw;
  padding-bottom: 2vw;
  background-color: #fff;
}
.two{
    border-width:1px;
  border-top-style:solid;
  border-bottom-style:solid;
  border-top-color:#f4f4f5;
  border-bottom-color:#f4f4f5;
  padding-top: 2vw;
  padding-bottom: 2vw;
  background-color: #fff;
  
  bottom: 150px; /* 距离页面最下端 */
  display: flex;
  justify-content: center;

}

</style>