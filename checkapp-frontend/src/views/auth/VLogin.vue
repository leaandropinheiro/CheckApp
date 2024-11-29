<template>
  <v-container>
    <h1>por favor faça o login</h1>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    async handleLogin() {
      try {
        const currentAccounts = this.$msalInstance.getAllAccounts();
        if (currentAccounts.length > 0) {
          await this.$msalInstance.handleRedirectPromise();
        }

        const loginRequest = {
          scopes: ["User.Read"],
          loginHint: this.email,
          prompt: "select_account",
        };

        await this.$msalInstance.loginPopup(loginRequest);
        await this.$store.dispatch("auth/login", this.$msalInstance);
        this.$router.push("/");
      } catch (error) {
        console.error("Login failed:", error);
      }
    },
  },
};
</script>
