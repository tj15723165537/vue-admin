<template>
  <div id="third" v-bind="props"></div>
</template>
<script lang="ts" setup>
import * as echarts from 'echarts'
import type { EChartsType } from 'echarts'
import { nextTick, onBeforeUnmount } from 'vue'

let myChart: EChartsType | null = null
const props = {
  style: {
    height: '50%'
  }
}
nextTick(() => {
  myChart = echarts.init(document.getElementById('third') as HTMLElement)
  var option
  option = {
    tooltip: {
      trigger: 'item'
    },
    legend: {},
    series: [
      {
        name: 'Access From',
        type: 'pie',
        radius: ['40%', '70%'],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: '#fff',
          borderWidth: 2
        },
        label: {
          show: false,
          position: 'center'
        },
        labelLine: {
          show: false
        },
        data: [
          { value: 580, name: 'Email' },
          { value: 484, name: 'Union Ads' },
          { value: 300, name: 'Video Ads' }
        ]
      }
    ]
  }

  option && myChart.setOption(option)
  window.addEventListener('resize', () => {
    myChart?.resize()
  })
})

onBeforeUnmount(() => {
  window.removeEventListener('resize', () => {
    myChart?.resize()
  })
})
</script>
<style scoped></style>
