<template>
  <q-page padding>
    <q-table
      flat
      bordered
      class="statement-table"
      title="Articles"
      :rows="articles"
      :hide-header="grid"
      :columns="columns"
      row-key="__index"
      :grid="grid"
      :filter="filter"
      virtual-scroll
      v-model:pagination="pagination"
      :rows-per-page-options="[0]"
    >
      <template v-slot:top-right="props">
        <q-input
          outlined
          dense
          debounce="300"
          v-model="filter"
          placeholder="Search"
        >
          <template v-slot:append>
            <q-icon name="search" />
          </template>
        </q-input>
      </template>
      <template v-slot:body-cell-actions="props">
        <q-td :props="props">
          <q-btn dense round flat color="grey" icon="edit" @click="updateRow(props)"></q-btn>
          <q-btn
            dense
            round
            flat
            color="grey"
            @click="deleteArticle(props)"
            icon="delete"
          ></q-btn>
        </q-td>
      </template>
    </q-table>
    <div class="absolute-bottom text-center q-mb-lg">
      <q-btn
        color="primary"
        icon="add"
        round
        size="1.2rem"
        @click="addArticleDialog = true"
      />
    </div>
    <q-dialog v-model="addArticleDialog">
      <add-article />
    </q-dialog>
    <q-dialog v-model="updateArticleDialog">
      <update-article />
    </q-dialog>
  </q-page>
</template>

<script>
import { defineComponent } from "vue";
import { api } from "boot/axios";
import AddArticle from "../components/articles/modals/AddArticle.vue";
import UpdateArticle from "../components/articles/modals/UpdateArticle.vue";

const columns = [
  { name: "code", align: "center", label: "Code", field: "code" },
  {
    name: "description",
    align: "center",
    label: "Description",
    field: "description",
  },
  {
    name: "taxExclUnitPrice",
    align: "center",
    label: "Tax Exclusive Unit Price",
    field: "taxExclUnitPrice",
  },
  {
    name: "vatRate",
    align: "center",
    label: "Vate rate",
    field: "vatRate",
  },
  {
    name: "taxInclUnitPrice",
    align: "center",
    label: "Tax Inclusive Unit Price",
    field: "taxInclUnitPrice",
  },
  {
    name: "actions",
    align: "center",
    label: "Actions",
  },
];

export default defineComponent({
  data() {
    return {
      columns,
      articles: [],
      addArticleDialog: false,
    };
  },

  components: {
    "add-article": AddArticle,
    "update-article": UpdateArticle,
  },

  mounted() {
    this.getArticles();
  
  },

  methods: {
    getArticles() {
      api
        .get("/articles")
        .then((res) => {
          console.log(res.data);
          this.articles = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteArticle(props) {
      var articlId = props.row.id;
      console.log(articlId);
      api
        .delete(`/articles/${articlId}`)
        .then((res) => {
          console.log(res.data);
          this.getArticles();
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateRow(props) {
      var article = props.row;
      console.log(article);
    //   api
    //     .delete(`/articles/${articlId}`)
    //     .then((res) => {
    //       console.log(res.data);
    //       this.getArticles();
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    },

  },
});
</script>
