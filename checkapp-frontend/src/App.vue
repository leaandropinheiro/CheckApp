<template>
  <v-app>
    <VHeader />
    <v-main class="d-flex">
      <VSidebar />
      <v-container fluid max-width="inherit">
        <v-row class="d-flex align-center bg-gre">
          <router-view />
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import VHeader from "./components/VHeader/VHeader.vue";
import VSidebar from "./components/VSidebar/VSidebar.vue";

export default {
  name: "App",
  components: {
    VHeader,
    VSidebar,
  },
};
</script>

<style lang="scss"></style>
