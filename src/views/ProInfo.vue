<template>
  <div class="container">
    <el-icon @click="return1"><ArrowLeftBold /></el-icon>
    <!-- 商品图片部分 -->
    <div class="product-image">
      <el-image :src="product.image_url" :alt="product.pro_name"></el-image>
    </div>
    <!-- 商品信息部分 -->
    <div class="product-info">
      <h1>{{ product.pro_name }}</h1>
      <p>&#165;{{ product.price }}</p>
      <p>库存 ：{{ product.store_num }}</p>
      <p>销量 ：{{ product.sales }}</p>
    </div>
    <!-- 底部按钮区域 -->
    <div class="buttons-footer">
      <div class="bu_bu">
        <div><el-icon color="green" size="30"><Shop /></el-icon></div>
        
        <button @click="toBusinessInfo(product.bus_id)" class="business_button">店铺</button>
      </div>

      
      <button  @click="addToCart(product)" >加入购物车</button>
      <button @click="buyNow">立即支付</button>
    </div>
  </div>
</template>

<script setup>
import { ref, inject } from "vue";
import { useRoute, useRouter } from "vue-router";

import { Shop,
  ArrowLeftBold
 } from "@element-plus/icons-vue";
const route = useRoute();
const router = useRouter();
const axios = inject("axios");

const product = ref({});


const return1 = () => {
  router.push("/index");
};

const init = () => {
  axios
    .post("product/getProductById", {
      pro_id: route.query.pro_id,
    })
    .then((response) => {
      product.value = response.data;
    })
    .catch((error) => {
      console.log(error);
    });
  
  };
  init();

const toBusinessInfo = (bus_id) => {
    router.push({path:"/busInfo",query:{bus_id:bus_id}});
}

  

  function addToCart(product) {
  axios.post('/cart/saveCart', { productId: product.id, quantity: 1 })
    .then(response => {
      console.log('Product added to cart:', response);
    })
    .catch(error => {
      console.error('Failed to add product to cart:', error);
      console.error(error);
    });
}

  const buyNow = () => {
    // 立即支付的逻辑
  };



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

.product-image {
  flex: 1; /* 让图片部分占据剩余空间 */
  display: flex;
  justify-content: center;
  align-items: center;
}

.product-info {
  flex: 1; /* 让信息部分占据剩余空间 */
  text-align: left;
  padding: 10px; /* 添加内边距 */
}
.product-info h1 {
  margin-bottom: 70px; /* 商品名称下边距 */
}

.product-info p {
  margin-bottom: 20px; /* 价格和库存下边距 */
}
.bu_bu {
  display: flex;
  flex-direction: column;
  align-items: center; /* 水平居中 */
  justify-content: center; /* 垂直居中 */
  height: 100%; /* 占满父元素的高度 */
}


.buttons-footer {
  display: flex;
  justify-content: space-around;
  align-items: center;
  padding: 15px 0;
  background-color: #ffffffca;
  border-top: 1px solid #4b761a;
  width: 100%;
}

button {
  flex: 1;
  margin: 0 5px;
  padding: 10px;
  border: none;
  border-radius: 4px;
  background-color: #ff0011;
  color: white;
  font-size: 16px;
  cursor: pointer;
}
.business_button {
  padding: 10px 20px;
  margin-top: 10px; /* 按钮与图标之间的间隔 */
  border: none;
  border-radius: 4px;
  background-color: #136bd7;
  color: white;
  font-size: 16px;
  cursor: pointer;
}

.business_button:hover {
  background-color: #4092e9;
}

</style>
