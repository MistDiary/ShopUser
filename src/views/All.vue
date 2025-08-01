<template>
  全部订单
  <div  class="wrapper" >
    <ul>
      <li>
        <div v-for="(mess, item) in message" :key="item">
          <div v-for="(m, index) in mess" :key="index">
            <div class="billing"   @click="orderDetails(m.order_id)">
              <div class="billing-name">
                <el-icon>
                  <Promotion />
                </el-icon>
              </div>
              <div class="billing-text" style="text-align: center">
                <label>{{ m.order_id }}</label><br /><br />
                <label style="color: #b1b3b8">￥{{ m.t_money }}</label>
                <label>{{ m.order_time }}</label><br /><br />
                <br />
              </div>
            </div>
          </div>
        </div>
      </li>


    </ul>
  </div>
</template>

<script setup>
import { Promotion } from "@element-plus/icons-vue";
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

let orderDetails = (order_id) => {
  router.push({ path: "/orderDetails" ,query:{order_id:order_id}});
};

import { inject } from "vue";
let num = ref();
let i = ref();
let orders = ref([]);
let message = ref([]);
const axios = inject("axios");
const init = () => {
  axios
    .post("order/all", {
      user_id: 123,


    })
    .then((Response) => {
      console.log(Response.data)
      orders.value = Response.data;
      num = orders.value.length;
      for (i = 0; i < num; i++) {
        axios
          .post("order/appearorderDetailsMessage", {
            order_id: orders.value.at(i).order_id

          })
          .then((Response) => {
            message.value.push(Response.data);
            console.log(message);
          })
          .catch((error) => {
            console.log(error);
          });

      }
    })
    .catch((error) => {
      console.log(error);
    });
};

init();
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #f4f4f5;
}

/*******************订单********************/
.billing {
  width: 100%;
  height: 40vw;
  /*border-style: solid;
  border-color: #fcd3d3;*/
  background-color: #fff;
  border-radius: 10px;
}

.billing .billing-name {
  width: 100%;
  height: 15%;
}

.billing .billing-photo {
  width: 30%;
  height: 85%;
  float: left;
}

.billing .billing-photo img {
  width: 100%;
  height: 100%;
}

.billing .billing-text {
  width: 70%;
  height: 60%;
  float: left;
}

.billing .billing-button {
  width: 70%;
  height: 25%;
  float: left;
  display: flex;
  justify-content: center;
  align-items: center;
}

.billing .billing-button el-button {
  margin: auto;
}

/****************** 导航 ******************/
.wrapper .el-menu {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: 8vw;
  background-color: #fff;
}

/****************** header ******************/
.wrapper header {
  width: 100%;
  height: 5vw;
  background-color: #fcd3d3;

  display: flex;
  align-items: center;
}

.wrapper header .location-text {
  font-size: 4.5vw;
  color: #fff;
}

.wrapper header .location-text .fa-caret-down {
  margin-left: 1vw;
}

/****************** search ******************/
.wrapper .search {
  width: 100%;
  height: 13vw;
}

.wrapper .search .search-fixed-top {
  width: 100%;
  height: 13vw;
  background-color: #fcd3d3;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .search .search-fixed-top .search-box {
  width: 90%;
  height: 9vw;
  background-color: #fff;
  border-radius: 2px;

  display: flex;
  justify-content: center;
  align-items: center;

  font-size: 3.5vw;
  color: #aeaeae;
  font-family: "宋体";
  user-select: none;
}

.wrapper .search .search-fixed-top .search-box .fa-search {
  margin-right: 1vw;
}


.wrapper .footer li {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  color: #894545;
  user-select: none;
  cursor: pointer;
}

.wrapper .footer li p {
  font-size: 2.8vw;
}

.wrapper .footer li button {
  font-size: 2.8vw;
}

.wrapper .footer li i {
  background: #ddd;
  font-size: 5vw;
}
</style>