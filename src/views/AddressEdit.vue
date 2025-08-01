<template>
  <div class="wrapper">
    <header>编辑收货地址</header>
    <div class="setting">
      <p style=" text-align: right;" @click="this.$router.go(-1)">返回&nbsp;</p>
    </div>

    <div class="addEdit">
      <form action="post">
        地址id：<input type="text" v-model="ad.address_id" /><br />
        位置：<input type="text" v-model="ad.place" /><br />
      </form>
    </div>

    <div class="add">
      <el-button type="danger" plain @click="this.$router.go(-1)">取消</el-button>
      <el-button type="danger" plain @click="init">保存收货地址</el-button>
    </div>
  </div>
</template>

<script setup>
import { Setting } from "@element-plus/icons-vue";
import { h, ref } from "vue";
import { useRouter } from "vue-router";


let ad = ref({
  address_id: " ",
  place:" ",
  user_id:" ",
})
const router = useRouter();

import { inject } from 'vue'
let judge = ref([]);
const axios = inject("axios");

import { ElMessage, ElMessageBox } from 'element-plus'

const init = () => {
  axios
    .post("address/insertaddressmessage", {
      address_id: ad.value.address_id,
      place: ad.value.place,
      user_id: ad.value.user_id,

    })
    .then((Response) => {
      console.log(Response.data)
      judge.value = Response.data;
      ElMessageBox({
        title: '提示',
        message: h('p', null, [
          h('span', null, '保存成功'),
          h('i', { style: 'color: teal' }, ''),
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
  background-color: #fcd3d3;
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
  background-color: #ffffff;
  color: #73767a;
  margin-top: 12vw;
  font-size: 20px;
}

.addEdit {
  width: 100%;
  height: 50vw;
  background-color: #fff;
  line-height: 2em
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

/****************** 底部菜单部分 ******************/
.wrapper .footer {
  width: 100%;
  height: 14vw;
  border-top: solid 1px #ddd;
  background-color: #f6f3f3;
  position: fixed;
  left: 0;
  bottom: 0;

  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .footer li {
  /*li本身的尺寸完全由内容撑起*/
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: #894545;
  user-select: none;
  cursor: pointer;
}

.wrapper .footer li p {
  font-size: 2.8vw;
}

.wrapper .footer li button {
  font-size: 2.8vw;
}

.wrapper .footer li i {
  background: #ddd;
  font-size: 5vw;
}
</style>