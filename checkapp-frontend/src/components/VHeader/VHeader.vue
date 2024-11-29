<template>
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
        <v-icon @click="goToHome"><CheckAppLogo /></v-icon>
      </v-col>
      <v-col
        lg="8"
        md="8"
        sm="8"
        class="d-flex align-center justify-center max-"
        max-width="350"
      >
        <VSearchbar v-if="isAuthenticated" />
      </v-col>
      <v-col lg="2" md="2" sm="2" class="d-flex align-center justify-end">
        <template v-if="!isAuthenticated">
          <v-btn
            append-icon="mdi-login-variant"
            variant="elevated"
            color="primary"
            elevation="0"
            @click="SignIn"
          >
            Login
          </v-btn>
        </template>
        <template v-else>
          <VProfile
            :name="currentUser?.name"
            :photo="userPhoto"
            :email="currentUser?.username"
            @edit="goToProfile"
          />
        </template>
      </v-col>
    </v-row>
  </v-app-bar>
</template>

<script>
import CheckAppLogo from "@/components/icons/CheckAppLogo.vue";
import VSearchbar from "@/components/VSearchbar/VSearchbar.vue";
import VProfile from "@/components/VProfile/VProfile.vue";
import { mapGetters } from "vuex";

export default {
  name: "VHeader",
  components: {
    CheckAppLogo,
    VSearchbar,
    VProfile,
  },
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
      currentUser: "auth/currentUser",
      userPhoto: "auth/userPhoto",
    }),
  },
  mounted() {},
  methods: {
    async SignIn() {
      try {
        await this.$store.dispatch("auth/login", this.$msalInstance);
        this.$router.push("/");
      } catch (error) {
        console.error("Authentication error:", error);
      }
    },

    async SignOut() {
      try {
        await this.$store.dispatch("auth/logout", this.$msalInstance);
        this.$router.push("/login");
      } catch (error) {
        console.error("Logout error:", error);
      }
    },

    goToHome() {
      this.$router.push("/");
    },

    isCheckoutPage() {
      return this.$route.path === "/checkout";
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
