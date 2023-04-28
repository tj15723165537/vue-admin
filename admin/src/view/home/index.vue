<template>
  <div class="home">
    <div class="left">
      <First />
      <Second />
    </div>
    <Map />
    <div class="right">
      <Third />
      <Fourth />
    </div>
  </div>
</template>

<script lang="ts" setup>
import First from '@/view/home/components/First.vue'
import Second from '@/view/home/components/Second.vue'
import Third from '@/view/home/components/Third.vue'
import Fourth from '@/view/home/components/Fourth.vue'
import Map from '@/view/home/components/Map.vue'
</script>
<style lang="scss" scoped>
.content {
  padding: 10px;
}

.home {
  display: grid;
  height: 100%;
  grid-template-columns: 1fr 2fr 1fr;
  //background: #f0f2f5;
  .left,
  .right {
    display: flex;
    flex-direction: column;
    justify-content: space-between;

    > div {
      //background: #f0f2f5;
      border-radius: 5px;
      height: 100%;
      margin: 5px 0;
      padding: 10px;
      box-sizing: border-box;
      background: #f9f9f9;
      box-shadow: -1px -1px 1px 1px #bebebe;
    }
  }
}
</style>
