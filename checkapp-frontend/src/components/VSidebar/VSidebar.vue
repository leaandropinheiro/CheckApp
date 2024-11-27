<template>
  <v-card width="56" elevation="0">
    <v-layout height="100vh" fixed>
      <v-navigation-drawer border="opacity-50 sm" theme="" permanent rail>
        <v-divider></v-divider>

        <v-list>
          <v-list-item prepend-icon="mdi-forum" value="messages"></v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-main style="height: 300px"></v-main>
    </v-layout>
  </v-card>
</template>
<script>
// import emitter from "@/plugins/eventBus";

export default {
  components: {},
  data() {
    return {
      drawer: null,
      rail: true,
    };
  },
  mounted() {},
  beforeUnmount() {},
  methods: {
    toggleDrawer() {
      this.rail = !this.rail;
    },
  },
  computed: {
    isMenuOpen() {
      return this.rail ? "mdi-menu-close" : "mdi-menu-open";
    },
  },
  watch: {},
};
</script>

<style>
.v-navigation-drawer__content {
  min-width: 51px !important;
}
</style>
