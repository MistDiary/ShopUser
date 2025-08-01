<template>
  <div class="container">
    <img src="../assets/res.png" width="200px" />
    <img class="res_img" src="../assets/logo.png" width="150px" />
    <div class="res-card">
      <el-card style="max-width: 300px; margin: 0 auto; margin-bottom: 70px">
        <template #header>
          <div class="card-header">
            <span>注册</span>
          </div>
        </template>
        <p>
          <el-form
            :model="registerForm"
            :rules="rules"
            ref="userFormRef"
            label-width="auto"
            style="max-width: 600px"
          >
            <el-form-item label="用户名">
              <el-input v-model="registerForm.user_name" />
            </el-form-item>

            <el-form-item label="手机号" prop="tel1">
              <el-input v-model="registerForm.tel1" />
            </el-form-item>

            <el-form-item label="密码" prop="password">
              <el-input
                type="password"
                v-model="registerForm.password"
                show-password
              />
            </el-form-item>

            <el-form-item label="确认密码" prop="Conpassword">
              <el-input
                type="password"
                v-model="registerForm.Conpassword"
                show-password
              />
            </el-form-item>
          </el-form>
        </p>
        <div class="button-group">
          <el-button type="primary" @click="submitForm">注册</el-button>
          <el-button type="primary" @click="login">登录</el-button>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script setup>
import { ref, inject } from "vue";
import { useRoute, useRouter } from "vue-router";
const router = useRouter();
const route = useRoute();
const axios = inject("axios");
// do not use same name with ref
const registerForm = ref({
  user_name: "",
  tel1: "",
  password: "",
  Conpassword: "",
});

const rules = {
  user_name: [
    { required: true, message: "请输入用户昵称", trigger: "blur" },
    {
      validator: (rule, value, callback) => {
        if (value && value.length > 10) {
          callback(new Error("用户昵称长度超标，最多10个字"));
        } else {
          callback();
        }
      },
      trigger: "blur",
    },
  ],
  tel1: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    {
      pattern: /^1[3-9]\d{9}$/, // 假设这是一个简单的中国大陆手机号正则表达式
      message: "手机号格式不正确",
      trigger: "blur",
    },
  ],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }],
  Conpassword: [
    { required: true, message: "请再次输入密码", trigger: "blur" },
    {
      validator: (rule, value, callback) => {
        if (value === "") {
          callback(new Error("请再次输入密码"));
        } else if (value !== registerForm.value.password) {
          callback(new Error("两次输入的密码不一致!"));
        } else {
          callback();
        }
      },
      trigger: "blur",
    },
  ],
};

const userFormRef = ref(null);

const login = () => {
  router.push("/login");
};

const submitForm = () => {
  userFormRef.value.validate((valid) => {
    if (valid) {
      axios
        .post("user/insertUser", {
          ...registerForm.value,
          //user_name: route.query.user_name,
          //tel1: route.query.tel1,
         // password: route.query.password,
        })
        .catch((error) => {
          console.log(error);
        });
      router.push("/login");
    } else {
      console.log("表单验证失败，请检查输入");
      return false;
    }
  });
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

img:first-child {
  width: 100%;
  height: auto;
}
.res_img {
  display: block;
  margin: auto;
  margin-top: 60px;
}
</style>