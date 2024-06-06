<template>
  <div id="app">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import NavMenu from '@/components/NavMenu'

  export default {
    name: 'App',
    components: {
      'navmenu': NavMenu
    }
  }
</script>

<style>
  .form {
    width: 200px;
  }
</style>
