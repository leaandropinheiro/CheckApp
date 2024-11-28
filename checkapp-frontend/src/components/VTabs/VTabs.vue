<template>
  <v-expansion-panels>
    <v-expansion-panel v-for="(items, category) in services" :key="category">
      <v-expansion-panel-title class="expansion-panel-title text-uppercase">
        {{ category }}
      </v-expansion-panel-title>
      <v-expansion-panel-text>
        <v-list>
          <v-list-item v-for="item in items" :key="item.id">
            <v-table>
              <tbody>
                <tr>
                  <td class="table-td-title">{{ item.title }}</td>
                  <td class="table-td-price">R$ {{ item.price }},00</td>
                  <td class="table-td-button">
                    <v-btn
                      density="compact"
                      icon="mdi-plus"
                      size="small"
                      @click="selectExam(item)"
                    ></v-btn>
                  </td>
                </tr>
              </tbody>
            </v-table>
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

<style scoped>
.v-list-item {
  padding: 0 !important;
  margin: 0 !important;
}

.table-td-title,
.table-td-price,
.table-td-button {
  padding: 0 !important;
  margin: 0 !important;
}

:deep(.expansion-panel-title) {
  font-weight: 400;
  font-size: 1rem;
}

:deep(.table-td-title) {
  width: 60% !important;
  text-align: left;
  font-weight: bold;
  font-size: 1rem;
}

:deep(.table-td-price) {
  width: 20% !important;
  text-align: left;
  font-weight: bold;
  font-size: 1rem;
}

:deep(.table-td-button) {
  width: 10% !important;
  text-align: center;
}
</style>
