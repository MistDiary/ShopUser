
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    port: 8086
  }
})
module.exports = {
  publicPath: '/ShopUser/'
}



