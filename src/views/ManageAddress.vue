<template>

  <div class="wrapper">

    <header>收货地址</header>
    <div class="setting">
      <p style=" text-align: right;" @click="this.$router.go(-1)">返回&nbsp;</p>
    </div>
    <div v-for="add in address" :key="add.address_id">
      <ul>
        <li>
          <div class="address">
            <p>{{ add.address_id }}&nbsp;{{add.place}}</p>
            <hr style="color: #f4f4f5" />
            <label for="delete" style="color: #b1b3b8" @click="dele(add.address_id)">删除</label>&nbsp;&nbsp;&nbsp;
            <label for="edit" style="color: #b1b3b8" @click="addressEdit">修改</label>&nbsp;&nbsp;&nbsp;
          </div>
        </li>
      </ul>
    </div>
    <div class="add">
      <el-button type="danger" plain @click="addressEdit">+添加收货地址</el-button>
    </div>
  </div>
</template>

<script setup>
import { Setting } from "@element-plus/icons-vue";
import { useRouter } from "vue-router";
import { ElMessage, ElMessageBox } from 'element-plus'
import { h,ref, inject } from "vue";
const address = ref([]);
const axios = inject("axios");
const init = () => {
  axios
    .post("address/addressmessage ", {
      user_id: 123

    })
    .then((Response) => {
      console.log(Response.data)
      address.value = Response.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

init();


const router = useRouter();

let addressEdit = () => {
  router.push({ path: "/addressEdit" });
};

const dele = (address_id) => {
  axios
    .post("address/deladdress ", {
      address_id: address_id

    })
    .then((Response) => {
      console.log(Response.data)
      let a = Response.data;
      ElMessageBox({
        title: '提示',
        message: h('p', null, [
          h('span', null, '删除成功 '),
          h('i', { style: 'color: teal' }, '请刷新'),
        ]),
      })
     
    })
    .catch((error) => {
      console.log(error);
    });
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
  width: 100%;
  height: 12vw;
  background-color: #cd1750;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;
}

.setting {
  width: 100%;
  height: 8vw;

  color: #73767a;
  margin-top: 12vw;
  font-size: 20px;
}

.address {
  width: 100%;
  height: 28vw;
  background-color: #fff;
  border-width: 5px;
  border-top-style: solid;
  border-bottom-style: solid;
  border-top-color: #f4f4f5;
  border-bottom-color: #f4f4f5;
  margin-top: 2vw;
  margin-bottom: 2vw;
}

.add {
  width: 100%;
  padding-top: 24px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.add el-button {
  margin: auto;
}

</style>