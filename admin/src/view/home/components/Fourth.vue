<template>
  <div id="fourth" v-bind="props"></div>
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
  myChart = echarts.init(document.getElementById('fourth') as HTMLElement)
  var option
  var data = [
    {
      name: 'Grandpa',
      children: [
        {
          name: 'Uncle Leo',
          value: 15,
          children: [
            {
              name: 'Cousin Jack',
              value: 2
            },
            {
              name: 'Cousin Mary',
              value: 5,
              children: [
                {
                  name: 'Jackson',
                  value: 2
                }
              ]
            },
            {
              name: 'Cousin Ben',
              value: 4
            }
          ]
        },
        {
          name: 'Father',
          value: 10,
          children: [
            {
              name: 'Me',
              value: 5
            },
            {
              name: 'Brother Peter',
              value: 1
            }
          ]
        }
      ]
    },
    {
      name: 'Nancy',
      children: [
        {
          name: 'Uncle Nike',
          children: [
            {
              name: 'Cousin Betty',
              value: 1
            },
            {
              name: 'Cousin Jenny',
              value: 2
            }
          ]
        }
      ]
    }
  ]

  option = {
    series: {
      type: 'sunburst',
      data: data,
      radius: [60, '90%'],
      itemStyle: {
        borderRadius: 7,
        borderWidth: 2
      },
      label: {
        show: false
      }
    }
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