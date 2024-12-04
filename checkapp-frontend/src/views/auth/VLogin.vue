<template class="container">
  <v-container>
    <v-card
      height="96vh"
      elevation="0"
      class="d-flex justify-center align-center"
    >
      <v-row
        cols="12"
        lg="12"
        md="12"
        sm="12"
        xs="12"
        class="d-flex justify-center"
      >
        <v-col cols="6">
          <v-card elevation="0">
            <v-container>
              <v-card
                height="67vh"
                elevation="0"
                class="d-flex justify-center align-center"
              >
                <img
                  src="https://wallpaperboat.com/wp-content/uploads/2021/03/17/71823/health-02.jpg"
                  alt=""
                  height="100%"
                />
              </v-card>
            </v-container>
          </v-card>
        </v-col>
        <v-col cols="6">
          <v-card height="70vh" elevation="0">
            <v-container>
              <v-card height="70vh" elevation="0">
                <v-container></v-container>
                <v-card elevation="0" height="20vh" class="">
                  <v-card-title class="font-weight-black text-h4">
                    Login
                  </v-card-title>
                  <v-card-subtitle>
                    Entre com sua conta da microsoft
                  </v-card-subtitle>
                </v-card>

                <v-card elevation="0" height="20vh" class="d-flex align-center">
                  <v-btn
                    :disabled="loading"
                    :loading="loading"
                    prepend-icon="mdi-microsoft"
                    class="text-none mb-4"
                    color="black"
                    size="x-large"
                    variant="flat"
                    block
                    @click="SignIn"
                  >
                    Microsoft
                  </v-btn>
                </v-card>
              </v-card>
            </v-container>
          </v-card>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      email: "",
      password: "",
      loading: false,
    };
  },
  computed: {
    ...mapGetters({
      isAuthenticated: "auth/isAuthenticated",
      currentUser: "auth/currentUser",
      userPhoto: "auth/userPhoto",
    }),
  },
  methods: {
    async SignIn() {
      try {
        if (this.$msalInstance.getActiveAccount()) {
          await this.$msalInstance.handleRedirectPromise();
        }

        await this.$store.dispatch("auth/login", this.$msalInstance);
        this.$router.push("/");
      } catch (error) {
        if (error.errorCode === "interaction_in_progress") {
          setTimeout(async () => {
            await this.$store.dispatch("auth/login", this.$msalInstance);
            this.$router.push("/");
          }, 1000);
        } else {
          console.error("Authentication error:", error);
        }
      }
    },
  },
};
</script>

<style scoped>
.container {
  display: flex !important;
  justify-content: center !important;
  align-items: center !important;
  height: 100vh;
}
</style>
