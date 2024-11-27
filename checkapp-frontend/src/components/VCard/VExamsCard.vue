<template>
  <v-card v-bind="props">
    <template v-slot:title>
      <v-card-title>{{ title }}</v-card-title>
      <v-card-subtitle>{{ subtitle }}</v-card-subtitle>
    </template>
  </v-card>
</template>

<script>
import { defineComponent } from "vue";

export default defineComponent({
  name: "VExamsCard",
  props: {
    title: {
      type: String,
      default: "",
    },
    subtitle: {
      type: String,
      default: "",
    },
  },
});
</script>

<style scoped></style>
