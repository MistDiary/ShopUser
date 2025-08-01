<template>
  <el-container class="container">
    <el-aside width="200px">
      <el-menu>
        <el-menu-item @click="fetchProducts()">
          <span>全部</span>
          </el-menu-item>
        <el-menu-item v-for="(category, index) in categories" :key="index" @click="fetchProductsByCategory(category.name)">
          <span>{{ category.name }}</span>
        </el-menu-item>
      </el-menu>
    </el-aside>

    <el-main>
      <div class="products">
        <div v-for="pro in productArr" :key="pro.pro_id" @click="toProductInfo(pro.pro_id)">
          <el-card shadow="hover" class="pro_list">
            <div class="product-image">
              <el-image :src="pro.image" fit="cover"></el-image>
            </div>
            <div class="product-info">
              <h3>{{ pro.pro_name }}</h3>
              <p class="price">¥{{ pro.price }}</p>
            </div>
            <div class="cart-action">
              <el-icon style="font-size: 36px ;color: #cf3131 "> <ShoppingCart /></el-icon>
              <button @click="add(pro.pro_id,pro.pro_price,pro.pro_name,pro.pro_image)">加入购物车</button>
                
              
            </div>
          </el-card>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script setup>
import { ref,h, inject,onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { 
    
ShoppingCart

 } from "@element-plus/icons-vue";
 import qs from 'qs';
 import { ElMessage, ElMessageBox } from 'element-plus'


const route = useRoute();
const router = useRouter();
const axios = inject("axios");

const categories = ref([
  { name: '服装鞋帽' },
  { name: '美妆个护' },
  { name: '数码家电' },
  { name: '食品饮料' },
  { name: '家居家纺' },
  { name: '母婴童品' },
  { name: '运动户外' },
  { name: '图书音像' },
  { name: '箱包配饰' },
  { name: '学习用品' },
]);
let productArr = ref([]);
const user = ref(null);
const fetchProductsByCategory = async (categoryName) => {
  try {
    const response = await axios.post("product/listProductByPro_category", { category: categoryName });
    productArr.value = response.data;
    console.log(productArr);
  } catch (error) {
    console.error(error);
  }
};
const fetchProducts = async () => {
  try {
    const response = await axios.post("product/listProduct");
    productArr.value = response.data;
    console.log(productArr);
  } catch (error) {
    console.error(error);
  }
};

onMounted(async () => {
   const categoryName = route.params.category;
  if (categoryName) {
    await fetchProductsByCategory(categoryName); // 根据分类名称获取商品列表
  } else {
    await fetchProducts(); // 如果没有分类名称，获取全部商品列表
  }
});
const toProductInfo = (pro_id) => {
  router.push({path:"/ProInfo",query:{pro_id:pro_id}});
};
const bus_id = ref(null);
/*function addToCart(pro) {
  // 添加到购物车的逻辑
  console.log(`Added ${pro.pro_name} to cart.`);
};*/

const  add=(pro_id,pro_price,pro_name,pro_image)=>{
  axios
  .post("cart/insercartmessage",{
    
    pro_num:1,
    pro_id:pro_id,
    bus_id:1,
    user_id:6,
    pro_price:pro_price,
    pro_image:pro_image,
    pro_name:pro_name,
    bus_name:"电子产品专营店",
   
  })
  .then((Response)=>{
   console.log(Response.data);
   ElMessageBox({
        title: '提示',
        message: h('p', null, [
          h('span', null, '加入购物车成功 '),
          h('i', { style: 'color: teal' }, ''),
        ]),
      })
      router.push({ path: "/sortManagement" })
  })
  .catch((error)=>{
    console.log(error);
  });
};
</script>


<style scoped>
.container {
  display: flex;
  flex-direction: row;
  height: 100vh;
  background-color: #f0f0f0;
  border: 1px solid #ddd;
  border-radius: 4px;
  width: 530px; /* 固定宽度 */
}

.products {
  display: flex;
  flex-direction: column; /* 保持商品列表竖直排列 */
  gap: 20px;
  justify-content: center;
  flex-grow: 1; /* 确保容器能够扩展以显示内容 */
}

.pro_list {
  display: flex; /* 卡片内部使用flex布局 */
  flex-direction: row; /* 商品信息横向排列 */
  align-items: center; /* 垂直居中 */
  width: 300px; /* 宽度设为100% */
  height: 200px; /* 高度自适应 */
}
.product-image {
  width: 100px;
  height: 100px;
}

.product-info {
  flex-grow: 1; /* 让信息区域占满剩余空间 */
  text-align: center;
}

.cart-action {
  margin-left: auto; /* 将购物车图标放到最右边 */
}
</style>