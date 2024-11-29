<template>
  <v-app>
    <VHeader />
    <v-main class="d-flex" height="100vh">
      <template v-if="isAuthenticated">
        <div class="d-flex flex-grow-1 aquiiii">
          <VSidebar />
          <v-container fluid>
            <v-row class="cardzin">
              <router-view />
            </v-row>
          </v-container>
        </div>
        <VCart v-if="!isCheckoutPage()" />
      </template>
      <template v-else>
        <v-container fluid>
          <v-row>
            <router-view />
          </v-row>
        </v-container>
      </template>
    </v-main>
  </v-app>
</template>

<script>
import VHeader from "@/components/VHeader/VHeader.vue";
import VSidebar from "@/components/VSidebar/VSidebar.vue";
import VCart from "@/components/VCart/VCart.vue";
import { mapGetters } from "vuex";

export default {
  name: "App",
  components: {
    VHeader,
    VSidebar,
    VCart,
  },
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
    }),
  },
  methods: {
    isCheckoutPage() {
      return this.$route.path === "/checkout";
    },
  },
};
</script>

<style>
.aquiiii {
  margin: 0 !important;
  width: calc(100% - 300px) !important;
}
</style>
