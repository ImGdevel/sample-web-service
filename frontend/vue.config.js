const path = require('path'); // Add this line

module.exports = {
  transpileDependencies: true,
  devServer: {
    port: 3000,
  },
  configureWebpack: {
    resolve: {
      alias: {
        '@': path.resolve(__dirname, 'src'),
      },
    },
  },
  chainWebpack: (config) => {
    config.plugin('define').tap((args) => {
      args[0].__VUE_PROD_HYDRATION__ = JSON.stringify(true);
      return args;
    });
  },
};
