<template>
  <v-app>
    <VHeader v-if="isAuthenticated" />
    <v-main class="d-flex" height="100vh">
      <template v-if="isAuthenticated">
        <div class="d-flex flex-grow-1 aquiiii">
          <VSidebar />
          <v-container fluid>
            <BreadcrumbNav />
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
import BreadcrumbNav from "@/components/BreadcrumbNav/BreadcrumbNav.vue";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "App",
  components: {
    VHeader,
    VSidebar,
    VCart,
    BreadcrumbNav,
  },
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
    }),
  },
  methods: {
    ...mapActions({
      checkAuth: "auth/checkAuth",
    }),
    isCheckoutPage() {
      return this.$route.path === "/checkout";
    },
  },
  async created() {
    await this.checkAuth();
    if (!this.isAuthenticated) {
      this.$router.push("/login");
    }
  },
};
</script>

<style>
.aquiiii {
  margin: 0 !important;
  width: calc(100% - 300px) !important;
}
</style>
