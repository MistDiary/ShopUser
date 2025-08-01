<template>
  <div class="container">
    <header>
      <h1>商城首页</h1>
      <!-- 搜索框 -->
      <div class="search-container">
        <el-input v-model="searchKeyword" placeholder="请输入商品名称进行搜索">
        </el-input>
        <button @click="searchProducts">搜索</button>
      </div>
    </header>

    <!-- 公告 -->
    <div class="announcement">
      <p>公告：购物平台正式上线！</p>
    </div>
    <!-- 分类导航 -->
    <div class="category-grid">
      <div
        class="category-item"
        v-for="(category, index) in categories"
        :key="index"
        @click="goToCategory(category.label)"
      >
        <img :src="category.image" class="category-image" />
        <p class="category-label">{{ category.label }}</p>
      </div>
    </div>
    <!-- 热销推荐 -->
    <section class="recommendation">
      <h2>热销推荐</h2>
      <ul>
        <li>
          <img src="../assets/清凉贴.png" alt="冰凉贴" />
          <div class="product-info">
            <h3>清凉贴</h3>
            <p>&yen; 8.00</p>
          </div>
        </li>
        <li>
          <img src="../assets/江西蜜橘.png" alt="江西蜜桔" />
          <div class="product-info">
            <h3>江西蜜橘</h3>
            <p>&yen; 30.00</p>
          </div>
        </li>
        <li>
          <img src="../assets/驱蚊液.png" alt="驱蚊液" />
          <div class="product-info">
            <h3>驱蚊液</h3>
            <p>&yen; 15.00</p>
          </div>
        </li>
        <li>
          <img src="../assets/笔记本.png" alt="笔记本" />
          <div class="product-info">
            <h3>笔记本</h3>
            <p>&yen; 10.00</p>
          </div>
        </li>
        <!-- 其他热销推荐项 -->
      </ul>
    </section>
    <!-- 商品列表 -->
    <section class="products">
      <h2>商品列表</h2>
      <div class="product-list">
        <div
          v-for="pro in productArr"
          :key="pro.pro_id"
          @click="toProductInfo(pro.pro_id)"
        >
          <el-card shadow="hover" class="pro_list">
            <div class="product-image">
              <el-image :src="pro.image" fit="cover"></el-image>
            </div>
            <div class="product-info">
              <h3>{{ pro.pro_name }}</h3>
              <p class="price">¥{{ pro.price }}</p>
            </div>
          </el-card>
        </div>
      </div>
      <div class="bottom-tip">已经到底了哦~</div>
    </section>
  </div>
</template>

<script setup>
import { ref, inject, onMounted, watch } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();
const axios = inject("axios");
let searchKeyword = ref(""); // 初始化搜索关键词
let productArr = ref([]);


const searchProducts = async () => {
  if (searchKeyword.value) {
    router.push({
      name: 'ProList',
      query: { q: searchKeyword.value },
    });
  }
  }

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
  await fetchProducts(); // 如果没有分类名称，获取全部商品列表
});
const toProductInfo = (pro_id) => {
  router.push({ path: "/proInfo", query: { pro_id: pro_id } });
};

// 搜索框数据

// 监听搜索框变化
watch(
  () => route.query.search,
  (keyword) => {
    if (keyword !== undefined) {
      searchKeyword.value = keyword;
      searchProducts();
    }
  }
);
// 类别数据
const categories = ref([
  {
    id: 1,
    label: "服装鞋帽",
    value: "Apparel",
    image: require("@/assets/Apparel.png"),
  },
  {
    id: 2,
    label: "美妆个护",
    value: " Beauty",
    image: require("@/assets/美妆.png"),
  },
  {
    id: 3,
    label: "数码家电",
    value: " Electronics",
    image: require("@/assets/数码.png"),
  },
  {
    id: 4,
    label: "食品饮料",
    value: "Food",
    image: require("@/assets/食品.png"),
  },
  {
    id: 5,
    label: "家居家纺",
    value: "Home",
    image: require("@/assets/家居.png"),
  },
  {
    id: 6,
    label: "母婴童品",
    value: "Baby",
    image: require("@/assets/母婴.png"),
  },
  {
    id: 7,
    label: "运动户外",
    value: "Sports",
    image: require("@/assets/户外.png"),
  },
  {
    id: 8,
    label: "图书音像 ",
    value: " Books",
    image: require("@/assets/图书.png"),
  },
  {
    id: 9,
    label: "箱包配饰",
    value: "Bags",
    image: require("@/assets/箱包.png"),
  },
  {
    id: 10,
    label: "学习用品",
    value: "Stationery",
    image: require("@/assets/学习.png"),
  },
]);

// 导航到分类页面
const goToCategory = (categoryLabel) => {
  router.push({ name: "Category", params: { category: categoryLabel } });
};
</script>

<style scoped>
/*总容器*/
.container {
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

header {
  display: flex;
  flex-direction: column;
  align-items: center; /* 如果您希望标题和搜索容器居中，可以添加这个属性 */
}

.search-container {
  display: flex;
  align-items: center; /* 使输入框和按钮垂直居中对齐 */
  margin: 10px 0; /* 添加一些上下边距 */
  width: 500px;
  height: auto;
}

.search-container .el-input {
  flex-grow: 1; /* 输入框占据剩余空间 */
  margin-right: 10px; /* 在输入框和按钮之间添加一些间距 */
}

.search-container button {
  width: 10%;
  text-align: center;
  background: #93db7f;
}
.announcement {
  text-align: left;
  margin-bottom: 20px;
}

.category-menu {
  margin-bottom: 20px;
}
.category-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.recommendation,
.product-list {
  margin-bottom: 20px;
}

.recommendation h2,
.product-list h2 {
  text-align: center;
  margin-bottom: 20px;
}

ul {
  list-style: none;
  padding: 0;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

li {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
  padding: 8px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
  transition: all 0.3s;
}

li img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 4px;
  margin-bottom: 10px;
}

.products {
  display: flex;
  text-align: center;
  flex-direction: column; /* 保持商品列表竖直排列 */
  justify-content: center;
}
.products h2 {
  margin-top: -10px;
}

.product-list {
  display: flex;
  flex-wrap: wrap; /* 允许项目在换行时添加额外的空白 */
  gap: 20px; /* 设置商品之间的间隔 */
  justify-content: space-between; /* 将项目分布在两侧 */
  flex: 0 0 calc(50% - 40px); /* 调整flex-basis以适应间隔 */
  margin-top: 20px;
}

.product-list .pro_list {
  width: 200px; /* 每个商品占50%的宽度，减去间隙 */
  height: 150px;
}
.product-info {
  text-align: center;
}

li:hover {
  background-color: #f0f0f0;
}

/* 价格样式 */
.product-info p {
  color: #ff0000;
  font-weight: bold;
}
.category-item {
  text-align: center;
  margin-bottom: 20px;
  flex-basis: calc(20% - 10px); /* 5个分类，每个占20%宽度，减去间隙 */
}

.category-image {
  width: 50%; /* 或者为自动适应父容器可以设置为 100% */
  height: 50%; /* 根据需要调整 */
  object-fit: cover;
  border-radius: 50px;
}

.category-label {
  margin-top: 5px;
  font-size: 14px;
}

.bottom-tip {
  text-align: center;
  margin-top: 10px;
  color: rgb(14, 184, 85);
}
</style>
