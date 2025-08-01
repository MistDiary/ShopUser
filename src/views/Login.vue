<template>
<div class="container">
<img src="../assets/login.png" width="200px" />
<img  class="logo_img" src="../assets/logo.png" width="150px" />
  <div class="login-card">
  <el-card 
    style="max-width: 300px; margin: 0 auto; margin-bottom: 70px"
  >
    <template #header>
      <div class="card-header">
        <span>登录</span>
      </div>
    </template>
    <p>
      <el-form :model="userForm" 
       :rules="rules"
       ref="userFormRef"
      label-width="auto" 
      style="max-width: 600px"
      >

        <el-form-item label="手机号">
          <el-input v-model="userForm.tel1" />
        </el-form-item>

        <el-form-item label="密码">
          <el-input v-model="userForm.password" show-password />
        </el-form-item>
      </el-form>
    </p>
    <div class="button-group">
      <el-button type="primary" @click="login">登录</el-button>
      <el-button type="primary" @click="goToRegisterogin">注册</el-button>
    </div>
    <div class="forgot-password">
      <a href="#" @click.prevent="forgotPassword">忘记密码?</a>
    </div>
  </el-card>
</div>
</div>
</template>




<script setup>
import { ref,inject } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();
const axios = inject("axios");

let loginSuccess = false;


// do not use same name with ref
const userForm = ref({
  tel1: "",
  password: "",
});
const userFormRef = ref(null);
const userData = ref(null);


const login = async () => {
  try {
await userFormRef.value.validate((valid) => {
      if (!valid) throw new Error("表单验证失败，请检查输入");
    });

    const response = await axios.post("user/checkUserByPassword", {
      ...userForm.value,
 });
    if (response.data) {
      const userId  = response.data; 
      window.sessionStorage.setItem('uer_id', userId);
      router.push("/index");
    } else {
      alert("用户名或密码不正确");
      console.log("登录失败");
    }
  } catch (error) {
    console.log(error);
  }
};



const rules = {
  tel1: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    {
      pattern: /^1[3-9]\d{9}$/, // 假设这是一个简单的中国大陆手机号正则表达式
      message: "手机号格式不正确",
      trigger: "blur",
    },
  ],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }],
};

const goToRegisterogin = () => {
  router.push("/register");
};
const forgotPassword = () => {
  router.push("/modifyPassword");
};
</script>

<style scoped>

.container {
  display: flex;
  flex-direction: column;
  width: 100%;
  background-color: rgb(249, 249, 249);
  max-width: 500px; /* 设置一个最大宽度，适应移动端 */
  margin-left: auto;
  margin-right: auto;
  padding: 20px; /* 添加一些内边距 */
  height: 700px; /* 使用视口高度 */
  box-sizing: border-box; /* 确保内边距不会增加容器的宽度 */
}


.button-group {
  display: flex;
  justify-content: space-between; /* 分居两侧 */
  margin-top: 20px; /* 添加一些顶部外边距 */
}
.forgot-password {
  text-align: right; /* 文本居中 */
  margin-top: 10px; /* 添加一些顶部外边距 */
  font-size: 13px;
}
img:first-child  {
  width: 100%;
  height: auto;
 
}
.logo_img {
  
  display: block;
  margin: auto;
  margin-top: 60px;

  
}

</style>