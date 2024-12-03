<template>
  <h1>exames</h1>
  <pre>{{ this.exams }}</pre>
  <pre>{{ this.services }}</pre>
  <v-expansion-panels elevation="0" class="rounded-xl">
    <v-expansion-panel v-for="(items, category) in services" :key="category">
      <v-expansion-panel-title class="v-tabs-service-title text-capitalize">
        {{ category }}
      </v-expansion-panel-title>
      <v-expansion-panel-text>
        <v-list>
          <v-list-item
            v-for="item in items"
            :key="item.id"
            class="v-tabs-item-list-container"
          >
            <v-table class="v-tabs-item-list">
              <tbody>
                <tr>
                  <td class="table-td-title">{{ item.title }}</td>
                  <td class="table-td-price">R$ {{ item.price }},00</td>
                  <td class="table-td-button">
                    <v-btn
                      density="compact"
                      icon="mdi-cart-plus"
                      size="large"
                      color="#723ab3"
                      variant="tonal"
                      elevation="0"
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
      type: Array,
      required: true,
      default: () => [],
    },
  },
  exams: {
    type: Array,
    required: true,
  },
  mounted() {
    console.log("👉 this.services => ", this.services);
  },
  methods: {
    selectExam(exam) {
      this.$emit("select-exam", exam);
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

:deep(.table-td-title) {
  width: 60% !important;
  text-align: left;
  font-weight: semi-bold;
  font-size: 1rem;
}

:deep(.table-td-price) {
  width: 20% !important;
  text-align: left;
  font-weight: semi-bold;
  font-size: 1rem;
}

:deep(.table-td-button) {
  width: 10% !important;
  text-align: right;
}

:deep(.mdi-cart-plus) {
  font-size: 1.1rem;
  /* color: #723ab3; */
}

:deep(.v-expansion-panel) {
  border-radius: 8px !important;
}

.v-tabs-item-list {
  padding: 0 15px 0 15px !important;
  border-radius: 8px !important;
  width: 100% !important;
  max-width: 100% !important;
}

.v-tabs-item-list:hover {
  background-color: #f5f5f5;
  border-radius: 8px !important;
}

.v-tabs-item-list-container {
  width: 100% !important;
  max-width: 100% !important;
}
</style>
