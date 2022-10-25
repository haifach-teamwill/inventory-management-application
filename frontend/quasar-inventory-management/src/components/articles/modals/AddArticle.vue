<template>
  <q-card>
    <q-toolbar>
      <q-toolbar-title>
        <span class="">Add article </span>
      </q-toolbar-title>

      <q-btn flat round dense icon="close" v-close-popup />
    </q-toolbar>

    <q-card-section>
      <div style="min-width: 270px">
        <q-form
          ref="myForm"
          @submit="submitForm"
          @reset="onReset"
          class="q-gutter-md"
        >
          <div class="q-mb-sm">
            <q-input
              outlined
              v-model="articleToSubmit.code"
              label="code"
              :rules="[(val) => (val && val.length > 0) || 'Code is required']"
            />
          </div>
          <div class="q-mb-sm">
            <q-input
              v-model="articleToSubmit.description"
              outlined
              label="description"
              :rules="[
                (val) => (val && val.length > 0) || 'Description is required',
              ]"
            />
          </div>
          <div class="q-mb-sm">
            <q-select
              outlined
              v-model="articleToSubmit.category"
              :options="categories"
              option-value="id"
              option-label="code"
              label="category"
            />
          </div>

          <div class="q-mb-sm">
            <q-input
              v-model="articleToSubmit.taxExclUnitPrice"
              type="number"
              outlined
              label="Tax exclusive unit price"
              
            />
          </div>
          <div class="q-mb-sm">
            <q-input
              v-model="articleToSubmit.vatRate"
              type="number"
              outlined
              label="Vat rate"
              
            />
          </div>
          <div class="q-mb-sm">
            <q-input
              v-model="articleToSubmit.taxInclUnitPrice"
              type="number"
              outlined
              label="Tax inclusive unit price"
              
            />
          </div>

          <div>
            <q-btn label="Submit" type="submit" color="primary" />
            <q-btn
              label="Reset"
              type="reset"
              color="primary"
              flat
              class="q-ml-sm"
            />
          </div>
        </q-form>
      </div>
    </q-card-section>
  </q-card>
</template>

<script>
import { api } from "boot/axios";

export default {
  data() {
    return {
      categories: [],
      articles:[],
      articleToSubmit: {
        code: "",
        description: "",
        category: "",
        taxExclUnitPrice: "",
        vatRate: "",
        taxInclUnitPrice: "",
      },
    };
  },
  mounted() {
    this.getCategories();
  },
  methods: {
    getCategories() {
      api
        .get("/categories")
        .then((res) => {
          this.categories = res.data;
          // console.log(res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

   
    submitForm() {
      this.$refs.myForm.validate();
      if (!this.$refs.myForm.hasError) {
        this.submitArticle();
      }
    },

    submitArticle() {
      // console.log(this.articleToSubmit);
      api
        .post("/articles", this.articleToSubmit)
        .then((res) => {
          // console.log(res.data);
          this.getArticles()
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getArticles() {
      api
        .get("/articles")
        .then((res) => {
          // console.log(res.data);
          this.articles = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    }, 
  },
};
</script>

<style></style>
