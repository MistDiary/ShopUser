<template>
  <!-- 商品部分 -->
<div class="container">
  <div class="business">
    <div v-for="cart in carts" :key="cart.cartId">
      <div class="business_thing">
        <el-radio-group v-model="radio" class="ml-4">
          <el-radio value="1" size="large">{{ cart.bus_name }}</el-radio>
        </el-radio-group>
        <div class="liubai"></div>
        <div class="business_text">
          <el-radio-group class="ml-4">
            <el-radio v-model="radio1" size="large"></el-radio>
          </el-radio-group>
          <img :src="cart.pro_image" />
          <div class="business_text_text">
            <strong>{{ cart.pro_name }}</strong>
            <p class="liubai"></p>
            <p class="text_value"></p>
            <p class="text_money">￥{{ cart.pro_price + 10 }}|券后￥{{ cart.pro_price }}</p>
            <p class="liubai"></p>
            <div class="text_select3">数量：
              <div class="number">
                <el-input-number v-model="num" :min="1" :max="10" />
              </div>
            </div>
          </div>
        </div>
      </div>
   
    <!-- 结算部分 -->
    <div class="sum">
      <div class="sum_i">
        <el-radio-group class="ml-4">
          <el-radio value="1" size="large">全选</el-radio>
        </el-radio-group>
      </div>
      <div class="sum_sum">合计：￥{{ (cart.pro_price) * num }}</div>

      <div class="sum_button">
        <el-button type="danger" round  @click="sum( (cart.pro_price) * num,cart.bus_id,cart.pro_id,cart.pro_image,cart.bus_name,cart.pro_price,cart.pro_name)">结算</el-button>
      </div>
    </div>
   </div>
  </div>
</div> 
</template>

<script setup>
import { useRouter } from "vue-router";
import { h,ref, inject } from "vue";
const router = useRouter();
const axios = inject("axios");
let num1 = ref();
let carts = ref([]);
let i = ref();
let num = ref(1);
let bus_name = ref([]);

const init = () => {
  axios
    .post("cart/cartmessage", {
      user_id: 6

    })
    .then((Response) => {
      console.log(Response.data)
      carts.value = Response.data;
      num1 = carts.value.length;
    })
    .catch((error) => {
      console.log(error);
    });
}
init();
</script>

<style scoped>
.container {
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