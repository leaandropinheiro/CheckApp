
module.exports = {
  preset: "@vue/cli-plugin-unit-jest",
  transform: {
    '^.+\\.vue$': '@vue/vue3-jest',
    '^.+\\.js$': 'babel-jest',
    '^.+\\.mjs$': 'babel-jest',
  },
  transformIgnorePatterns: [
    "/node_modules/(?!vuetify)/",
  ],
  moduleFileExtensions: [
    'js',
    'jsx',
    'json',
    'vue',
    'ts',
    'tsx',
  ],
  transformIgnorePatterns: [
    '/node_modules/(?!vuetify)',
  ],
  globals: {
    'vue-jest': {
      babelConfig: true,
    },
  },
};
