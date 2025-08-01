<template>
  <router-view />
</template>
<script setup>
import { provide } from "vue";
import axios from "axios"

//设置axios的基础URL
axios.defaults.baseURL = "http://localhost:8087/rg/";
provide("axios",axios);
</script>


<style>
/**************************CSS重置**************************/
html,
body,
div,
span,
h1,
h2,
h3,
h4,
h5,
h6,
ul,
ol,
li,
p {
  margin: 0;
  padding: 0;
}
html,
body,
#app {
 margin: 0;
  padding: 0;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: "微软雅黑";
  
}
ui,
ol {
  list-style: none;
}
a {
  text-decoration: none;
}
/*************************CSS重置******************************/
</style>
