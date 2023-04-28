<template>
  <div id="map"></div>
</template>

<script lang="ts" setup>
import { nextTick } from 'vue'

nextTick(() => {
  var map = new BMapGL.Map('map')
  map.centerAndZoom(new BMapGL.Point(106.5518, 29.5627), 13)
  map.enableScrollWheelZoom(true)
})
</script>
<style lang="scss" scoped>
#map {
  border-radius: 5px;
  margin: 5px 10px;
  box-shadow: -1px -1px 1px 1px #bebebe;
}
</style>
