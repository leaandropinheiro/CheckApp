<template>
  <v-breadcrumbs :items="items" divider="/">
    <template v-slot:title="{ item }">
      <v-breadcrumbs-item :to="item.href" :disabled="item.disabled">
        {{ item.title }}
      </v-breadcrumbs-item>
    </template>
  </v-breadcrumbs>
</template>

<script>
export default {
  name: "BreadcrumbNav",
  computed: {
    items() {
      const breadcrumbs = [];
      let path = "";

      this.$route.path.split("/").forEach((segment) => {
        if (segment) {
          path += `/${segment}`;
          const route = this.$router.resolve(path);

          breadcrumbs.push({
            title: route.name || segment, // Aqui usamos o name da rota
            disabled: this.$route.path === path,
            href: path,
          });
        } else {
          breadcrumbs.push({
            title: "Home",
            disabled: this.$route.path === "/",
            href: "/",
          });
        }
      });

      return breadcrumbs;
    },
  },
};
</script>
