<template>
  <v-expansion-panels>
    <v-expansion-panel v-for="(items, category) in services" :key="category">
      <v-expansion-panel-title>
        {{ category }}
      </v-expansion-panel-title>
      <v-expansion-panel-text>
        <v-list>
          <v-list-item
            v-for="item in items"
            @click="selectExam(item)"
            :key="item.id"
          >
            {{ item.title }} - R$ {{ item.price }}
          </v-list-item>
        </v-list>
      </v-expansion-panel-text>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
export default {
  name: "VTabs",
  data() {
    return {
      tab: null,
    };
  },
  props: {
    services: {
      type: Object,
      required: true,
    },
  },
  mounted() {
    // console.log("👉 table data => ", this.services);
  },
  methods: {
    selectExam(exam) {
      this.$emit("select-exam", exam);
      console.log("👉 exam => ", exam);
    },
  },
  computed: {},
};
</script>
