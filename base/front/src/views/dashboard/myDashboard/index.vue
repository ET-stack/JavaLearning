<template>
  <div class="dashboard-editor-container" style="padding: 20px;background: #f2f2f2;">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <h3>项目介绍</h3>
        <div style="font-size: 15px;text-indent: 2em;padding: 0px;margin-top: 20px;"></div>
      </div>
      <h3>技术</h3>
      <ol>
        <li>开发语言：Java</li>
        <li>数据库：Mysql</li>
        <li>前端框架：Vue + Axios</li>
        <li>后端框架：Spring Boot</li>
        <li>权限：Spring Security</li>
      </ol>
    </el-card>
  </div>
</template>

<script>
import Vue from "vue";
import LightTimeline from "vue-light-timeline";

Vue.use(LightTimeline);

import { getServerInfo } from "@/api/dashboard";
import TransactionTable from "../admin/components/TransactionTable";
import { mapGetters } from "vuex";
import PanThumb from "@/components/PanThumb";

export default {
  name: "DashboardEditor",
  components: { PanThumb, TransactionTable },
  data() {
    return {
      activeNum: Math.round(Math.random() * 10000),
      faceNum: Math.round(Math.random() * 10000)
    };
  },
  created() {},
  methods: {
    jumpUrl(type) {
      switch (type) {
      }
    }
  },
  computed: {
    ...mapGetters(["name", "avatar", "roles", "introduction"])
  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.dashboard-editor-container {
  background-color: #e3e3e3;
  /*min-height: 100vh;*/
  padding: 50px 60px 0px;
}
</style>
