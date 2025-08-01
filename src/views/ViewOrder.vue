<template>
  <div class="wrapper">
      <el-button type="danger" plain @click="all">全部订单</el-button>

      <el-button type="danger" plain @click="unsipped">未发货</el-button>

      <el-button type="danger" plain @click="sipped">已发货</el-button>

      <el-button type="danger" plain @click="unpaid">未支付</el-button>
      <el-button type="danger" plain @click="over">已完成</el-button>
    </div>
 </template>
<script setup>
import { Promotion } from "@element-plus/icons-vue";
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();
let all = () => {
  router.push({ path: "/all" });
};
let unsipped = () => {
  router.push({ path: "/unsipped" });
};
let sipped = () => {
  router.push({ path: "/sipped" });
};
let unpaid = () => {
  router.push({ path: "/unpaid" });
};
let over = () => {
  router.push({ path: "/over" });
};
</script>
<style>
.wrapper{
    display: flex;
  flex-direction: column;
  height: 100vh; /* 使容器占据全屏高度 */
  background-color: #f0f0f0;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 4px;
  width: 500px;
}
</style>