<template>
  <div class="container">
    <el-icon color="green"  size="25" @click="return1"><ArrowLeftBold /></el-icon>
    <div class="products">
      <!-- 商品列表渲染 -->
      <div v-for="product in products" :key="product.pro_id" @click="toProductInfo(product.pro_id)">
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
import { ref, watch, inject, onMounted } from "vue";
import { useRoute,useRouter } from "vue-router";
import { 
  ArrowLeftBold
 } from "@element-plus/icons-vue";
const products = ref([]);
const route = useRoute();
const router = useRouter();
const axios = inject("axios");

onMounted(() => {
  if (route.query.q) {
    fetchProducts();
  }
});

const return1 = () => {
  router.push("/index");
};

const fetchProducts = async () =>  {
  try {
    const response = await axios.get('product/listProductByName', {
      params: { pro_name: route.query.q },
    });
      products.value = response.data;
    
  } catch (error) {
    console.error(error);
    // 向用户显示错误信息或其他错误处理
  }
}

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
  margin-bottom: 20px; /* 商品名称下边距 */
}

.product-info p {
  margin-bottom: 5px; /* 价格和库存下边距 */
}
.products {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  flex-direction: column; /* 保持商品列表竖直排列 */
  gap: 1px;
  
  
}

.pro_list {
  display: flex; /* 卡片内部使用flex布局 */
  align-items: left; /* 垂直居中 */
  width: 450px; /* 宽度设为100% */
  height: 200px; /* 高度自适应 */
  margin-top: 50px;
}
</style>