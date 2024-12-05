const { defineConfig } = require("@vue/cli-service");
const webpack = require('webpack');

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 3000
  },
  configureWebpack: {
    performance: {
      hints: false
    },
    plugins: [
      new webpack.DefinePlugin({
        __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: 'false'
      }),
      new webpack.ProvidePlugin({
        Buffer: ['buffer', 'Buffer']
      })
    ],
    resolve: {
      fallback: {
        "buffer": require.resolve("buffer/")
      }
    }
  }
});
