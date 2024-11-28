<template>
  <!-- <v-app-bar fixed :elevation="0" color="#0200B9" height="80" class="px-4"> -->
  <v-app-bar
    fixed
    :elevation="0"
    color=""
    border="opacity-50 sm"
    height="80"
    class="px-4"
  >
    <v-row class="d-flex align-center justify-space-between" cols="12">
      <v-col lg="2" md="2" sm="2" class="d-flex align-center justify-start">
        <v-icon><CheckAppLogo @click="homePage" /></v-icon>
      </v-col>
      <v-col
        lg="8"
        md="8"
        sm="8"
        class="d-flex align-center justify-center max-"
        max-width="350"
      >
        <VSearchbar />
      </v-col>
      <v-col lg="2" md="2" sm="2" class="d-flex align-center justify-end">
        <!-- <v-avatar color="surface-variant"></v-avatar> -->
      </v-col>
    </v-row>
  </v-app-bar>
</template>

<script>
import CheckAppLogo from "@/components/icons/CheckAppLogo.vue";
import VSearchbar from "@/components/VSearchbar/VSearchbar.vue";
// import emitter from "@/plugins/eventBus";

export default {
  name: "VHeader",
  components: {
    CheckAppLogo,
    VSearchbar,
  },
  methods: {
    homePage() {
      this.$router.push("/");
    },
  },
};
</script>

<style>
.header-logo {
  width: 2rem !important;
  cursor: pointer;
}
</style>
