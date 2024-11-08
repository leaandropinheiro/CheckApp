module.exports = {
  preset: "@vue/cli-plugin-unit-jest",
  setupFiles: ["<rootDir>/jest.setup.js"],
  transform: {
    "^.+\\.vue$": "@vue/vue3-jest",
    "^.+\\.js$": "babel-jest",
    "^.+\\.mjs$": "babel-jest",
  },
  transformIgnorePatterns: ["/node_modules/(?!vuetify)/"],
  moduleFileExtensions: ["js", "jsx", "json", "vue", "ts", "tsx"],
  moduleNameMapper: {
    "^vuetify/styles$": "jest-transform-stub",
    "^vuetify/.*$": "vuetify",
  },
  transformIgnorePatterns: ["/node_modules/(?!vuetify)"],
  globals: {
    "vue-jest": {
      babelConfig: true,
    },
  },
};
