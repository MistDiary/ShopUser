<template>
  <div class="container">
     <el-icon @click="return1"><ArrowLeftBold /></el-icon>
    <h1>商家详情</h1>
    <el-card class="bus_card">
      <div class="business-image">
        <el-image :src="business.u_image" :alt="business.bus_name"></el-image>
      </div>

      <!-- 商品信息部分 -->
      <div class="business-info">
        <h1>{{ business.bus_name }}</h1>
      </div>
    </el-card>

    <h1>商品列表</h1>

    <!-- 商品列表部分 -->
    <div class="products">
      <!-- 商品列表渲染 -->
      <div v-for="product in productArr" :key="product.pro_id" @click="toProductInfo(product.pro_id)">
        <!-- 商品信息 -->
        <el-card shadow="hover" class="pro_list">
          <!-- 商品图片部分 -->
          <div class="product-image">
            <el-image :src="product.image" fit="cover"></el-image>
          </div>
          <!-- 商品信息部分 -->
          <div class="product-info">
            <h1>{{ product.pro_name }}</h1>
            <p>&#165;{{ product.price }}</p>
            <p>库存 ：{{ product.store_num }}</p>
            <p>销量 ：{{ product.sales }}</p>
          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted, inject } from "vue";
import { useRoute, useRouter } from "vue-router";
import { 
  ArrowLeftBold
 } from "@element-plus/icons-vue";

const route = useRoute();
const router = useRouter();
const axios = inject("axios");
const business = ref({});
const productArr = ref([]);
const return1 = () => {
  router.push("/index");
};
axios
  .post("product/listProductByBus_id", {
    bus_id: route.query.bus_id,
  })
  .then((response) => {
    productArr.value = response.data;
  })
  .catch((error) => {
    console.log(error);
  });

onMounted(async () => {
  try {
    const response = await axios.post("business/getBusinessById", {
      bus_id: route.query.bus_id,
    });
    business.value = response.data;
  } catch (error) {
    console.error(error);
  }
});

const toProductInfo = (pro_id) => {
  router.push({ name: 'ProInfo',query:{pro_id:pro_id}});
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
.container h1 {
  text-align: center;
  margin-top: 15px;
}

.business-image {
  flex: 1; /* 让图片部分占据剩余空间 */
  display: flex;
  justify-content: center;
  align-items: center;
}

.business-info {
  flex: 1; /* 让信息部分占据剩余空间 */
  text-align: left;
  padding: 10px; /* 添加内边距 */
}
.bus_card {
  display: flex; /* 卡片内部使用flex布局 */
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  width: 100%; /* 宽度设为100% */
  height: auto; /* 高度自适应 */
}
.products {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  flex-direction: column; /* 保持商品列表竖直排列 */
  gap: 20px;
  margin-top: 30px;
  
}
.pro_list {
  display: flex; /* 卡片内部使用flex布局 */
  align-items: left; /* 垂直居中 */
  width: 500px; /* 宽度设为100% */
  height: auto; /* 高度自适应 */
}
</style>
